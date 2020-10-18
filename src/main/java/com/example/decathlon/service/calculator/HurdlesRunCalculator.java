package com.example.decathlon.service.calculator;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;

class HurdlesRunCalculator extends DecathlonCalculator {

    HurdlesRunCalculator() {

    }

    @Override
    protected BigDecimal getA() {
        return valueOf(5.74354);
    }

    @Override
    protected BigDecimal getB() {
        return valueOf(28.5);
    }

    @Override
    protected BigDecimal getC() {
        return valueOf(1.92);
    }
}
