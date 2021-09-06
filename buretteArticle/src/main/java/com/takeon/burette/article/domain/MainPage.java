package com.takeon.burette.article.domain;

import com.takeon.burette.article.dto.MainPageRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class MainPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long articleId;

    public MainPage(MainPageRequest mainPageRequest) {
        this.articleId = mainPageRequest.getArticleId();
    }
}
