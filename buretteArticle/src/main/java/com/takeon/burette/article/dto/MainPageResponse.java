package com.takeon.burette.article.dto;

import com.takeon.burette.article.domain.MainPage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MainPageResponse {
    private Long id;
    private Long articleId;

    public MainPageResponse(MainPage mainPage) {
        this.id = mainPage.getId();
        this.articleId = mainPage.getArticleId();
    }
}
