package com.nationnews.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "news")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String title;

    @Column(length = 500)
    private String shortDescription;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private String imageUrl;

    // YouTube Video URL
    @Column(length = 500)
    private String videoUrl;

    private String author;

    private boolean featured;

    private boolean breakingNews;

    @Builder.Default
    private int views = 0;

    private LocalDateTime publishedAt;

    @PrePersist
    public void onCreate() {
        publishedAt = LocalDateTime.now();
    }
}