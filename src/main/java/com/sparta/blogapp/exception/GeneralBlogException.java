package com.sparta.blogapp.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter @Builder(toBuilder = true)
public class GeneralBlogException extends RuntimeException implements BlogException {
    private final String msg;
    private final String code;
    private final HttpStatus status;
}
