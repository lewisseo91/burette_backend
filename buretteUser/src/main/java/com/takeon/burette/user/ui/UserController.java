package com.takeon.burette.user.ui;

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
     return ResponseEntity.ok().build();
    }

    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody UserRequest userRequest) {
        // 등록
        int id = userService.registerUser(userRequest);
        System.out.println(id);
        return ResponseEntity.ok().build();
    }




}
