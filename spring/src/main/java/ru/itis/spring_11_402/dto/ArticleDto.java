package ru.itis.spring_11_402.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.patterns.ExactTypePattern;
import ru.itis.spring_11_402.models.Article;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDto {
    private Long id;
    private String text;
    private String autorName;
    private Integer likesCount;

    public static ArticleDto from(Article article) {
        Integer likesCount;
        try {
            likesCount = article.getLikes().size();
        } catch (Exception e) {
            likesCount = 0;
        }
        return ArticleDto.builder()
                .id(article.getArticleId())
                .text(article.getText())
                .autorName(article.getAuthor().getEmail())
                .likesCount(likesCount)
                .build();
    }

    public static List<ArticleDto> articlesList(List<Article> articles){
        return articles.stream()
                .map(ArticleDto::from)
                .collect(Collectors.toList());
    }
}
