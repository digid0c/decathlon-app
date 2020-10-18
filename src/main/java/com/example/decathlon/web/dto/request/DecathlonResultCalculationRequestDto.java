package com.example.decathlon.web.dto.request;

import com.example.decathlon.web.validation.ValidDisciplineType;
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
public class DecathlonResultCalculationRequestDto {

    @NotBlank
    @ValidDisciplineType
    private String discipline;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal result;
}
