package com.portfolio.prueba.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.portfolio.prueba.model.PersonalInfo;

import lombok.RequiredArgsConstructor;


@Repository
@RequiredArgsConstructor
public class PersonalInfoRepositoryImpl implements IPersonalInfoRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<PersonalInfo> personalInfoRowMapper = (rs, numRow) -> {
        PersonalInfo info = new PersonalInfo();
        info.setId(rs.getLong("id"));
        info.setFirstName(rs.getString("first_name"));
        info.setLastName(rs.getString("last_name"));
        info.setTitle(rs.getString("title"));
        info.setProfileDescription(rs.getString("profile_description"));
        info.setProfileImageUrl(rs.getString("profile_image_url"));
        info.setYearsOfExperience(rs.getObject("first_name", Integer.class));
        info.setEmail(rs.getString("email"));
        info.setPhone(rs.getString("phone"));
        info.setLinkedinUrl(rs.getString("linkedinUrl"));
        info.setGithubUrl(rs.getString("githubUrl"));
        
        return info;
    };

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
        String sql = "SELECT * FROM personal_info";
        return jdbcTemplate.query(sql, personalInfoRowMapper);
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

}
