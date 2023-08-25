package com.sparta.blogapp.model;

import com.sparta.blogapp.entity.Article;
import com.sparta.blogapp.exception.GeneralBlogException;
import com.sparta.blogapp.type.ResponseType;
import lombok.Builder;

@Builder(toBuilder = true)
public record ArticleReq(
    String title,
    String author,
    String content,
    String password
) {
    public Article toEntity() {
        Article entity = new Article();
        entity.setTitle(this.title);
        entity.setAuthor(this.author);
        entity.setContent(this.content);
        entity.setPassword(this.password);
        return entity;
    }

    public void verify() {
        String column = null;

        if(title.isBlank()) {
            column = "제목이";
        } else if (author.isBlank()) {
            column = "작성자 이름이";
        } else if (password.isBlank()) {
            column = "비밀 번호가";
        }

        if (column != null) {
            ResponseType type = ResponseType.INVALID_INPUT;
            throw GeneralBlogException.builder()
                    .msg(String.format(type.getMsg(), column))
                    .code(type.getCode())
                    .build();
        }
    }
}
