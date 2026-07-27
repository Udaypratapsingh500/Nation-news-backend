package com.nationnews.repository;

import com.nationnews.entity.Category;
import com.nationnews.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {

    Page<News> findByCategory(Category category, Pageable pageable);

    Page<News> findByTitleContainingIgnoreCase(String keyword, Pageable pageable);

    Page<News> findByBreakingNewsTrue(Pageable pageable);

    Page<News> findByFeaturedTrue(Pageable pageable);

    long countByFeaturedTrue();

    long countByBreakingNewsTrue();

    @Query("SELECT COALESCE(SUM(n.views), 0) FROM News n")
    Long getTotalViews();

    List<News> findTop5ByBreakingNewsTrueOrderByPublishedAtDesc();

    List<News> findTop6ByFeaturedTrueOrderByPublishedAtDesc();

    List<News> findTop10ByOrderByPublishedAtDesc();

    List<News> findTop8ByOrderByViewsDesc();
}