package com.takeon.burette.article.application;

import com.takeon.burette.article.domain.Article;
import com.takeon.burette.article.dao.ArticleDao;
import com.takeon.burette.article.dto.ArticleRequest;
import com.takeon.burette.article.dto.ArticleResponse;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private ArticleDao articleDao;

    public ArticleService(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public ArticleResponse saveArticle(ArticleRequest articleRequest) {
        Article article = new Article(articleRequest);
        int articleId = articleDao.save(article); // article
        return new ArticleResponse(articleId);
   }


}
