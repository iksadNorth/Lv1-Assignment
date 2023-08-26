package com.sparta.blogapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity @Table(name = "article")
@Getter @Setter @NoArgsConstructor
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String content;
    private LocalDateTime createdAt;
    private String password;

    public static Article from(Article entity) {
        Article copied = new Article();
        copied.setId(entity.getId());
        copied.setTitle(entity.getTitle());
        copied.setAuthor(entity.getAuthor());
        copied.setContent(entity.getContent());
        copied.setCreatedAt(entity.getCreatedAt());
        copied.setPassword(entity.getPassword());
        return copied;
    }
}
