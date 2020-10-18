package com.example.decathlon.service;

import com.example.decathlon.service.calculator.DecathlonCalculator;
import com.example.decathlon.service.calculator.DisciplineType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.example.decathlon.service.calculator.DecathlonCalculatorSimpleFactory.create;
import static com.example.decathlon.service.calculator.DisciplineType.valueOf;
import static org.springframework.util.Assert.hasText;

/**
 * Service responsible for processing calculation requests.
 *
 * @author Sergey Spirin
 */
@Service
public class DecathlonCalculatorServiceImpl implements DecathlonCalculatorService {

    @Override
    public Long calculate(String discipline, BigDecimal result) {
        hasText(discipline, "Discipline must be defined");
        DisciplineType disciplineType = valueOf(discipline.toUpperCase());

        DecathlonCalculator calculator = create(disciplineType);
        return calculator.calculate(result);
    }
}
