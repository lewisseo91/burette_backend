package com.takeon.burette.article.dto;

import java.util.List;

// DTO
public class ArticleCreateResponse {
    private int id;

    public ArticleCreateResponse(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
