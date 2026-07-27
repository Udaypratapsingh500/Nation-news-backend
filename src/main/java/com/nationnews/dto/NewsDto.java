package com.nationnews.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NewsDto {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Short description is required")
    private String shortDescription;

    @NotBlank(message = "Content is required")
    private String content;

    @NotBlank(message = "Category is required")
    private String category;

    private String imageUrl;

    @NotBlank(message = "Author is required")
    private String author;

    private boolean featured;

    private boolean breakingNews;
}