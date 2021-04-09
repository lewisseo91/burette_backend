package com.takeon.burette.article.ui;

import com.takeon.burette.article.application.ArticleService;
import com.takeon.burette.article.dto.ArticleRequest;
import com.takeon.burette.article.dto.ArticleResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// 맵핑은 컨트롤러 단위로 컨트롤러는 no logic, 일종의 뷰
@RestController
@RequestMapping("/article")
public class ArticleController {

    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/test")
    public ResponseEntity Test () {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/create")
    public ResponseEntity createArticle(@RequestBody ArticleRequest articleRequest) {
        // 등록 동작
        // db 등록
        ArticleResponse articleResponse = articleService.saveArticle(articleRequest);
        System.out.println(articleResponse.getId());
        return ResponseEntity.ok().build();
        //return ResponseEntity.created(URI.create("/" + articleResponse.getId())).body(articleResponse);
    }

    @PostMapping("/delete")
    public ResponseEntity deleteArticle(@RequestBody ArticleRequest articleRequest) {
        // 등록 동작
        // db 등록
        ArticleResponse articleResponse = articleService.saveArticle(articleRequest);
        System.out.println(articleResponse.getId());
        return ResponseEntity.ok().build();
        //return ResponseEntity.created(URI.create("/" + articleResponse.getId())).body(articleResponse);
    }


    @PostMapping("/search")
    public ResponseEntity searchArticle(@RequestBody ArticleRequest articleRequest) {
        // 등록 동작
        // db 등록
        ArticleResponse articleResponse = articleService.saveArticle(articleRequest);
        System.out.println(articleResponse.getId());
        return ResponseEntity.ok().build();
        //return ResponseEntity.created(URI.create("/" + articleResponse.getId())).body(articleResponse);
    }


    @PostMapping("/update")
    public ResponseEntity updateArticle(@RequestBody ArticleRequest articleRequest) {
        // 등록 동작
        // db 등록
        ArticleResponse articleResponse = articleService.saveArticle(articleRequest);
        System.out.println(articleResponse.getId());
        return ResponseEntity.ok().build();
        //return ResponseEntity.created(URI.create("/" + articleResponse.getId())).body(articleResponse);
    }



}
