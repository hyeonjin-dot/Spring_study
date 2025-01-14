package com.example.springboot_developer.controller;

import com.example.springboot_developer.domain.Article;
import com.example.springboot_developer.dto.AddArticleRequest;
import com.example.springboot_developer.dto.ArticleResponse;
import com.example.springboot_developer.dto.UpdateArticleRequest;
import com.example.springboot_developer.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {
    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> getAllArticles() {
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(articles);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> getArticleById(@PathVariable Long id) {
        Article article = blogService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(new ArticleResponse(article));
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticleById(@PathVariable Long id) {
        blogService.delete(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticleById(@PathVariable Long id, @RequestBody UpdateArticleRequest request) {
        Article article = blogService.update(id, request);

        return ResponseEntity.ok().body(article);
    }
}
