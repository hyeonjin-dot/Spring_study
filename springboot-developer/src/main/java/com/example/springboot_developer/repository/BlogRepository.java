package com.example.springboot_developer.repository;

import com.example.springboot_developer.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
