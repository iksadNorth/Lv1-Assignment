package com.sparta.blogapp.controller;

import com.sparta.blogapp.model.ArticleCreateReq;
import com.sparta.blogapp.model.ArticleReadRes;
import com.sparta.blogapp.model.ArticleUpdateReq;
import com.sparta.blogapp.model.StatusRes;
import com.sparta.blogapp.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping
    public ArticleReadRes create(@RequestBody ArticleCreateReq request) {
        return ArticleReadRes.fromEntity(articleService.create(request));
    }

    @GetMapping
    public List<ArticleReadRes> readAll() {
        return articleService.readAll().stream()
                .map(ArticleReadRes::fromEntity)
                .toList();
    }

    @GetMapping("/{id}")
    public ArticleReadRes readById(@PathVariable Long id) {
        return ArticleReadRes.fromEntity(articleService.readById(id));
    }

    @PutMapping("/{id}")
    public ArticleReadRes updateById(@PathVariable Long id, @RequestBody ArticleUpdateReq request) {
        return ArticleReadRes.fromEntity(articleService.updateById(id, request));
    }

    @DeleteMapping("/{id}")
    public StatusRes deleteById(@PathVariable Long id, @RequestParam String password) {
        articleService.deleteById(id, password);
        return StatusRes.success();
    }
}
