package com.takeon.burette.article.dto;

public class CategoryRequest {
    private String name;

    public CategoryRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
