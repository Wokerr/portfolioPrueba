package com.portfolio.prueba.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PersonalInfo {
    private Long id;
    
    @NotBlank(message = "Field name cannot be empty")
    private String firstName;
    @NotBlank(message = "Last name field cannot be empty")
    private String lastName;
    @NotBlank(message = "Title field cannot be empty")
    private String title;
    @NotBlank(message = "Profile description field cannot be empty")
    private String profileDescription;
    @NotBlank(message = "The URL image field cannot be empty")
    private String profileImageUrl;
    @Min(value = 0)
    private Integer yearsOfExperience;
    @Email
    private String email;
    @NotBlank(message = "Phone number field cannot be empty")
    private String phone;
    @NotBlank(message = "Your Linkedin must be included")
    private String linkedinUrl;
    @NotBlank(message = "Your Github must be included")
    private String githubUrl;

}
