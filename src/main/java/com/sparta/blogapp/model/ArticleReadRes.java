package com.sparta.blogapp.model;

import com.sparta.blogapp.entity.Article;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
public record ArticleReadRes(
        String title,
        String author,
        String content,
        LocalDateTime createdAt
) {
    public static ArticleReadRes fromEntity(Article entity) {
        return ArticleReadRes.builder()
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .content(entity.getContent())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
