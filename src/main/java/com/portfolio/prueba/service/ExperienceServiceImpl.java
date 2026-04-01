package com.portfolio.prueba.service;

import org.springframework.stereotype.Service;

import com.portfolio.prueba.model.Experience;
import com.portfolio.prueba.repository.IExperienceRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements IExperienceService {
    private final IExperienceRepository experienceRepository;


    @Override
    public List<Experience> findAll() {
        return experienceRepository.findAll();
    }

    @Override
    public Optional<Experience> findById(Long id) {
        return experienceRepository.findById(id);
    }

    @Override
    public Experience save(Experience experience) {
        if (experience.getStartDate() == null) {
            throw new IllegalArgumentException("Start date of experience cannot be empty");
        }

        if(experience.getEndDate()!=null
                && experience.getStartDate().isAfter(experience.getEndDate())
        ) {
            throw new IllegalArgumentException("Start date of experience cannot be after of end date");
        }

        if (experience.getJobTitle() == null || experience.getJobTitle().isBlank()) {
            throw new IllegalArgumentException("Job title cannot be empty");
        }
        
        if (experience.getCompanyName() == null || experience.getCompanyName().isBlank()) {
            throw new IllegalArgumentException("Name of the company cannot be empty");
        }
        
        return experienceRepository.save(experience);
    }

    @Override
    public void deleteById(Long id) {
        experienceRepository.deleteById(id);
    }

    @Override
    public List<Experience> findExperienceByPersonalInfoId(Long personalInfoId) {
        return experienceRepository.findByPersonalInfoId(personalInfoId);
    }
}
