package com.nationnews.service;

import com.nationnews.dto.HomeResponse;
import com.nationnews.repository.CategoryRepository;
import com.nationnews.repository.NewsRepository;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    private final NewsRepository newsRepository;
    private final CategoryRepository categoryRepository;

    public HomeService(
            NewsRepository newsRepository,
            CategoryRepository categoryRepository
    ) {
        this.newsRepository = newsRepository;
        this.categoryRepository = categoryRepository;
    }

    public HomeResponse getHomeData() {

        return HomeResponse.builder()

                .breakingNews(
                        newsRepository.findTop5ByBreakingNewsTrueOrderByPublishedAtDesc()
                )

                .featuredNews(
                        newsRepository.findTop6ByFeaturedTrueOrderByPublishedAtDesc()
                )

                .latestNews(
                        newsRepository.findTop10ByOrderByPublishedAtDesc()
                )

                .mostRead(
                        newsRepository.findTop8ByOrderByViewsDesc()
                )

                .categories(
                        categoryRepository.findByActiveTrue()
                )

                .build();
    }
}