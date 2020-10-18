package com.example.decathlon.service.calculator;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;

class LongRunCalculator extends DecathlonCalculator {

    LongRunCalculator() {

    }

    @Override
    protected BigDecimal getA() {
        return valueOf(0.03768);
    }

    @Override
    protected BigDecimal getB() {
        return valueOf(480);
    }

    @Override
    protected BigDecimal getC() {
        return valueOf(1.85);
    }
}
