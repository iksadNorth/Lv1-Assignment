package com.sparta.blogapp.exception;

import org.springframework.http.HttpStatus;

public interface BlogException {
    String getMsg();
    String getCode();
    HttpStatus getStatus();
}
