package com.portfolio.prueba.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Experience {

    private Long id;

    @NotBlank(message = "Field job tittle cannot be empty")
    private String jobTitle;
    @NotBlank(message = "Field company name tittle cannot be empty")
    private String companyName;
    
    @NotNull
    @PastOrPresent
    private LocalDate startDate;
    
    @PastOrPresent
    private LocalDate endDate;

    @NotBlank(message = "Field description tittle cannot be empty")
    private String description;

    private Long personalInfoId; // Foreing key to PersonalInfo

}
