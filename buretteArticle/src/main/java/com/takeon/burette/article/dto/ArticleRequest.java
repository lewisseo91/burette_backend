package com.takeon.burette.article.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ArticleRequest {
    private int type;
    private String title;
    private String subTitle;
    private List<String> thumbnail; // List<String> 가능성 있음
    private String contents;
    private List<String> tags;
    private int categoryId;
}
