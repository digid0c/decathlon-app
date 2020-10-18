package com.example.decathlon.service.calculator;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;

class HighJumpCalculator extends DecathlonCalculator {

    HighJumpCalculator() {

    }

    @Override
    protected BigDecimal getA() {
        return valueOf(585.64);
    }

    @Override
    protected BigDecimal getB() {
        return valueOf(0.75);
    }

    @Override
    protected BigDecimal getC() {
        return valueOf(1.42);
    }
}
