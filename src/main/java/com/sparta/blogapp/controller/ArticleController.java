package com.sparta.blogapp.controller;

import com.sparta.blogapp.model.ArticleCreateReq;
import com.sparta.blogapp.model.ArticleReadRes;
import com.sparta.blogapp.model.ArticleUpdateReq;
import com.sparta.blogapp.model.StatusRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ArticleController {

    @PostMapping
    public ArticleReadRes create(@RequestBody ArticleCreateReq request) {
        return null;
    }

    @GetMapping
    public List<ArticleReadRes> readAll(@RequestBody ArticleCreateReq request) {
        return null;
    }

    @GetMapping("/{id}")
    public ArticleReadRes readById(@PathVariable Long id) {
        return null;
    }

    @PutMapping("/{id}")
    public ArticleReadRes updateById(@PathVariable Long id, @RequestBody ArticleUpdateReq request) {
        return null;
    }

    @DeleteMapping("/{id}")
    public StatusRes deleteById(@PathVariable Long id, @RequestParam String password) {
        return null;
    }
}
