package com.example.decathlon.service.calculator;

import org.junit.jupiter.api.Test;

import static com.example.decathlon.service.calculator.DecathlonCalculatorSimpleFactory.create;
import static com.example.decathlon.service.calculator.DisciplineType.LONG_RUN;
import static com.example.decathlon.service.calculator.DisciplineType.SHORT_RUN;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DecathlonCalculatorSimpleFactoryUnitTest {

    @Test
    public void shouldSuccessfullyCreateCalculatorInstance() {
        DecathlonCalculator calculator = create(SHORT_RUN);

        assertThat(calculator, is(notNullValue()));
        assertThat(calculator, is(instanceOf(ShortRunCalculator.class)));
    }

    @Test
    public void shouldSuccessfullyCreateAnotherCalculatorInstance() {
        DecathlonCalculator calculator = create(LONG_RUN);

        assertThat(calculator, is(notNullValue()));
        assertThat(calculator, is(instanceOf(LongRunCalculator.class)));
    }

    @Test
    public void shouldNotCreateCalculatorInstance() {
        assertThrows(IllegalArgumentException.class, () -> create(null));
    }
}
