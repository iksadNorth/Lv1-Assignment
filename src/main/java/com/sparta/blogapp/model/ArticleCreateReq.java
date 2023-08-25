package com.sparta.blogapp.model;

import lombok.Builder;

@Builder(toBuilder = true)
public record ArticleCreateReq(
    String title,
    String author,
    String content,
    String password
) {
}
