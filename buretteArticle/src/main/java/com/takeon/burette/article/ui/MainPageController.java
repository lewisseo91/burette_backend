package com.takeon.burette.article.ui;

import com.takeon.burette.article.dto.MainPageRequest;
import com.takeon.burette.article.dto.MainPageResponse;
import com.takeon.burette.article.service.MainPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/main")
public class MainPageController {

    @Autowired
    private MainPageService mainPageService;

    @GetMapping("/test")
    public ResponseEntity Test() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/create")
    public ResponseEntity createMainPage(@RequestBody MainPageRequest mainPageRequest) {
        MainPageResponse mainPageResponse = mainPageService.saveMainPage(mainPageRequest);
        return ResponseEntity.ok().body(mainPageResponse.getId());
    }
}
