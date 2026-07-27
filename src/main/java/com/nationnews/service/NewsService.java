package com.nationnews.service;

import com.nationnews.entity.Category;
import com.nationnews.entity.News;
import com.nationnews.repository.CategoryRepository;
import com.nationnews.repository.NewsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class NewsService {

    private final NewsRepository newsRepository;
    private final CategoryRepository categoryRepository;

    public NewsService(NewsRepository newsRepository,
                       CategoryRepository categoryRepository) {
        this.newsRepository = newsRepository;
        this.categoryRepository = categoryRepository;
    }

    // Create News
    public News createNews(News news) {
        return newsRepository.save(news);
    }

    // Get All News
    public Page<News> getAllNews(int page, int size) {
        return newsRepository.findAll(PageRequest.of(page, size));
    }

    // Get News By ID
    public News getNewsById(Long id) {
        return newsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("News not found"));
    }

    // Update News
    public News updateNews(Long id, News updatedNews) {

        News news = getNewsById(id);

        news.setTitle(updatedNews.getTitle());
        news.setShortDescription(updatedNews.getShortDescription());
        news.setContent(updatedNews.getContent());
        news.setCategory(updatedNews.getCategory());
        news.setImageUrl(updatedNews.getImageUrl());

        // NEW
        news.setVideoUrl(updatedNews.getVideoUrl());

        news.setAuthor(updatedNews.getAuthor());
        news.setFeatured(updatedNews.isFeatured());
        news.setBreakingNews(updatedNews.isBreakingNews());

        return newsRepository.save(news);
    }

    // Delete News
    public void deleteNews(Long id) {

        News news = getNewsById(id);

        newsRepository.delete(news);
    }

    // Get News By Category
    public Page<News> getByCategory(String categoryName, int page, int size) {

        Category category = categoryRepository
                .findByNameIgnoreCase(categoryName)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        return newsRepository.findByCategory(
                category,
                PageRequest.of(page, size)
        );
    }

    // Search News
    public Page<News> search(String keyword, int page, int size) {

        return newsRepository.findByTitleContainingIgnoreCase(
                keyword,
                PageRequest.of(page, size)
        );
    }

    // Breaking News
    public Page<News> breakingNews(int page, int size) {

        return newsRepository.findByBreakingNewsTrue(
                PageRequest.of(page, size)
        );
    }

    // Featured News
    public Page<News> featuredNews(int page, int size) {

        return newsRepository.findByFeaturedTrue(
                PageRequest.of(page, size)
        );
    }
}