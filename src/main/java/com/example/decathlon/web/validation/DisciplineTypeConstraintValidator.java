package com.example.decathlon.web.validation;

import com.example.decathlon.service.calculator.DisciplineType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.util.Arrays.stream;

public class DisciplineTypeConstraintValidator implements ConstraintValidator<ValidDisciplineType, String> {

    @Override
    public void initialize(ValidDisciplineType constraintAnnotation) {
        //intentionally left blank
    }

    @Override
    public boolean isValid(String discipline, ConstraintValidatorContext context) {
        return stream(DisciplineType.values())
                .map(DisciplineType::name)
                .anyMatch(disciplineType -> discipline != null && disciplineType.equals(discipline.toUpperCase()));
    }
}
