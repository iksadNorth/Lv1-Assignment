package com.sparta.blogapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor
public class Article {
    private Long id;
    private String title;
    private String author;
    private String content;
    private LocalDateTime createdAt;
    private String password;
}
