package com.takeon.burette.article.ui;

import com.takeon.burette.article.application.MainPageService;
import com.takeon.burette.article.dto.ArticleCreateRequest;
import com.takeon.burette.article.dto.ArticleCreateResponse;
import com.takeon.burette.article.dto.MainPageRequest;
import com.takeon.burette.article.dto.MainPageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/main")
public class MainPageController {
    private MainPageService mainPageService;

    public MainPageController(MainPageService mainPageService) {
        this.mainPageService = mainPageService;
    }

    @GetMapping("/test")
    public ResponseEntity Test () {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/create")
    public ResponseEntity createMainPage(@RequestBody MainPageRequest mainPageRequest) {
        System.out.println("12312321321ldksjalgkjdsalkgdjsalkgjdsalkgjalsdjas");
        MainPageResponse mainPageResponse = mainPageService.saveMainPage(mainPageRequest);
        return ResponseEntity.ok().body(mainPageResponse.getId());
    }
}
