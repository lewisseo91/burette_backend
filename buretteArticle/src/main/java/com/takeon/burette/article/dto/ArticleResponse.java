package com.takeon.burette.article.dto;

import com.takeon.burette.article.domain.Article;

import java.util.List;

public class ArticleResponse {
    private int id;
    private int type;
    private String title;
    private String subTitle;
    private String thumbnail;
    private String contents;
    private String tags;
    private int categoryId;

    public ArticleResponse() {}

    public ArticleResponse(int id) {
        this.id = id;
    }

    public ArticleResponse(Article article) {
        this.id = article.getId();
        this.type = article.getType();
        this.title = article.getTitle();
        this.subTitle = article.getSubTitle();
        this.thumbnail = article.getThumbnail();
        this.contents = article.getContents();
        this.tags = article.getTags();
        this.categoryId = article.getCategoryId();
    }

    public int getId() {
        return id;
    }

}
