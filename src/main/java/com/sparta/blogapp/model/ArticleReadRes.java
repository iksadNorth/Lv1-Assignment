package com.sparta.blogapp.model;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
public record ArticleReadRes(
        String title,
        String author,
        String content,
        LocalDateTime createdAt
) {
}
