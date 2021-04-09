package com.takeon.burette.article.dto;

public class MainPageRequest {
    private int articleId;

    public MainPageRequest(int articleId) {
        this.articleId = articleId;
    }

    public int getArticleId() {
        return articleId;
    }

}
