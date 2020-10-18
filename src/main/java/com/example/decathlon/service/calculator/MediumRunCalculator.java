package com.example.decathlon.service.calculator;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;

class MediumRunCalculator extends DecathlonCalculator {

    MediumRunCalculator() {

    }

    @Override
    protected BigDecimal getA() {
        return valueOf(1.53775);
    }

    @Override
    protected BigDecimal getB() {
        return valueOf(82);
    }

    @Override
    protected BigDecimal getC() {
        return valueOf(1.81);
    }
}
