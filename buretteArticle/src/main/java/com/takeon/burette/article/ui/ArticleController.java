package com.takeon.burette.article.ui;

import com.takeon.burette.article.application.ArticleService;
import com.takeon.burette.article.domain.Article;
import com.takeon.burette.article.dto.*;
import com.takeon.burette.supports.api.UserClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Integer> createArticle(@RequestBody ArticleRequest articleRequest, @RequestHeader (name="Authorization") String token) {
        if(!userClient.isWritable(token)) {
            return ResponseEntity.status(401).build();
        }
        ArticleResponse articleResponse = articleService.saveArticle(articleRequest);
        return ResponseEntity.ok().body(articleResponse.getId());
    }

    @PostMapping("/delete")
    public ResponseEntity deleteArticle(@RequestBody ArticleRequest articleRequest, @RequestHeader (name="Authorization") String token) {
        if(!userClient.isWritable(token)) {
            return ResponseEntity.status(401).build();
        }
        boolean isDeleted = articleService.deleteById(articleRequest);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    @PostMapping("/get")
    public ResponseEntity<ArticleResponse> getArticle(@RequestBody ArticleRequest articleRequest) {
        ArticleResponse articleResponse = articleService.getById(articleRequest);
        return ResponseEntity.ok().body(articleResponse);
    }

    @PostMapping("/latest_category")
    public ResponseEntity<List<ArticleResponse>> getLatestCategory() {
        List<ArticleResponse> articleResponses = articleService.getLatestArticlesByCategory();
        return ResponseEntity.ok().body(articleResponses);
    }

}
