package com.sparta.blogapp.type;

import com.sparta.blogapp.exception.BlogException;
import com.sparta.blogapp.exception.GeneralBlogException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter @AllArgsConstructor
public enum ResponseType implements BlogException {
    INTERNAL_SERVER_ERROR("비정상적인 서버 작동이 감지되었습니다", "INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR),
    WRONG_PASSWORD("비밀번호가 맞지 않습니다", "WRONG_PASSWORD", HttpStatus.FORBIDDEN),
    ARTICLE_NOT_FOUNDED("존재하지 않는 게시물입니다.", "ARTICLE_NOT_FOUNDED", HttpStatus.NOT_FOUND),
    INVALID_INPUT("%s 빈칸으로 넘어왔습니다. 다시 입력해주세요", "INVALID_INPUT", HttpStatus.BAD_REQUEST),
    DELETE_SUCCESSFULLY("정상적으로 삭제되었습니다.", "DELETE_SUCCESSFULLY", HttpStatus.OK);

    private final String msg;
    private final String code;
    private final HttpStatus status;

    public GeneralBlogException toException() {
        return GeneralBlogException.builder()
                .msg(this.getMsg())
                .code(this.getCode())
                .status(this.getStatus())
                .build();
    }
}
