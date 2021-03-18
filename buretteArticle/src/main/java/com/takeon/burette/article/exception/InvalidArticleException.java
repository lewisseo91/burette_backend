package com.takeon.burette.article.exception;

public class InvalidArticleException extends RuntimeException {
    private static final String INVALID_ARTICLE_EXCEPTION = "잘못된 기사 생성 요청하였습니다.";

    public InvalidArticleException() {
        super(INVALID_ARTICLE_EXCEPTION);
    }

}
