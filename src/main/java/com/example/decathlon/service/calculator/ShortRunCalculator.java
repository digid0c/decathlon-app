package com.example.decathlon.service.calculator;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;

class ShortRunCalculator extends DecathlonCalculator {

    ShortRunCalculator() {

    }

    @Override
    protected BigDecimal getA() {
        return valueOf(25.4348);
    }

    @Override
    protected BigDecimal getB() {
        return valueOf(18);
    }

    @Override
    protected BigDecimal getC() {
        return valueOf(1.81);
    }
}
