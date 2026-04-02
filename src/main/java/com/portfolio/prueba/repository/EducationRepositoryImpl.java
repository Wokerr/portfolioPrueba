package com.portfolio.prueba.repository;

import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.portfolio.prueba.model.Education;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class EducationRepositoryImpl implements IEducationRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Education> educationRowMapper = (rs, numRow) ->{
        Education education = new Education();
        education.setId(rs.getLong("id"));
        education.setDegree(rs.getString("degree"));
        education.setInstitution(rs.getString("institution"));
        education.setStartDate(rs.getObject("start_date", LocalDate.class));
        education.setEndDate(rs.getObject("end_date", LocalDate.class));
        education.setDescription(rs.getString("description"));
        education.setPersonalInfoId(rs.getLong("personal_info_id"));
        return education;
    };

    @Override
    public Education save(Education edu) {
        if (edu.getId() == null) {
            String sql = "INSERT INTO educations (degree, institution, start_date, end_date, description, personal_info_id) VALUES (?, ?, ?, ?, ?, ?)";

            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(conn -> {
                PreparedStatement ps = conn.prepareStatement(sql, new String[] { "id" });
                ps.setString(1, edu.getDegree());
                ps.setString(2, edu.getInstitution());
                ps.setObject(3, edu.getStartDate());
                ps.setObject(4, edu.getEndDate());
                ps.setString(5, edu.getDescription());
                ps.setLong(6, edu.getPersonalInfoId());
                return ps;
            }, keyHolder);

            edu.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        } else {
            String sql = "UPDATE educations SET degree = ?, institution = ?, start_date = ?, end_date = ?, description = ?, personal_info_id = ? WHERE id = ?";
            jdbcTemplate.update(sql,
                    edu.getDegree(),
                    edu.getInstitution(),
                    edu.getStartDate(),
                    edu.getEndDate(),
                    edu.getDescription(),
                    edu.getPersonalInfoId(),
                    edu.getId());
        }
        return edu;
        
    }

    @Override
    public Optional<Education> findById(Long id) {
        String sql = "SELECT * FROM educations WHERE id = ?";

        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, educationRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Education> findAll() {
        String sql = "SELECT * FROM educations";
        return jdbcTemplate.query(sql, educationRowMapper);
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM educations WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Education> findByPersonalInfoId(Long personalInfoId) {
        String sql = "SELECT * FROM educations WHERE personal_info_id = ?";
        return jdbcTemplate.query(sql, educationRowMapper, personalInfoId);
    }

}
