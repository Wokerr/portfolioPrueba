package com.portfolio.prueba.service;

import java.util.List;
import java.util.Optional;

import com.portfolio.prueba.model.Experience;

public interface IExperienceService {

    List<Experience> findAll();

    Optional<Experience> findById(Long id);

    Experience save(Experience experience);
    
    void deleteById(Long id);

    List<Experience> findExperienceByPersonalInfoId(Long personalInfoId);
    
}
