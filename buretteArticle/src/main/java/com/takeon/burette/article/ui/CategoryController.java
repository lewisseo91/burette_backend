package com.takeon.burette.article.ui;

import com.takeon.burette.article.application.CategoryService;
import com.takeon.burette.article.dto.ArticleCreateRequest;
import com.takeon.burette.article.dto.ArticleCreateResponse;
import com.takeon.burette.article.dto.CategoryRequest;
import com.takeon.burette.article.dto.CategoryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public ResponseEntity createCategory(@RequestBody CategoryRequest categoryRequest) {
        CategoryResponse categoryResponse = categoryService.saveCategory(categoryRequest);
        return ResponseEntity.ok().body(categoryResponse.getId());
    }
}
