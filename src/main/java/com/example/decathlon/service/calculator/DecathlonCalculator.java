package com.example.decathlon.service.calculator;

import java.math.BigDecimal;

import static ch.obermuhlner.math.big.BigDecimalMath.pow;
import static java.math.BigDecimal.ZERO;
import static java.math.MathContext.DECIMAL32;
import static org.springframework.util.Assert.isTrue;

/**
 * Abstract base calculator model, which uses Template Method to hide concrete implementations from external clients.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Decathlon">Decathlon rules and points system</a>
 * @see <a href="https://github.com/eobermuhlner/big-math">External big math library used to calculate powered {@link BigDecimal} instances</a>
 *
 * @author Sergey Spirin
 */
public abstract class DecathlonCalculator {

    public Long calculate(BigDecimal result) {
        isTrue(result != null && result.compareTo(ZERO) > 0, "Result must be positive");
        BigDecimal modulus = result.subtract(getB()).abs();
        return pow(modulus, getC(), DECIMAL32).multiply(getA()).longValue();
    }

    protected abstract BigDecimal getA();

    protected abstract BigDecimal getB();

    protected abstract BigDecimal getC();
}
