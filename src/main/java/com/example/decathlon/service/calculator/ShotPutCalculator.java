package com.example.decathlon.service.calculator;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;

class ShotPutCalculator extends DecathlonCalculator {

    ShotPutCalculator() {

    }

    @Override
    protected BigDecimal getA() {
        return valueOf(51.39);
    }

    @Override
    protected BigDecimal getB() {
        return valueOf(1.5);
    }

    @Override
    protected BigDecimal getC() {
        return valueOf(1.05);
    }
}
