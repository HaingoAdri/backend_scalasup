package com.example.scalasup.controller;

import com.example.scalasup.entity.Article;
import com.example.scalasup.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        return articleRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Article createArticle(@RequestBody Article article) {
        return articleRepository.save(article);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody Article articleDetails) {
        return articleRepository.findById(id)
            .map(article -> {
                article.setTitre(articleDetails.getTitre());
                article.setContenu(articleDetails.getContenu());
                article.setDatePublication(articleDetails.getDatePublication());
                article.setUniversite(articleDetails.getUniversite());
                return ResponseEntity.ok(articleRepository.save(article));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable Long id) {
        return articleRepository.findById(id)
            .map(article -> {
                articleRepository.delete(article);
                return ResponseEntity.ok().build();
            })
            .orElse(ResponseEntity.notFound().build());
    }
}