package com.nationnews.controller;

import com.nationnews.dto.FileUploadResponse;
import com.nationnews.service.FileStorageService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
@CrossOrigin(origins = "*")
public class UploadController {

    private final FileStorageService fileStorageService;

    public UploadController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public FileUploadResponse uploadImage(
            @RequestParam("file") MultipartFile file
    ) throws Exception {

        return fileStorageService.uploadFile(file);
    }

}