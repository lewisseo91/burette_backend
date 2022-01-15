package com.takeon.burette.supports.api;

import com.takeon.burette.article.dto.TokenRequest;
import com.takeon.burette.article.dto.UserRequest;
import com.takeon.burette.article.dto.UserResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class UserClient {

    private static final String LOCAL_HOST = "http://localhost";
    private static final String PORT = ":8091";
    private static final String POST_CREATE_USER = "/user/create";
    private static final String POST_WRITABLE_MAPPING = "/user/writable";
    private static final String PORT_AUTH = ":8092";
    private static final String GET_TOKEN_MAPPING = "/auth/create/";

    private final RestTemplate restTemplate;

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
        ResponseEntity<TokenRequest> response = restTemplate.postForEntity(LOCAL_HOST + PORT + POST_WRITABLE_MAPPING, tokenRequest, TokenRequest.class);
        return response.getStatusCode() == HttpStatus.OK;
    }

    public UserResponse createUser(UserRequest userRequest) {
        ResponseEntity<UserResponse> response = restTemplate.postForEntity(LOCAL_HOST + PORT + POST_CREATE_USER, userRequest, UserResponse.class);
//        System.out.println(response);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        }
        return null;
    }

    public String getTokenByUserId(String id) {
        ResponseEntity<String> response = restTemplate.getForEntity(LOCAL_HOST + PORT_AUTH + GET_TOKEN_MAPPING + id, String.class);
        if (response.getStatusCode() == HttpStatus.CREATED) {
            return response.getBody();
        }
        return null;
    }

}
