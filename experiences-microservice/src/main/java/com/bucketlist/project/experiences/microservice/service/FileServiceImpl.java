package com.bucketlist.project.experiences.microservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService{

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        String projectRoot = System.getProperty("user.dir");
        String fullPath = Paths.get(projectRoot, path).toString();

        String originalFileName = file.getOriginalFilename();
        String randomId = UUID.randomUUID().toString();
        String fileName = randomId.concat(originalFileName.substring(originalFileName.lastIndexOf('.')));
        String filePath = Paths.get(fullPath, fileName).toString();

        File folder = new File(path);
        if(!folder.exists()){
            folder.mkdirs();
        }

        Files.copy(file.getInputStream(), Paths.get(filePath));

        return fileName;

    }
}
