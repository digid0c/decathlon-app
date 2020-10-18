package com.example.decathlon.web.controller.api.v1;

import com.example.decathlon.service.DecathlonCalculatorService;
import com.example.decathlon.web.dto.request.DecathlonResultCalculationRequestDto;
import com.example.decathlon.web.dto.response.DecathlonResultCalculationResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.example.decathlon.web.controller.api.v1.DecathlonController.ENDPOINT_VERSION_BASE_URI;

@RestController
@RequiredArgsConstructor
@RequestMapping(ENDPOINT_VERSION_BASE_URI)
public class DecathlonController {

    public static final String ENDPOINT_VERSION_BASE_URI = "/api/v1";

    private final DecathlonCalculatorService decathlonCalculatorService;

    @PostMapping("/calculate")
    public DecathlonResultCalculationResponseDto calculate(@Valid @RequestBody DecathlonResultCalculationRequestDto request) {
        Long points = decathlonCalculatorService.calculate(request.getDiscipline(), request.getResult());
        return new DecathlonResultCalculationResponseDto(points);
    }
}
