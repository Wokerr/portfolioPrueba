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

import org.springframework.web.server.ResponseStatusException;

import com.portfolio.prueba.service.IPersonalInfoService;

import jakarta.validation.Valid;

import com.portfolio.prueba.model.PersonalInfo;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/personal-info")
@RequiredArgsConstructor

public class PersonalInfoTestController {

    private final IPersonalInfoService personalInfoService;

    @GetMapping("/all")
    public List<PersonalInfo> getAllPersonalInfo() {
        return personalInfoService.findAll();
    }

    @GetMapping("/{id}")
    public PersonalInfo getById(@PathVariable Long id) {
        Optional<PersonalInfo> info = personalInfoService.findById(id);

        if (info.isPresent()) {
            return info.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Personal information not found with ID: " + id);
        }
    }
    
    @PostMapping({"", "/"})
    public ResponseEntity<PersonalInfo> createPerosnalInfo(@Valid @RequestBody PersonalInfo personalInfo) {
        PersonalInfo newPersonalInfo = personalInfoService.save(personalInfo);

        return new ResponseEntity<>(newPersonalInfo, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public PersonalInfo update(@PathVariable Long id, @Valid @RequestBody PersonalInfo personalInfo) {
        personalInfo.setId(id);

        return personalInfoService.save(personalInfo);
    }

    @DeleteMapping("/{id}")
    public void deleteBy(@PathVariable Long id){
        personalInfoService.deleteById(id);
    }
}
