package com.sparta.blogapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor
public class Article {
    private Long id;
    private String title;
    private String author;
    private String content;
    private LocalDateTime createdAt;
    private String password;

    public static Article fromResultSet(ResultSet rs, int rowNum) throws SQLException {
        Article entity = new Article();

        Long id = rs.getLong("id");
        String title = rs.getString("title");
        String author = rs.getString("author");
        String content = rs.getString("content");
        LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
        String password = rs.getString("password");

        entity.setId(id);
        entity.setTitle(title);
        entity.setAuthor(author);
        entity.setContent(content);
        entity.setCreatedAt(createdAt);
        entity.setPassword(password);
        return entity;
    }
}
