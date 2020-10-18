package com.example.decathlon.service.calculator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.example.decathlon.service.calculator.DecathlonCalculatorSimpleFactory.create;
import static com.example.decathlon.service.calculator.DisciplineType.*;
import static java.math.BigDecimal.ZERO;
import static java.math.BigDecimal.valueOf;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DecathlonCalculatorUnitTest {

    private static final BigDecimal EIGHT_SECONDS = valueOf(8);
    private static final BigDecimal TWELVE_METERS = valueOf(12);

    private DecathlonCalculator tested;

    @Test
    public void shouldNotCalculateNullResult() {
        tested = create(SHORT_RUN);
        assertThrows(IllegalArgumentException.class, () -> tested.calculate(null));
    }

    @Test
    public void shouldNotCalculateNegativeResult() {
        tested = create(SHORT_RUN);
        assertThrows(IllegalArgumentException.class, () -> tested.calculate(valueOf(-1L)));
    }

    @Test
    public void shouldNotCalculateZeroResult() {
        tested = create(SHORT_RUN);
        assertThrows(IllegalArgumentException.class, () -> tested.calculate(ZERO));
    }

    @Test
    public void shouldCalculateCorrectShortRunResult() {
        tested = create(SHORT_RUN);
        Long result = tested.calculate(EIGHT_SECONDS);

        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(1642L)));
    }

    @Test
    public void shouldCalculateCorrectLongJumpResult() {
        tested = create(LONG_JUMP);
        Long result = tested.calculate(TWELVE_METERS);

        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(2211L)));
    }

    @Test
    public void shouldCalculateCorrectShotPutResult() {
        tested = create(SHOT_PUT);
        Long result = tested.calculate(TWELVE_METERS);

        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(606L)));
    }

    @Test
    public void shouldCalculateCorrectHighJumpResult() {
        tested = create(HIGH_JUMP);
        Long result = tested.calculate(TWELVE_METERS);

        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(18208L)));
    }

    @Test
    public void shouldCalculateCorrectMediumRunResult() {
        tested = create(MEDIUM_RUN);
        Long result = tested.calculate(EIGHT_SECONDS);

        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(3717L)));
    }

    @Test
    public void shouldCalculateCorrectHurdlesRunResult() {
        tested = create(HURDLES_RUN);
        Long result = tested.calculate(EIGHT_SECONDS);

        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(1895L)));
    }

    @Test
    public void shouldCalculateCorrectDiscusThrowResult() {
        tested = create(DISCUS_THROW);
        Long result = tested.calculate(TWELVE_METERS);

        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(127L)));
    }

    @Test
    public void shouldCalculateCorrectPoleVaultingResult() {
        tested = create(POLE_VAULTING);
        Long result = tested.calculate(TWELVE_METERS);

        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(3569L)));
    }

    @Test
    public void shouldCalculateCorrectJavelinThrowingResult() {
        tested = create(JAVELIN_THROWING);
        Long result = tested.calculate(TWELVE_METERS);

        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(57L)));
    }

    @Test
    public void shouldCalculateCorrectLongRunResult() {
        tested = create(LONG_RUN);
        Long result = tested.calculate(EIGHT_SECONDS);

        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(3333L)));
    }
}
