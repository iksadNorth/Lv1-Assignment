package com.sparta.blogapp.repository;

import com.sparta.blogapp.entity.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository {
    Article create(Article entity);

    List<Article> findAll();

    Optional<Article> findById(Long id);

    Optional<Article> updateById(Long id, Article entity);

    void deleteById(Long id);
}
