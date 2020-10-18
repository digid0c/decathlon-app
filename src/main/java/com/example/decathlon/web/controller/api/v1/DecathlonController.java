package com.example.decathlon.web.controller.api.v1;

import com.example.decathlon.service.DecathlonCalculatorService;
import com.example.decathlon.web.dto.request.DecathlonResultCalculationRequestDto;
import com.example.decathlon.web.dto.response.DecathlonResultCalculationResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.example.decathlon.web.controller.api.v1.DecathlonController.ENDPOINT_VERSION_BASE_URI;
import static com.example.decathlon.web.exception.RestExceptionHandler.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ENDPOINT_VERSION_BASE_URI)
@Tag(name = "Decathlon API", description = "Processes incoming decathlon calculation requests")
public class DecathlonController {

    public static final String ENDPOINT_VERSION_BASE_URI = "/api/v1";

    private final DecathlonCalculatorService decathlonCalculatorService;

    @PostMapping("/calculate")
    @Operation(description = "Allows to calculate points for a result in some discipline", responses = {
            @ApiResponse(responseCode = OK_RESPONSE_CODE, description = "Returned in case calculation is successful"),
            @ApiResponse(responseCode = BAD_REQUEST_RESPONSE_CODE, description = "Returned in case parameters validation fails"),
            @ApiResponse(responseCode = INTERNAL_SERVER_ERROR_RESPONSE_CODE, description = "Returned in case of other exception")
    })
    public DecathlonResultCalculationResponseDto calculate(@Valid @RequestBody DecathlonResultCalculationRequestDto request) {
        Long points = decathlonCalculatorService.calculate(request.getDiscipline(), request.getResult());
        return new DecathlonResultCalculationResponseDto(points);
    }
}
