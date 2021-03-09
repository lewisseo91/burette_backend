package com.takeon.burette.article;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// 맵핑은 컨트롤러 단위로
@RestController
@RequestMapping("/article")
public class ArticleController {

    @GetMapping("/test")
    public ResponseEntity Test () {
     return ResponseEntity.ok().build();
    }

    @PostMapping("/create")
    public ResponseEntity createArticle(@RequestBody ArticleRequest articleRequest) {
        // 등록
        return ResponseEntity.ok().build();
    }


}
