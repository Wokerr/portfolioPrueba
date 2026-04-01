package com.portfolio.prueba.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.portfolio.prueba.model.PersonalInfo;


@Repository
public class PersonalInfoRepositoryImpl implements IPersonalInfoRepository {

    @Override
    public PersonalInfo save(PersonalInfo personalInfo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<PersonalInfo> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<PersonalInfo> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

}
