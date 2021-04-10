package com.takeon.burette.supports.api;

import com.takeon.burette.article.dto.TokenRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class UserClient {

    private static final String LOCAL_HOST = "http://localhost";
    private static final String PORT = ":8091";
    private static final String POST_WRITABLE_MAPPING = "/writable";

    private RestTemplate restTemplate;

    public UserClient() {
        this.restTemplate = new RestTemplate();
    }

    public String test() {
        String baseURL = "http://localhost:8091/user/test";
        String response = restTemplate.getForObject(baseURL, String.class);

        return response;

    }

    public boolean isWritable(String token) {
        TokenRequest tokenRequest = new TokenRequest(token);
        ResponseEntity<String> response = restTemplate.postForEntity(LOCAL_HOST + PORT + POST_WRITABLE_MAPPING, tokenRequest, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return true;
        }
        return false;
    }

}
