package com.takeon.burette.article.ui;

import com.takeon.burette.article.application.ArticleService;
import com.takeon.burette.article.dto.*;
import com.takeon.burette.supports.api.UserClient;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// 맵핑은 컨트롤러 단위로 컨트롤러는 no logic, 일종의 뷰
@RestController
@RequestMapping("/article")
public class ArticleController {

    private ArticleService articleService;
    private UserClient userClient;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
        this.userClient = new UserClient();
    }

    @GetMapping("/test")
    public ResponseEntity Test () {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/create")
    public ResponseEntity createArticle(@RequestBody ArticleCreateRequest articleCreateRequest, @RequestHeader (name="Authorization") String token) {
        boolean isWritable = userClient.isWritable(token);
        if(!isWritable) {
            return ResponseEntity.status(401).build();
        }
        ArticleCreateResponse articleCreateResponse = articleService.saveArticle(articleCreateRequest);
        return ResponseEntity.ok().body(articleCreateResponse.getId());
    }

    @PostMapping("/delete")
    public ResponseEntity deleteArticle(@RequestBody ArticleDeleteRequest articleDeleteRequest, @RequestHeader (name="Authorization") String token) {
        boolean isWritable = userClient.isWritable(token);
        if(!isWritable) {
            return ResponseEntity.status(401).build();
        }
        ArticleDeleteResponse articleDeleteResponse = articleService.deleteById(articleDeleteRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/get")
    public ResponseEntity getArticle(@RequestBody ArticleReadRequest articleReadRequest) {
        ArticleReadResponse articleReadResponse = articleService.getById(articleReadRequest);
        return ResponseEntity.ok().body(articleReadResponse.getArticle());
    }

    @PostMapping("/latest_category")
    public ResponseEntity getLatestCategory() {
        ArticleListResponse articleReadResponse = articleService.getLatestArticlesByCategory();
        return ResponseEntity.ok().body(articleReadResponse.getArticleList());
    }


//    @PostMapping("/search")
//    public ResponseEntity searchArticle(@RequestBody ArticleCreateRequest articleCreateRequest) {
//        // 등록 동작
//        // db 등록
//        ArticleCreateResponse articleCreateResponse = articleService.saveArticle(articleCreateRequest);
//        System.out.println(articleCreateResponse.getId());
//        return ResponseEntity.ok().build();
//        //return ResponseEntity.created(URI.create("/" + articleResponse.getId())).body(articleResponse);
//    }
//
//
//    @PostMapping("/update")
//    public ResponseEntity updateArticle(@RequestBody ArticleCreateRequest articleCreateRequest) {
//        // 등록 동작
//        // db 등록
//        ArticleCreateResponse articleCreateResponse = articleService.saveArticle(articleCreateRequest);
//        System.out.println(articleCreateResponse.getId());
//        return ResponseEntity.ok().build();
//        //return ResponseEntity.created(URI.create("/" + articleResponse.getId())).body(articleResponse);
//    }



}
