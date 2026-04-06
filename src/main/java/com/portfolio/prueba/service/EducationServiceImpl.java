package com.portfolio.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.portfolio.prueba.exception.ValidationException;
import com.portfolio.prueba.model.Education;
import com.portfolio.prueba.repository.IEducationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements IEducationService {
    
    private final IEducationRepository educationRepository;
    private final Validator validator;

    @Override
    @Transactional
    public Education save(Education education) {
        BindingResult result = new BeanPropertyBindingResult(education, "education");
        validator.validate(education, result);

        if(result.hasErrors()){
            throw new ValidationException(result);
        }

        return educationRepository.save(education);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Education> findById(Long id) {

        if (id <= 0) {
            throw new IllegalArgumentException("ID cannot be negative number");
        }

        return educationRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Education> findAll() {
        return educationRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        educationRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Education> findByPersonalInfoId(Long personalInfoId) {
        if (personalInfoId <= 0) {
            throw new IllegalArgumentException("ID cannot be negative number");
        }

        return educationRepository.findByPersonalInfoId(personalInfoId);
    }

}
