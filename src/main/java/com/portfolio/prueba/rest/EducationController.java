package com.portfolio.prueba.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.prueba.service.IEducationService;
import com.portfolio.prueba.model.Education;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/education")
public class EducationController {

    private final IEducationService educationService;

    // Get Endpoints

    @GetMapping("/all")
    public List<Education> getAllEducation() {
        return educationService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Education> getById(@PathVariable Long id) {
        return educationService.findById(id);
    }

    @GetMapping("/{personalInfoId}/all")
    public List<Education> getByPersonalInfoId(@PathVariable Long personalInfoId) {
        return educationService.findByPersonalInfoId(personalInfoId);
    }

    // Post Endpoints

    @PostMapping
    public ResponseEntity<Education> createEducation(@RequestBody Education education) {
        Education newEducation = educationService.save(education);
        return new ResponseEntity<>(newEducation, HttpStatus.CREATED);
    }

    // Put Endpoints

    @PutMapping("/{id}")
    public Education update(@PathVariable Long id, @RequestBody Education education) {
        education.setId(id);
        return educationService.save(education);
    }

    // Delete endpoints

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        educationService.deleteById(id);
    }

}
