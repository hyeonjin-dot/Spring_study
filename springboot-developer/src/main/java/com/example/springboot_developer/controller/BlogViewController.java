package com.example.springboot_developer.controller;

import com.example.springboot_developer.domain.Article;
import com.example.springboot_developer.dto.ArticleListVIewResponse;
import com.example.springboot_developer.dto.ArticleViewResponse;
import com.example.springboot_developer.service.BlogService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {
    private final BlogService blogService;

    @GetMapping("/articles")
    public String articles(Model model) {
        List<ArticleListVIewResponse> articles = blogService.findAll().stream()
                .map(ArticleListVIewResponse::new)
                .toList();

        model.addAttribute("articles", articles);
        return "articleList";
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));

        return "article";
    }

    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required = false)Long id, Model model) {
        if (id == null){
            model.addAttribute("article", new ArticleViewResponse());
        }else {
            Article article = blogService.findById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }

        return "newArticle";
    }
}
