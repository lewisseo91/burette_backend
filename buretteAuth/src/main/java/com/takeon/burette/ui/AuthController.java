package com.takeon.burette.ui;

import com.takeon.burette.dto.TokenRequest;
import com.takeon.burette.infrastructure.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();


    @GetMapping("/create")
    public ResponseEntity generateToken(@RequestBody TokenRequest tokenRequest) {
        String id = tokenRequest.getId();
        String token = jwtTokenProvider.createToken(id);
        return ResponseEntity.ok().body(token);
    }
}
