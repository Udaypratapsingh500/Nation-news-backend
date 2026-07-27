package com.nationnews.service;

import com.nationnews.dto.FileUploadResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileStorageService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    public FileUploadResponse uploadFile(MultipartFile file) throws IOException {

        System.out.println("Upload Dir = " + uploadDir);
        Files.createDirectories(Paths.get(uploadDir));

        String extension =
                StringUtils.getFilenameExtension(file.getOriginalFilename());

        String fileName = UUID.randomUUID() + "." + extension;

        Path targetLocation =
                Paths.get(uploadDir).resolve(fileName);

        Files.copy(
                file.getInputStream(),
                targetLocation,
                StandardCopyOption.REPLACE_EXISTING
        );

        System.out.println("Saved File : " + targetLocation.toAbsolutePath());
        System.out.println("File Exists: " + Files.exists(targetLocation));

        return new FileUploadResponse(
                fileName,
                "/uploads/" + fileName
        );
    }
}