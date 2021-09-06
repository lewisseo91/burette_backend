package com.takeon.burette.article.service;

import com.takeon.burette.article.domain.Article;
import com.takeon.burette.article.dto.ArticleRequest;
import com.takeon.burette.article.dto.ArticleResponse;
import com.takeon.burette.article.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public ArticleResponse saveArticle(ArticleRequest articleRequest) {
        Article article = new Article(articleRequest);
        articleRepository.save(article);

        return new ArticleResponse(article);
    }

    public boolean deleteById(Long id) {
        try {
            articleRepository.deleteById(id);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public ArticleResponse getArticleById(Long id) {
        Optional<Article> articleOpt = articleRepository.findById(id);
        if (articleOpt.isPresent()) {
            Article article = articleOpt.get();
            return new ArticleResponse(article);
        }

        return null;
    }

    public List<ArticleResponse> getLatestArticlesByCategory() {
        List<Article> articleList = articleRepository.getLatestArticlesByCategory();
        return articleList.stream()
                .map(ArticleResponse::new)
                .collect(Collectors.toList());
    }
}
