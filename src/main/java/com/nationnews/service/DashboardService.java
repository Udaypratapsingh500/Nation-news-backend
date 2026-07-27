package com.nationnews.service;

import com.nationnews.dto.DashboardStatsDto;
import com.nationnews.entity.Role;
import com.nationnews.repository.CategoryRepository;
import com.nationnews.repository.NewsRepository;
import com.nationnews.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final NewsRepository newsRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public DashboardService(
            NewsRepository newsRepository,
            CategoryRepository categoryRepository,
            UserRepository userRepository) {

        this.newsRepository = newsRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    public DashboardStatsDto getDashboardStats() {

        Long totalViews = newsRepository.getTotalViews();

        if (totalViews == null) {
            totalViews = 0L;
        }

        return new DashboardStatsDto(
                newsRepository.count(),
                newsRepository.countByFeaturedTrue(),
                newsRepository.countByBreakingNewsTrue(),
                categoryRepository.count(),
                userRepository.count(),
                userRepository.countByRole(Role.ADMIN),
                userRepository.countByRole(Role.EDITOR),
                userRepository.countByRole(Role.REPORTER),
                totalViews
        );
    }
}