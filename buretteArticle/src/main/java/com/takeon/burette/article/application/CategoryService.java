package com.takeon.burette.article.application;

import com.takeon.burette.article.dao.CategoryDao;
import com.takeon.burette.article.domain.Article;
import com.takeon.burette.article.dto.ArticleCreateRequest;
import com.takeon.burette.article.dto.ArticleCreateResponse;
import com.takeon.burette.article.dto.CategoryRequest;
import com.takeon.burette.article.dto.CategoryResponse;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private CategoryDao categoryDao;

    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public CategoryResponse saveCategory(CategoryRequest categoryRequest) {
        int categoryId = categoryDao.save(categoryRequest); // article
        return new CategoryResponse(categoryId);
    }
}
