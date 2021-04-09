package com.takeon.burette.supports.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


public class AuthClient {

    private static final String BASE_URL = "http://localhost";
    private static final String PORT = ":8092";
    private static final String GET_TOKEN_MAPPING = "/auth/create/";

    private RestTemplate restTemplate;

    public AuthClient() {
        this.restTemplate = new RestTemplate();
    }

    public String test() {
        String baseURL = "http://localhost:8091/user/test";
        String response = restTemplate.getForObject(baseURL, String.class);

        return response;
    }

    public String getToken(String id) {
        ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL + PORT + GET_TOKEN_MAPPING + id , String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        }
        return null;
    }

}
