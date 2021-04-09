package com.takeon.burette.article.dto;

// DTO
public class ArticleDeleteResponse {
    private boolean isDeleted;

    public ArticleDeleteResponse(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public boolean isDeleted() {
        return isDeleted;
    }
}
