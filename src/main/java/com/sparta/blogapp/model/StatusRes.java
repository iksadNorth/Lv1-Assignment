package com.sparta.blogapp.model;

import lombok.Builder;

@Builder(toBuilder = true)
public record StatusRes(
        String msg,
        String code
) {
}
