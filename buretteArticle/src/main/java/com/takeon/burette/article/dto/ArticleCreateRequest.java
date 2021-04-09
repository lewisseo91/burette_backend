package com.takeon.burette.article.dto;

import java.util.List;

public class ArticleCreateRequest {
    private int type;
    private String title;
    private String subTitle;
    private List<String> thumbnail; // List<String> 가능성 있음
    private String contents;
    private List<String> tags;
    private int category;

    public ArticleCreateRequest(int type, String title, String subTitle, List<String> thumbnail, String contents, List<String> tags, int category) {
        this.type = type;
        this.title = title;
        this.subTitle = subTitle;
        this.thumbnail = thumbnail;
        this.contents = contents;
        this.tags = tags;
        this.category = category;
    }

    public int getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public List<String> getThumbnail() {
        return thumbnail;
    }

    public String getContents() {
        return contents;
    }

    public List<String> getTags() {
        return tags;
    }

    public int getCategory() {
        return category;
    }
}
