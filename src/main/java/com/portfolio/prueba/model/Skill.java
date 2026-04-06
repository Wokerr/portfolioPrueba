package com.portfolio.prueba.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Skill {
    private Long id;
    @NotBlank(message = "Field name cannot be empty")
    private String name;

    @NotNull
    @Min(value = 0)
    @Max(value = 100)
    private Integer levelPercentage; // Progress Bar

    @NotBlank(message = "You must have an Icon")
    private String iconClass;
    private Long perosnalInfo; // Foreing key to PersonalInfo
}
