package com.example.decathlon.web.controller.api.v1;

import com.example.decathlon.service.DecathlonCalculatorService;
import com.example.decathlon.web.dto.request.DecathlonResultCalculationRequestDto;
import com.example.decathlon.web.exception.RestExceptionHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static com.example.decathlon.service.calculator.DisciplineType.POLE_VAULTING;
import static com.example.decathlon.service.calculator.DisciplineType.SHORT_RUN;
import static com.example.decathlon.web.controller.api.v1.DecathlonController.ENDPOINT_VERSION_BASE_URI;
import static java.math.BigDecimal.ZERO;
import static java.math.BigDecimal.valueOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
public class DecathlonControllerUnitTest {

    private static final String TEST_URI = ENDPOINT_VERSION_BASE_URI + "/calculate";

    private static final String SHORT_RUN_DISCIPLINE = SHORT_RUN.name();
    private static final BigDecimal SHORT_RUN_RESULT = valueOf(8);
    private static final Long SHORT_RUN_POINTS = 1642L;

    private static final String POLE_VAULTING_DISCIPLINE = POLE_VAULTING.name();
    private static final BigDecimal POLE_VAULTING_RESULT = valueOf(12);
    private static final Long POLE_VAULTING_POINTS = 3569L;

    private static final String UNKNOWN_DISCIPLINE = "rolling, rolling...";

    @Mock
    private DecathlonCalculatorService decathlonCalculatorService;

    @Mock
    private MessageSource messageSource;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        initMocks(this);
        DecathlonController tested = new DecathlonController(decathlonCalculatorService);
        mockMvc = standaloneSetup(tested)
                .setControllerAdvice(new RestExceptionHandler(messageSource))
                .build();
    }

    @Test
    public void shouldCalculatePointsForCorrectRequest() throws Exception {
        when(decathlonCalculatorService.calculate(eq(SHORT_RUN_DISCIPLINE), eq(SHORT_RUN_RESULT))).thenReturn(SHORT_RUN_POINTS);

        mockMvc.perform(post(TEST_URI)
                .accept(APPLICATION_JSON)
                .contentType(APPLICATION_JSON)
                .content(asJsonString(new DecathlonResultCalculationRequestDto(SHORT_RUN_DISCIPLINE, SHORT_RUN_RESULT))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.points", is(equalTo(SHORT_RUN_POINTS.intValue()))));
    }

    @Test
    public void shouldCalculatePointsForAnotherCorrectRequest() throws Exception {
        when(decathlonCalculatorService.calculate(eq(POLE_VAULTING_DISCIPLINE), eq(POLE_VAULTING_RESULT))).thenReturn(POLE_VAULTING_POINTS);

        mockMvc.perform(post(TEST_URI)
                .accept(APPLICATION_JSON)
                .contentType(APPLICATION_JSON)
                .content(asJsonString(new DecathlonResultCalculationRequestDto(POLE_VAULTING_DISCIPLINE, POLE_VAULTING_RESULT))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.points", is(equalTo(POLE_VAULTING_POINTS.intValue()))));
    }

    @Test
    public void shouldNotCalculatePointsForNullDiscipline() throws Exception {
        shouldNotCalculatePointsForIncorrectDiscipline(null);
    }

    @Test
    public void shouldNotCalculatePointsForEmptyDiscipline() throws Exception {
        shouldNotCalculatePointsForIncorrectDiscipline("");
    }

    @Test
    public void shouldNotCalculatePointsForUnknownDiscipline() throws Exception {
        shouldNotCalculatePointsForIncorrectDiscipline(UNKNOWN_DISCIPLINE);
    }

    @Test
    public void shouldNotCalculatePointsForNullResult() throws Exception {
        shouldNotCalculatePointsForIncorrectResult(null);
    }

    @Test
    public void shouldNotCalculatePointsForNegativeResult() throws Exception {
        shouldNotCalculatePointsForIncorrectResult(valueOf(-1L));
    }

    @Test
    public void shouldNotCalculatePointsForZeroResult() throws Exception {
        shouldNotCalculatePointsForIncorrectResult(ZERO);
    }

    private void shouldNotCalculatePointsForIncorrectDiscipline(String incorrectDiscipline) throws Exception {
        mockMvc.perform(post(TEST_URI)
                .accept(APPLICATION_JSON)
                .contentType(APPLICATION_JSON)
                .content(asJsonString(new DecathlonResultCalculationRequestDto(incorrectDiscipline, SHORT_RUN_RESULT))))
                .andExpect(status().isBadRequest());
    }

    private void shouldNotCalculatePointsForIncorrectResult(BigDecimal incorrectResult) throws Exception {
        mockMvc.perform(post(TEST_URI)
                .accept(APPLICATION_JSON)
                .contentType(APPLICATION_JSON)
                .content(asJsonString(new DecathlonResultCalculationRequestDto(SHORT_RUN_DISCIPLINE, incorrectResult))))
                .andExpect(status().isBadRequest());
    }

    private String asJsonString(final Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
