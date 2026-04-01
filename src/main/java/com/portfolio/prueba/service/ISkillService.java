package com.portfolio.prueba.service;

import java.util.List;
import java.util.Optional;

import com.portfolio.prueba.model.Skill;

public interface ISkillService {
    
    Skill save(Skill skill);

    Optional<Skill> findById(Long id);
    
    List<Skill> findAll();

    void deleteById(Long id);

    List<Skill> findByPersonalInfoId(Long personalInfoId);

}
