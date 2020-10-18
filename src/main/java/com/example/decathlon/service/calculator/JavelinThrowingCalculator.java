package com.example.decathlon.service.calculator;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;

class JavelinThrowingCalculator extends DecathlonCalculator {

    JavelinThrowingCalculator() {

    }

    @Override
    protected BigDecimal getA() {
        return valueOf(10.14);
    }

    @Override
    protected BigDecimal getB() {
        return valueOf(7);
    }

    @Override
    protected BigDecimal getC() {
        return valueOf(1.08);
    }
}
