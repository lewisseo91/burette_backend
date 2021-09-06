package com.takeon.burette.article.dto;

import com.takeon.burette.article.domain.Article;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class ArticleResponse {
    private Long id;
    private int type;
    private String title;
    private String subTitle;
    private String thumbnail;
    private String contents;
    private String tags;
    private int categoryId;

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

}
