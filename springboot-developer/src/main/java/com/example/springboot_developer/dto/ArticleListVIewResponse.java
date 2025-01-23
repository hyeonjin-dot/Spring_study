package com.example.springboot_developer.dto;

import com.example.springboot_developer.domain.Article;
import lombok.Getter;

@Getter
public class ArticleListVIewResponse {
    private final Long id;
    private final String title;
    private final String content;

    public ArticleListVIewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
