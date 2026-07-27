package com.nationnews.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        String uploadPath = Paths.get(uploadDir)
                .toAbsolutePath()
                .toString();

        System.out.println("=================================");
        System.out.println("WebConfig Loaded");
        System.out.println("Upload Directory : " + uploadDir);
        System.out.println("Absolute Path    : " + uploadPath);
        System.out.println("=================================");

        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:" + uploadPath + "/");
    }
}