package com.takeon.burette.user.ui;

import com.takeon.burette.user.dto.LoginRequest;
import com.takeon.burette.user.dto.LoginResponse;
import com.takeon.burette.user.dto.UserRequest;
import com.takeon.burette.user.application.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// 맵핑은 컨트롤러 단위로
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public ResponseEntity Test () {
        String body = "Hello, world!";
        return ResponseEntity.ok().body(body);
    }

    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody UserRequest userRequest) {
        // 등록
        int id = userService.registerUser(userRequest);
        System.out.println(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody LoginRequest loginRequest) {
        String token = userService.loginUser(loginRequest);
        if( token == null ) {
            return ResponseEntity.badRequest().build();
        }
        LoginResponse loginResponse = new LoginResponse(token);
        return ResponseEntity.ok().body(loginResponse);
    }

}
