package com.takeon.burette.article.dto;

public class ArticleDeleteRequest {
    private int id;

    public ArticleDeleteRequest(int id) {
        this.id = id;
    }

    public int getId() { return id; }

}
