package ru.itis.spring_11_402.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticleForm {
    private String name;
    private String text;
}
