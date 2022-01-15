package com.takeon.burette.application;

import com.takeon.burette.infrastructure.JwtTokenProvider;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final JwtTokenProvider jwtTokenProvider;

    public AuthService(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public String createToken(String id) {
        return jwtTokenProvider.createToken(id);
    }

    public String getPayload(String token) {
        return jwtTokenProvider.getPayload(token);
    }

    public boolean validToken(String token) {
        return jwtTokenProvider.validToken(token);
    }
}
