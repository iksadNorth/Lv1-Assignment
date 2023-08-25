package com.sparta.blogapp.service;

import com.sparta.blogapp.entity.Article;
import com.sparta.blogapp.model.ArticleCreateReq;
import com.sparta.blogapp.model.ArticleUpdateReq;
import com.sparta.blogapp.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    @Override
    public Article create(ArticleCreateReq request) {
        return null;
    }

    @Override
    public List<Article> readAll() {
        return null;
    }

    @Override
    public Article readById(Long id) {
        return null;
    }

    @Override
    public Article updateById(Long id, ArticleUpdateReq request) {
        return null;
    }

    @Override
    public void deleteById(Long id, String password) {

    }
}
