package com.portfolio.prueba.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.portfolio.prueba.model.Skill;
import com.portfolio.prueba.service.ISkillService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/skill")
@RequiredArgsConstructor
public class SkillController {
    private final ISkillService skillService;

    @GetMapping
    public List<Skill> findAll() {
        return skillService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Skill> findById(@PathVariable Long id) {
        return skillService.findById(id);
    }
    @GetMapping("/personal-info/{id}")
    public List<Skill> findSkillsByPersonalInfoId(@PathVariable("id") Long personalInfoId){
        return skillService.findByPersonalInfoId(personalInfoId);
    }

    @PostMapping
    public Skill save(@RequestBody Skill skill) {
        return skillService.save(skill);
    }

    @PutMapping("/{id}")
    public Skill update(@PathVariable Long id,@Valid @RequestBody Skill skill) {
        skill.setId(id);
        return skillService.save(skill);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        skillService.deleteById(id);
    }
}