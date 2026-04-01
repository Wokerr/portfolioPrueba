package com.portfolio.prueba.repository;

import java.util.List;
import java.util.Optional;

import com.portfolio.prueba.model.Experience;

public interface IExperienceRepository {

    List<Experience> findAll();
    
    Optional<Experience> findById(Long id);
    
    Experience save(Experience experience);
    
    void deleteById(Long id);
    
    List<Experience> findByPersonalInfoId(Long personalInfoId);
}
