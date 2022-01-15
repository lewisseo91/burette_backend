package com.takeon.burette.ui;

import com.takeon.burette.application.AuthService;
import com.takeon.burette.dto.TokenRequest;
import com.takeon.burette.infrastructure.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/_hcheck.hdn")
    public ResponseEntity healthCheck() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/create/{id}")
    public ResponseEntity generateToken(@PathVariable String id) {
        String token = authService.createToken(id);
        System.out.println("token : " + token);
        return ResponseEntity.status(201).body(token);
    }

    @GetMapping("/valid/{token}")
    public ResponseEntity getIdFromToken(@PathVariable String token) {
        boolean isValid = authService.validToken(token);
        System.out.println(isValid);
        if (isValid) {
            return ResponseEntity.ok().body(authService.getPayload(token));
        }
        System.out.println("확인");
        return ResponseEntity.status(401).build();
    }


}
