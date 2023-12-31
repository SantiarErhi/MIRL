package org.santiarerhi.mirl.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ResourceController {
    
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";
    
    @GetMapping("/uploadimage") public String displayUploadForm() {
        return "imageupload/index";
    }
    
    @PostMapping("/upload") public String uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
        return "imageupload/index";
    }
}
