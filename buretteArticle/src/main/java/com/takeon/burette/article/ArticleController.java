package com.takeon.burette.article;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 맵핑은 컨트롤러 단위로
@RestController
@RequestMapping("/article")
public class ArticleController {

    @GetMapping("/test")
    public ResponseEntity Test () {
     return ResponseEntity.ok().build();
    }


}
