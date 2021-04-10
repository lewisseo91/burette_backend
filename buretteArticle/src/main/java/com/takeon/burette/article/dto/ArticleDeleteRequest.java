package com.takeon.burette.article.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArticleDeleteRequest {

    int id;

    public ArticleDeleteRequest() { }

    public ArticleDeleteRequest(int id) {
        this.id = id;
    }

    public int getId() { return id; }

}
