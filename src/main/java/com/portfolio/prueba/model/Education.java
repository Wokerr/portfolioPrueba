package com.portfolio.prueba.model;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Education {
    private Long id;

    @NotBlank(message = "Field degree cannot be empty")
    private String degree;

    @NotBlank(message = "Field institution cannot be empty")
    private String institution;
    
    @NotNull
    @PastOrPresent
    private LocalDate startDate;
    
    @PastOrPresent
    private LocalDate endDate; // Can be null if its in progress
    
    @NotBlank(message = "Field description cannot be empty")
    private String description;
    private Long PersonalInfoId; // Foreing key to PersonalInfo
}
