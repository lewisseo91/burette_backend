package com.takeon.burette.user.ui;

import com.takeon.burette.user.domain.User;
import com.takeon.burette.user.dto.*;
import com.takeon.burette.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// 맵핑은 컨트롤러 단위로
@RestController
@RequestMapping("/user")
public class UserController {

//    private UserServiceOld userServiceOld;

    @Autowired
    private UserService userService;

//    public UserController(UserServiceOld userServiceOld) {
//        this.userServiceOld = userServiceOld;
//    }

    @GetMapping("/test")
    public ResponseEntity Test() {
        String body = "Hello, world!";
        return ResponseEntity.ok().body(body);
    }

    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody UserRequest userRequest) {
        // 등록
        System.out.println("ldkfsajfdlksajdf");
        System.out.println(userRequest.toString());
//        int id = userServiceOld.registerUser(userRequest);
//        System.out.println(id);
        User user = userService.save(userRequest);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody LoginRequest loginRequest) {
//        String token = userServiceOld.loginUser(loginRequest);
        String token = userService.loginUser(loginRequest);
        if (token == null) {
            return ResponseEntity.badRequest().build();
        }
        LoginResponse loginResponse = new LoginResponse(token);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/writable")
    public ResponseEntity isWritable(@RequestBody TokenRequest tokenRequest) {
//        boolean isWritable = userServiceOld.isWritable(tokenRequest);
        boolean isWritable = userService.isWritable(tokenRequest);
        System.out.println("isWritable : " + isWritable);
        return isWritable ? ResponseEntity.ok().build() : ResponseEntity.status(401).build();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable String userId) {
//        UserResponse response = userServiceOld.getUserById(userId);
        UserResponse response = userService.getUserByUserId(userId);
        if (response == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(response);
    }

}
