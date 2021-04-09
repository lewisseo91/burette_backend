package com.takeon.burette.article.dto;

import com.takeon.burette.article.domain.Article;

import java.util.List;

// DTO
public class ArticleReadResponse {
    private Article article;

    public ArticleReadResponse(Article article) {
        this.article = article;
    }

    public Article getArticle() {
        return article;
    }
}
