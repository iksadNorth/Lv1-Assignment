package com.sparta.blogapp.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter @AllArgsConstructor
public enum ResponseType {
    DELETE_SUCCESSFULLY("정상적으로 삭제되었습니다.", "DELETE_SUCCESSFULLY", HttpStatus.OK);

    private final String msg;
    private final String code;
    private final HttpStatus status;
}
