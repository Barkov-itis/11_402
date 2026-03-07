package ru.itis.spring_11_402.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.spring_11_402.dto.ArticleDto;
import ru.itis.spring_11_402.dto.ArticleForm;
import ru.itis.spring_11_402.models.Article;
import ru.itis.spring_11_402.models.User;
import ru.itis.spring_11_402.repository.ArticleRepository;
import ru.itis.spring_11_402.repository.UsersRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Component
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<ArticleDto> getByUser(Long id) {
        Optional<User> user = usersRepository.findById(id);
        List<Article> articlesOfUser = user.get().getCreatedArticles();
        return ArticleDto.articlesList(articlesOfUser);
    }

    @Override
    public ArticleDto addArticle(Long userId, ArticleForm articleForm) {
        Optional<User> author = usersRepository.findById(userId);
        Article newArticle = Article.builder()
                .text(articleForm.getText())
                .name(articleForm.getName())
                .author(author.get())
                .build();
        articleRepository.save(newArticle);
        return ArticleDto.from(newArticle);
    }

    @Override
    public ArticleDto like(Long userId, Long articleId) {
        Optional<User> user = usersRepository.findById(userId);
        Optional<Article> article = articleRepository.findById(articleId);
        if (articleRepository.existsByArticleIdAndLikesContaining(articleId, user.get())) {
            article.get().getLikes().remove(user.get());
        }
        else {
            article.get().getLikes().add(user.get());
        }
        System.out.println("**********************************");
        articleRepository.save(article.get());
        return ArticleDto.from(article.get());
    }
}
