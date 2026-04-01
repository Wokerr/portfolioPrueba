package com.portfolio.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.portfolio.prueba.model.Skill;
import com.portfolio.prueba.repository.ISkillRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements ISkillService {

    private final ISkillRepository skillRepository;

    @Override
    public Skill save(Skill skill) {
        if (skill.getLevelPercentage() < 0 && skill.getLevelPercentage() > 100)
        {
            throw new IllegalArgumentException("Incorrect percentage, this value must be between 0 and 100%");
        }

        return skillRepository.save(skill);
    }

    @Override
    public Optional<Skill> findById(Long id) {
        return skillRepository.findById(id);
    }

    @Override
    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        skillRepository.deleteById(id);
    }

    @Override
    public List<Skill> findByPersonalInfoId(Long personalInfoId) {
        return skillRepository.findByPersonalInfoId(personalInfoId);
    }

}
