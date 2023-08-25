package com.sparta.blogapp.controller;

import com.sparta.blogapp.exception.GeneralBlogException;
import com.sparta.blogapp.model.StatusRes;
import com.sparta.blogapp.type.ResponseType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(GeneralBlogException.class)
    public ResponseEntity<StatusRes> handleException(GeneralBlogException ex) {
        return ResponseEntity.status(ex.getStatus())
                .body(StatusRes.fromType(ex));
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<StatusRes> handleException(Throwable ex) {
        ResponseType type = ResponseType.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(type.getStatus())
                .body(StatusRes.fromType(type));
    }
}
