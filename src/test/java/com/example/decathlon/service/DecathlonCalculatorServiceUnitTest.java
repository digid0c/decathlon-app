package com.example.decathlon.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.example.decathlon.service.calculator.DisciplineType.POLE_VAULTING;
import static com.example.decathlon.service.calculator.DisciplineType.SHORT_RUN;
import static java.math.BigDecimal.valueOf;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DecathlonCalculatorServiceUnitTest {

    private static final BigDecimal EIGHT_SECONDS = valueOf(8);
    private static final BigDecimal TWELVE_METERS = valueOf(12);
    private static final String UNKNOWN_DISCIPLINE = "rolling, rolling...";

    private DecathlonCalculatorService tested;

    @BeforeEach
    public void setUp() {
        tested = new DecathlonCalculatorServiceImpl();
    }

    @Test
    public void shouldCalculateResultForCorrectDiscipline() {
        Long points = tested.calculate(SHORT_RUN.name(), EIGHT_SECONDS);

        assertThat(points, is(notNullValue()));
        assertThat(points, is(equalTo(1642L)));
    }

    @Test
    public void shouldCalculateResultForAnotherCorrectDiscipline() {
        Long points = tested.calculate(POLE_VAULTING.name(), TWELVE_METERS);

        assertThat(points, is(notNullValue()));
        assertThat(points, is(equalTo(3569L)));
    }

    @Test
    public void shouldNotCalculateResultForNullDiscipline() {
        assertThrows(IllegalArgumentException.class, () -> tested.calculate(null, EIGHT_SECONDS));
    }

    @Test
    public void shouldNotCalculateResultForEmptyDiscipline() {
        assertThrows(IllegalArgumentException.class, () -> tested.calculate("", EIGHT_SECONDS));
    }

    @Test
    public void shouldNotCalculateResultForUnknownDiscipline() {
        assertThrows(IllegalArgumentException.class, () -> tested.calculate(UNKNOWN_DISCIPLINE, TWELVE_METERS));
    }
}
