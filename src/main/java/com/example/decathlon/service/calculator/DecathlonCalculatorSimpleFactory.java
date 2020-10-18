package com.example.decathlon.service.calculator;

import java.util.Map;

import static com.example.decathlon.service.calculator.DisciplineType.*;
import static java.util.Map.of;
import static java.util.Optional.ofNullable;
import static org.springframework.util.Assert.notNull;

/**
 * This factory is responsible for creating concrete {@link DecathlonCalculator} instances. This is the only class, which
 * should know about {@link DecathlonCalculator} concrete implementations.
 *
 * @author Sergey Spirin
 */
public class DecathlonCalculatorSimpleFactory {

    private static final Map<DisciplineType, DecathlonCalculator> CALCULATORS_CACHE = of(
            SHORT_RUN, new ShortRunCalculator(),
            LONG_JUMP, new LongJumpCalculator(),
            SHOT_PUT, new ShotPutCalculator(),
            HIGH_JUMP, new HighJumpCalculator(),
            MEDIUM_RUN, new MediumRunCalculator(),
            HURDLES_RUN, new HurdlesRunCalculator(),
            DISCUS_THROW, new DiscusThrowCalculator(),
            POLE_VAULTING, new PoleVaultingCalculator(),
            JAVELIN_THROWING, new JavelinThrowingCalculator(),
            LONG_RUN, new LongRunCalculator()
    );

    private DecathlonCalculatorSimpleFactory() {

    }

    public static DecathlonCalculator create(DisciplineType disciplineType) {
        notNull(disciplineType, "Discipline type must be defined");
        return ofNullable(CALCULATORS_CACHE.get(disciplineType))
                .orElseThrow(() -> new IllegalArgumentException("Discipline type is not supported"));
    }
}
