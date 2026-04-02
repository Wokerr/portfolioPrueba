package com.portfolio.prueba.rest;

import java.util.List;

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

import com.portfolio.prueba.model.Experience;
import com.portfolio.prueba.service.IExperienceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/experience")
public class ExperienceController {

    private final IExperienceService experienceService;

    // Get endpoints

    @GetMapping
    public List<Experience> getAll() {
        return experienceService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experience> getById(@PathVariable Long id) {
        return experienceService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{personalInfoId}/all")
    public List<Experience> getByPersonalInfoId(@PathVariable Long personalInfoId) {
        return experienceService.findExperienceByPersonalInfoId(personalInfoId);
    }

    // Post endpoints

    @PostMapping
    public ResponseEntity<Experience> createExperience(@RequestBody Experience experience) {
        return new ResponseEntity<>(experienceService.save(experience), HttpStatus.CREATED);
    }

    // Put endpoints

    @PutMapping("/{id}")
    public Experience modifyExperience(@PathVariable Long id, @RequestBody Experience experience) {
        experience.setId(id);
        return experienceService.save(experience);
    }

    // Delete endpoints

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        experienceService.deleteById(id);
    }

}
