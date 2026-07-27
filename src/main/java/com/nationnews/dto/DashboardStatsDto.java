package com.nationnews.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DashboardStatsDto {

    private long totalNews;
    private long featuredNews;
    private long breakingNews;
    private long totalCategories;
    private long totalUsers;
    private long admins;
    private long editors;
    private long reporters;
    private long totalViews;
}