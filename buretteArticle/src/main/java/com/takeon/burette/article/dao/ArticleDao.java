package com.takeon.burette.article.dao;

import com.takeon.burette.article.domain.Article;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

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
            preparedStatement.setInt(7, article.getCategoryId());
            return preparedStatement;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public boolean deleteById(int id) {
        String sql = "DELETE FROM ARTICLE WHERE id = ?";
        return jdbcTemplate.update(sql, id) == 1;
    }

    public Article getById(int id) {
        String sql = "SELECT * FROM ARTICLE WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, selectArticles, id);
    }

    public List<Article> getLatestArticlesByCategory() {
        String sql = "SELECT * FROM ARTICLE WHERE id IN ( SELECT MAX(id) FROM ARTICLE GROUP BY categoryId )";
        return jdbcTemplate.query(
                sql,
                selectArticles
        );
    }

    private final static RowMapper<Article> selectArticles = ( rs, rowNum) -> new Article(
            rs.getInt("type"),
            rs.getString("title"),
            rs.getString("subTitle"),
            rs.getString("thumbnail"),
            rs.getString("contents"),
            rs.getString("tags"),
            rs.getInt("categoryId")
    );
}
