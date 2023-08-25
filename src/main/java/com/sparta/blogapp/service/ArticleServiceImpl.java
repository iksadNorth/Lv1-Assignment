package com.sparta.blogapp.service;

import com.sparta.blogapp.entity.Article;
import com.sparta.blogapp.model.ArticleReq;
import com.sparta.blogapp.repository.ArticleRepository;
import com.sparta.blogapp.type.ResponseType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    @Override
    public Article create(ArticleReq request) {
        request.verify();

        Article entity = request.toEntity();
        return articleRepository.create(entity);
    }

    @Override
    public List<Article> readAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article readById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(ResponseType.ARTICLE_NOT_FOUNDED::toException);
    }

    @Override
    public Article updateById(Long id, ArticleReq request) {
        request.verify();
        Article entity = readById(id);
        verifyPassword(entity.getPassword(), request.password());

        return articleRepository.updateById(id, request.toEntity())
                .orElseThrow(ResponseType.ARTICLE_NOT_FOUNDED::toException);
    }

    @Override
    public void deleteById(Long id, String password) {
        Article entity = readById(id);
        verifyPassword(entity.getPassword(), password);

        articleRepository.deleteById(id);
    }

    private void verifyPassword(String passwordInDb, String password) {
        if(!passwordInDb.equals(password)) {
            throw ResponseType.WRONG_PASSWORD.toException();
        }
    }
}
