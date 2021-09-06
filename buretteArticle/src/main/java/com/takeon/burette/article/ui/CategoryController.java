package com.takeon.burette.article.ui;

import com.takeon.burette.article.dto.CategoryRequest;
import com.takeon.burette.article.dto.CategoryResponse;
import com.takeon.burette.article.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest) {
        CategoryResponse categoryResponse = categoryService.saveCategory(categoryRequest);
        return ResponseEntity.ok().body(categoryResponse);
    }
}
