package com.nationnews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.nationnews")
public class NationNewsBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(NationNewsBackendApplication.class, args);
    }

}