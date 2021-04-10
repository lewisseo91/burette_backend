package com.takeon.burette.article.application;

import com.takeon.burette.article.domain.Article;
import com.takeon.burette.article.dao.ArticleDao;
import com.takeon.burette.article.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private ArticleDao articleDao;

    public ArticleService(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public ArticleCreateResponse saveArticle(ArticleCreateRequest articleCreateRequest) {
        Article article = new Article(articleCreateRequest);
        int articleId = articleDao.save(article); // article
        return new ArticleCreateResponse(articleId);
   }

    public ArticleDeleteResponse deleteById(ArticleDeleteRequest articleDeleteRequest) {
        boolean isDeleted = articleDao.deleteById(articleDeleteRequest);
        return new ArticleDeleteResponse(isDeleted);
    }

    public ArticleReadResponse getById(ArticleReadRequest articleReadRequest) {
        Article article = articleDao.getById(articleReadRequest);
        System.out.println(article);
        return new ArticleReadResponse(0);
    }

    public ArticleListResponse getLatestArticlesByCategory() {
        List<Article> articleList = articleDao.getLatestArticlesByCategory();
        return new ArticleListResponse(articleList);
    }


}
