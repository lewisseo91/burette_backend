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

    public ArticleResponse saveArticle(ArticleRequest articleRequest) {
        Article article = new Article(articleRequest);
        int articleId = articleDao.save(article);
        return new ArticleResponse(articleId);
   }

    public boolean deleteById(ArticleRequest articleRequest) {
        return articleDao.deleteById(articleRequest.getId());
    }

    public ArticleResponse getById(ArticleRequest articleRequest) {
        Article article = articleDao.getById(articleRequest.getId());
        return new ArticleResponse(article);
    }

    public ArticleResponse getLatestArticlesByCategory() {
        List<Article> articleList = articleDao.getLatestArticlesByCategory();
        return new ArticleResponse(articleList);
    }


}
