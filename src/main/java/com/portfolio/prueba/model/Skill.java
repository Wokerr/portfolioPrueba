package com.portfolio.prueba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Skill {
    private Long id;
    private String name;
    private Integer levelPercetage; // Progress Bar
    private String iconClass;
    private Long perosnalInfo; // Foreing key to PersonalInfo
}
