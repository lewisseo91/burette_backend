package com.takeon.burette.dto;

public class TokenRequest {
    private final String id;

    public TokenRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
