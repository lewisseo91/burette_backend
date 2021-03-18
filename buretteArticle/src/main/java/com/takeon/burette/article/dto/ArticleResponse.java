package com.takeon.burette.article.dto;

import java.util.List;

// DTO
public class ArticleResponse {
    private int id;

    public ArticleResponse(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
