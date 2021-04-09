package com.takeon.burette.article.dao;

import com.takeon.burette.article.dto.CategoryRequest;
import com.takeon.burette.article.dto.MainPageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class CategoryDao {
    private JdbcTemplate jdbcTemplate;

    public CategoryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(CategoryRequest categoryRequest) {
        String sql = "INSERT INTO CATEGORY(name) VALUES(?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, new String[]{"id"});
            preparedStatement.setString(1, categoryRequest.getName());
            return preparedStatement;
        }, keyHolder); // INSERT, UPDATE
        // STRING 구분자 , 같은거 넣을까 생각 중 좋진 않아
        return keyHolder.getKey().intValue();
    }
}
