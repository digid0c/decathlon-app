package com.example.decathlon.service.calculator;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;

class DiscusThrowCalculator extends DecathlonCalculator {

    DiscusThrowCalculator() {

    }

    @Override
    protected BigDecimal getA() {
        return valueOf(12.91);
    }

    @Override
    protected BigDecimal getB() {
        return valueOf(4);
    }

    @Override
    protected BigDecimal getC() {
        return valueOf(1.1);
    }
}
