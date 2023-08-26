package com.sparta.blogapp.repository;

import com.sparta.blogapp.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
