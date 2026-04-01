package com.portfolio.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.portfolio.prueba.model.Education;
import com.portfolio.prueba.repository.IEducationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements IEducationService {
    
    private final IEducationRepository educationRepository;

    @Override
    public Education save(Education edu) {

        if (edu.getStartDate() == null)
        {
            throw new IllegalArgumentException("Field start date cannot be empty");
        }

        if (edu.getEndDate() != null && edu.getEndDate().isBefore(edu.getStartDate())) 
        {
            throw new IllegalArgumentException("End date cannot be before start date");    
        }

        if (edu.getDegree() == null || edu.getDegree().isBlank()) 
        {
            throw new IllegalArgumentException("Field degree cannot be empty");
        }

        if (edu.getInstitution() == null || edu.getInstitution().isBlank()) 
        {
            throw new IllegalArgumentException("Field institution cannot be empty");
        }

        return educationRepository.save(edu);
    }

    @Override
    public Optional<Education> findById(Long id) {

        if (id <= 0) {
            throw new IllegalArgumentException("ID cannot be negative number");
        }

        return educationRepository.findById(id);
    }

    @Override
    public List<Education> findAll() {
        return educationRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        educationRepository.deleteById(id);
    }

    @Override
    public List<Education> findByPersonalInfoId(Long personalInfoId) {
        if (personalInfoId <= 0) {
            throw new IllegalArgumentException("ID cannot be negative number");
        }

        return educationRepository.findByPersonalInfoId(personalInfoId);
    }

}
