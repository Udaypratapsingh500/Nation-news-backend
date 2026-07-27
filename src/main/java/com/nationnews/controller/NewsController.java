package com.nationnews.controller;

import com.nationnews.entity.News;
import com.nationnews.service.NewsService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/news")
@CrossOrigin(origins = "*")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    // Create News
    @PostMapping
    public News createNews(@Valid @RequestBody News news) {
        return newsService.createNews(news);
    }

    // Get All News
    @GetMapping
    public Page<News> getAllNews(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return newsService.getAllNews(page, size);
    }

    // Get News By ID
    @GetMapping("/{id}")
    public News getNews(@PathVariable Long id) {
        return newsService.getNewsById(id);
    }

    // Update News
    @PutMapping("/{id}")
    public News updateNews(
            @PathVariable Long id,
            @RequestBody News news) {

        return newsService.updateNews(id, news);
    }

    // Delete News
    @DeleteMapping("/{id}")
    public void deleteNews(@PathVariable Long id) {
        newsService.deleteNews(id);
    }

    // Category
    @GetMapping("/category/{category}")
    public Page<News> category(
            @PathVariable String category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return newsService.getByCategory(category, page, size);
    }

    // Search
    @GetMapping("/search")
    public Page<News> search(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return newsService.search(keyword, page, size);
    }

    // Breaking
    @GetMapping("/breaking")
    public Page<News> breaking(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return newsService.breakingNews(page, size);
    }

    // Featured
    @GetMapping("/featured")
    public Page<News> featured(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return newsService.featuredNews(page, size);
    }
}