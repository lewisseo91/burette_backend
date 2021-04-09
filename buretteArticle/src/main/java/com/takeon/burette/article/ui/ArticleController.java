package com.takeon.burette.article.ui;

import com.takeon.burette.article.application.ArticleService;
import com.takeon.burette.article.dto.ArticleCreateRequest;
import com.takeon.burette.article.dto.ArticleCreateResponse;
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
    public ResponseEntity createArticle(@RequestBody ArticleCreateRequest articleCreateRequest) {
        // 등록 동작
        // db 등록
        ArticleCreateResponse articleCreateResponse = articleService.saveArticle(articleCreateRequest);
        System.out.println(articleCreateResponse.getId());
        return ResponseEntity.ok().build();
        //return ResponseEntity.created(URI.create("/" + articleResponse.getId())).body(articleResponse);
    }

    @PostMapping("/delete")
    public ResponseEntity deleteArticle(@RequestBody int articleId) {
        // 등록 동작
        // db 등록
        ArticleCreateResponse articleCreateResponse = articleService.deleteById(articleId);
        System.out.println(articleCreateResponse.getId());
        return ResponseEntity.ok().build();
        //return ResponseEntity.created(URI.create("/" + articleResponse.getId())).body(articleResponse);
    }


    @PostMapping("/search")
    public ResponseEntity searchArticle(@RequestBody ArticleCreateRequest articleCreateRequest) {
        // 등록 동작
        // db 등록
        ArticleCreateResponse articleCreateResponse = articleService.saveArticle(articleCreateRequest);
        System.out.println(articleCreateResponse.getId());
        return ResponseEntity.ok().build();
        //return ResponseEntity.created(URI.create("/" + articleResponse.getId())).body(articleResponse);
    }


    @PostMapping("/update")
    public ResponseEntity updateArticle(@RequestBody ArticleCreateRequest articleCreateRequest) {
        // 등록 동작
        // db 등록
        ArticleCreateResponse articleCreateResponse = articleService.saveArticle(articleCreateRequest);
        System.out.println(articleCreateResponse.getId());
        return ResponseEntity.ok().build();
        //return ResponseEntity.created(URI.create("/" + articleResponse.getId())).body(articleResponse);
    }



}
