package ru.itis.spring_11_402.services;

import ru.itis.spring_11_402.dto.ArticleDto;
import ru.itis.spring_11_402.dto.ArticleForm;

import java.util.List;

public interface ArticleService {
    List<ArticleDto> getByUser(Long id);

    ArticleDto addArticle(Long userId, ArticleForm articleForm);

    ArticleDto like(Long userId, Long articleId);
}
