package com.takeon.burette.article.dto;

import com.takeon.burette.article.domain.Article;

import java.util.List;

public class ArticleResponse {
    private int id;
    private Article article;
    private List<Article> articleList;

    public ArticleResponse() {}

    public ArticleResponse(int id) {
        this.id = id;
    }

    public ArticleResponse(Article article) {
        this.article = article;
    }

    public ArticleResponse(List<Article> articleList) {
        this.articleList = articleList;
    }

    public int getId() {
        return id;
    }

    public Article getArticle() {
        return article;
    }

    public List<Article> getArticleList() {
        return articleList;
    }
}
