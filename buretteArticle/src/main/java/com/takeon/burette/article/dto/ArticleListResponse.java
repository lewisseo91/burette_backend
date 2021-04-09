package com.takeon.burette.article.dto;

import com.takeon.burette.article.domain.Article;

import java.util.List;

public class ArticleListResponse {
    private List<Article> articleList;

    public ArticleListResponse(List<Article> articleList) {
        this.articleList = articleList;
    }

    public List<Article> getArticleList() {
        return articleList;
    }
}
