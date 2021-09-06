package com.takeon.burette.article.ui;

import com.takeon.burette.article.dto.*;
import com.takeon.burette.article.service.ArticleService;
import com.takeon.burette.supports.api.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 맵핑은 컨트롤러 단위로 컨트롤러는 no logic, 일종의 뷰
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    private UserClient userClient = new UserClient();

    @GetMapping("/test")
    public ResponseEntity Test () {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/create")
    public ResponseEntity<ArticleResponse> createArticle(@RequestBody ArticleRequest articleRequest, @RequestHeader (name="Authorization") String token) {
        if(!userClient.isWritable(token)) {
            return ResponseEntity.status(401).build();
        }

        ArticleResponse articleResponse = articleService.saveArticle(articleRequest);
        return ResponseEntity.ok().body(articleResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteArticle(@PathVariable Long id, @RequestHeader (name="Authorization") String token) {
        if(!userClient.isWritable(token)) {
            return ResponseEntity.status(401).build();
        }

        boolean isDeleted = articleService.deleteById(id);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ArticleResponse> getArticle(@PathVariable Long id) {
        ArticleResponse articleResponse = articleService.getArticleById(id);

        return ResponseEntity.ok().body(articleResponse);
    }

    @GetMapping("/latest_category")
    public ResponseEntity<List<ArticleResponse>> getLatestCategory() {
        List<ArticleResponse> articleResponses = articleService.getLatestArticlesByCategory();

        return ResponseEntity.ok().body(articleResponses);
    }

}
