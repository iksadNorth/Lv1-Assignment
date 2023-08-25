package com.sparta.blogapp.service;

import com.sparta.blogapp.entity.Article;
import com.sparta.blogapp.model.ArticleCreateReq;
import com.sparta.blogapp.model.ArticleUpdateReq;

import java.util.List;

public interface ArticleService {

    Article create(ArticleCreateReq request);

    List<Article> readAll();

    Article readById(Long id);

    Article updateById(Long id, ArticleUpdateReq request);

    void deleteById(Long id, String password);
}
