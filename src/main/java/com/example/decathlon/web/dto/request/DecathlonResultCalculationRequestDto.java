package com.example.decathlon.web.dto.request;

import com.example.decathlon.web.validation.ValidDisciplineType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Calculation request DTO used to pass in calculation parameters")
public class DecathlonResultCalculationRequestDto {

    @NotBlank
    @ValidDisciplineType
    @Schema(description = "Official discipline type name", allowableValues = {"SHORT_RUN", "LONG_JUMP", "SHOT_PUT", "HIGH_JUMP",
            "MEDIUM_RUN", "HURDLES_RUN", "DISCUS_THROW", "POLE_VAULTING", "JAVELIN_THROWING", "LONG_RUN"}, required = true)
    private String discipline;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Schema(description = "Fractional number representing result in a concrete discipline, must be strictly greater than zero", required = true)
    private BigDecimal result;
}
