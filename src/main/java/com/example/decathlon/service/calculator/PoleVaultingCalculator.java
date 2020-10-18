package com.example.decathlon.service.calculator;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.valueOf;

class PoleVaultingCalculator extends DecathlonCalculator {

    PoleVaultingCalculator() {

    }

    @Override
    protected BigDecimal getA() {
        return valueOf(140.182);
    }

    @Override
    protected BigDecimal getB() {
        return ONE;
    }

    @Override
    protected BigDecimal getC() {
        return valueOf(1.35);
    }
}
