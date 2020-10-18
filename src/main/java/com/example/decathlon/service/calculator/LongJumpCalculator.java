package com.example.decathlon.service.calculator;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;

class LongJumpCalculator extends DecathlonCalculator {

    LongJumpCalculator() {

    }

    @Override
    protected BigDecimal getA() {
        return valueOf(90.5674);
    }

    @Override
    protected BigDecimal getB() {
        return valueOf(2.2);
    }

    @Override
    protected BigDecimal getC() {
        return valueOf(1.4);
    }
}
