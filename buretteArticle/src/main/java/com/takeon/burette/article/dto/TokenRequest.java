package com.takeon.burette.article.dto;

public class TokenRequest {

    private String token;

    public TokenRequest(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
