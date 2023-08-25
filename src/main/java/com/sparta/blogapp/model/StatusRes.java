package com.sparta.blogapp.model;

import com.sparta.blogapp.exception.BlogException;
import com.sparta.blogapp.type.ResponseType;
import lombok.Builder;

@Builder(toBuilder = true)
public record StatusRes(
        String msg,
        String code
) {
    public static StatusRes success() {
        return fromType(ResponseType.DELETE_SUCCESSFULLY);
    }

    public static StatusRes fromType(BlogException type) {
        return StatusRes.builder()
                .msg(type.getMsg())
                .code(type.getCode())
                .build();
    }
}
