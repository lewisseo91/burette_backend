package com.takeon.burette.user.ui;

import com.takeon.burette.user.domain.User;
import com.takeon.burette.user.dto.*;
import com.takeon.burette.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 맵핑은 컨트롤러 단위로
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public ResponseEntity Test() {
        String body = "Hello, world!";
        return ResponseEntity.ok().body(body);
    }

    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody UserRequest userRequest) {
        // 등록
        User user = userService.save(userRequest);

        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody LoginRequest loginRequest) {
        String token = userService.loginUser(loginRequest);
        if (token == null) {
            return ResponseEntity.badRequest().build();
        }
        LoginResponse loginResponse = new LoginResponse(token);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/writable")
    public ResponseEntity isWritable(@RequestBody TokenRequest tokenRequest) {
        boolean isWritable = userService.isWritable(tokenRequest);

        return isWritable ? ResponseEntity.ok().build() : ResponseEntity.status(401).build();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable String userId) {
        UserResponse response = userService.getUserByUserId(userId);
        if (response == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getUsers() {
        List<UserResponse> response = userService.getUsers();
        if (response == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().body(response);
    }

}
