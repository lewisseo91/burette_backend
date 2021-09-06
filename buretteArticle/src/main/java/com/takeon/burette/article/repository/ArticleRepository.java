package com.takeon.burette.article.repository;

import com.takeon.burette.article.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("SELECT a FROM Article a WHERE a.id IN (SELECT MAX(a2.id) FROM Article a2 GROUP BY a2.categoryId)")
    List<Article> getLatestArticlesByCategory();
}
