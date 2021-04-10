package com.takeon.burette.article.dao;

import com.takeon.burette.article.domain.Article;
import com.takeon.burette.article.dto.MainPageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class MainPageDao {
    private final JdbcTemplate jdbcTemplate;

    public MainPageDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(MainPageRequest mainPageRequest) {
        String sql = "INSERT INTO MAINPAGE(articleId) VALUES(?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, new String[]{"id"});
            preparedStatement.setInt(1, mainPageRequest.getArticleId());
            return preparedStatement;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }
}
