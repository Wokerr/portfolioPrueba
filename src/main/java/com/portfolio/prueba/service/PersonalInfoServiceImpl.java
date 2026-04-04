package com.portfolio.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.portfolio.prueba.exception.ValidationException;
import com.portfolio.prueba.model.PersonalInfo;
import com.portfolio.prueba.repository.IPersonalInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonalInfoServiceImpl implements IPersonalInfoService {

    private final IPersonalInfoRepository personalInfoRepository;
    private final Validator validator;

    @Override
    public PersonalInfo save(PersonalInfo personalInfo) {
        BindingResult result = new BeanPropertyBindingResult(personalInfo, "personalInfo");
        validator.validate(personalInfo, result);

        if (result.hasErrors()) {
            throw new ValidationException(result);
        }

        return personalInfoRepository.save(personalInfo);
    }

    @Override
    public Optional<PersonalInfo> findById(Long id) {
        return personalInfoRepository.findById(id);
    }

    @Override
    public List<PersonalInfo> findAll() {
        return personalInfoRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        personalInfoRepository.deleteById(id);
    }

}
