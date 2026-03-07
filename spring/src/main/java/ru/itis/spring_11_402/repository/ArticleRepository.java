package ru.itis.spring_11_402.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.spring_11_402.models.Article;
import ru.itis.spring_11_402.models.User;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    boolean existsByArticleIdAndLikesContaining(Long articleId, User user);
}
