package ru.itis.spring_11_402.services;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

public interface FileStrorageService {
    String saveFile(MultipartFile uploadFile);
    void writeFileToResponse (String fileName, HttpServletResponse response);
}
