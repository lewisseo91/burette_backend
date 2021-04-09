package com.takeon.burette.article.dao;

import com.takeon.burette.article.domain.Article;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class ArticleDao {
    private final JdbcTemplate jdbcTemplate;

    public ArticleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(Article article) {
        String sql = "INSERT INTO ARTICLE(type, title, subTitle, thumbnail, contents, tags, categoryId) VALUES(?, ?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, new String[]{"id"});
            preparedStatement.setInt(1, article.getType());
            preparedStatement.setString(2, article.getTitle());
            preparedStatement.setString(3, article.getSubTitle());
            preparedStatement.setString(4, article.getThumbnail());
            preparedStatement.setString(5, article.getContents());
            preparedStatement.setString(6, article.getTags());
            preparedStatement.setInt(7, article.getCategory());
            return preparedStatement;
        }, keyHolder); // INSERT, UPDATE
        // STRING 구분자 , 같은거 넣을까 생각 중 좋진 않아
        return keyHolder.getKey().intValue();
    }

    public int deleteById(Article article) {
        String sql = "DELETE FROM ARTICLE WHERE id = ?";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, new String[]{"id"});
            preparedStatement.setLong(1, article.getId());
            return preparedStatement;
        }, keyHolder); // INSERT, UPDATE
        // STRING 구분자 , 같은거 넣을까 생각 중 좋진 않아
        return keyHolder.getKey().intValue();
    }

}
