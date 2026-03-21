package ru.itis.spring_11_402.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.spring_11_402.services.FileStrorageService;

@Controller
public class FileController {

    @Autowired
    private FileStrorageService fileStorageService;

    @GetMapping("/files")
    public String getFilesUploadPage() {
        return "file_upload_page";
    }

    @PostMapping("/files")
    public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile file) {
        System.out.println(file.getName());
        String filePath = fileStorageService.saveFile(file);
        System.out.println(filePath);
        return ResponseEntity.ok()
                .body(filePath);
    }

    @GetMapping("/files/{file-name:.+}")
    public void getFile(@PathVariable("file-name") String fileName, HttpServletResponse response) {
        fileStorageService.writeFileToResponse(fileName, response);
    }
}
