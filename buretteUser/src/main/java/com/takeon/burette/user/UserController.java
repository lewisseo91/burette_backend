package com.takeon.burette.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// 맵핑은 컨트롤러 단위로
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/test")
    public ResponseEntity Test () {
     return ResponseEntity.ok().build();
    }

    @PostMapping("/create")
    public ResponseEntity createArticle(@RequestBody UserRequest userRequest) {
        // 등록
        return ResponseEntity.ok().build();
    }


}
