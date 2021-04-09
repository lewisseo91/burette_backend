package com.takeon.burette.article.application;

import com.takeon.burette.article.domain.Article;
import com.takeon.burette.article.dao.ArticleDao;
import com.takeon.burette.article.dto.*;
import org.springframework.stereotype.Service;

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
        return new ArticleReadResponse(article);
    }


}
