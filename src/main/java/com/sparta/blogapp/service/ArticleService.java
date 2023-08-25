package com.sparta.blogapp.service;

import com.sparta.blogapp.entity.Article;
import com.sparta.blogapp.model.ArticleReq;

import java.util.List;

public interface ArticleService {

    Article create(ArticleReq request);

    List<Article> readAll();

    Article readById(Long id);

    Article updateById(Long id, ArticleReq request);

    void deleteById(Long id, String password);
}
