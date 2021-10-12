package com.takeon.burette.article.service;

import com.takeon.burette.article.domain.Category;
import com.takeon.burette.article.dto.CategoryRequest;
import com.takeon.burette.article.dto.CategoryResponse;
import com.takeon.burette.article.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryResponse saveCategory(CategoryRequest categoryRequest) {
        Category category = new Category(categoryRequest);
        categoryRepository.save(category);

        return new CategoryResponse(category);
    }

    public List<CategoryResponse> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(CategoryResponse::new)
                .collect(Collectors.toList());
    }
}
