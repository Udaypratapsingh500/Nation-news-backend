package com.nationnews.dto;

import com.nationnews.entity.Category;
import com.nationnews.entity.News;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HomeResponse {

    private List<News> breakingNews;

    private List<News> featuredNews;

    private List<News> latestNews;

    private List<News> mostRead;

    private List<Category> categories;

}