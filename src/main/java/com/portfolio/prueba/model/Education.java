package com.portfolio.prueba.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Education {
    private Long id;
    private String degree;
    private String institution;
    private LocalDate starDate;
    private LocalDate endDate; // Can be null if its in progress
    private String description;
    private Long PersonalInfoId; // Foreing key to PersonalInfo
}
