package com.example.decathlon.web.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Calculation response DTO used to return processed calculation result")
public class DecathlonResultCalculationResponseDto {

    @NotNull
    @Positive
    @Schema(description = "Calculation result expressed in integer points, must be positive", required = true)
    private Long points;
}
