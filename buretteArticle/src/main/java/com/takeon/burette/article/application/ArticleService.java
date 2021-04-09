package com.takeon.burette.article.application;

import com.takeon.burette.article.domain.Article;
import com.takeon.burette.article.dao.ArticleDao;
import com.takeon.burette.article.dto.ArticleCreateRequest;
import com.takeon.burette.article.dto.ArticleCreateResponse;
import com.takeon.burette.article.dto.ArticleDeleteRequest;
import com.takeon.burette.article.dto.ArticleDeleteResponse;
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


}
