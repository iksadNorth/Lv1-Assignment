package com.sparta.blogapp.repository;

import com.sparta.blogapp.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("SELECT a FROM Article a ORDER BY a.createdAt DESC")
    List<Article> findAll();
}
