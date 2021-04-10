package com.takeon.burette.article.dto;

import java.util.List;

// DTO
public class ArticleReadResponse {
    private int article;

    public ArticleReadResponse(int article) {
        this.article = article;
    }

    public int getArticle() {
        return article;
    }
}
