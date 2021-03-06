package com.takeon.burette.article.domain;

import com.takeon.burette.article.dto.ArticleRequest;
import com.takeon.burette.article.exception.InvalidArticleException;

import java.util.List;
import java.util.stream.Collectors;

public class Article {
    private int id;
    private int type;
    private String title;
    private String subTitle;
    private String thumbnail;
    private String contents;
    private String tags;
    private int categoryId;

    private static final int CONTENTS_LIMIT = 10000;
    private static final int TITLE_LIMIT = 250;
    private static final int SUBTITLE_LIMIT = 250;
    private static final int THUMBNAIL_LIMIT = 250;
    private static final int TAGS_LIMIT = 250;

    public Article(int id) {
        this.id = id;
    }

    public Article(ArticleRequest articleRequest) {
        this.type = articleRequest.getType();
        this.title = articleRequest.getTitle();
        this.subTitle = articleRequest.getSubTitle();
        this.thumbnail = parseString(articleRequest.getThumbnail());
        this.contents = articleRequest.getContents();
        this.tags = parseString(articleRequest.getTags());
        this.categoryId = articleRequest.getCategory();

        if( !validArticle(this) ) {
            throw new InvalidArticleException();
        }

    }

    public Article(int type, String title, String subTitle, String thumbnail, String contents, String tags, int categoryId) {
        this.type = type;
        this.title = title;
        this.subTitle = subTitle;
        this.thumbnail = thumbnail;
        this.contents = contents;
        this.tags = tags;
        this.categoryId = categoryId;
    }

    private String parseString(List<String> str ) {
        return str.stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));
    }

    private boolean validArticle(Article article) {
        // REFACTOR : 썸네일 && 콘텐츠 && 태그 객체로 만들어서 좀 더 객체 지향적으로 바꿀 수 있게 하기
        if(title.length() > TITLE_LIMIT) return false;
        if(subTitle.length() > SUBTITLE_LIMIT) return false;
        if(thumbnail.length() > THUMBNAIL_LIMIT) return false;
        if(contents.length() > CONTENTS_LIMIT) return false;
        if(tags.length() > TAGS_LIMIT) return false;
        return true;
    }

    public int getId() { return id; }

    public int getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getContents() {
        return contents;
    }

    public String getTags() {
        return tags;
    }

    public int getCategoryId() {
        return categoryId;
    }
}