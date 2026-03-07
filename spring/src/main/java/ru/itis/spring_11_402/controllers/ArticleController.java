package ru.itis.spring_11_402.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.spring_11_402.dto.ArticleDto;
import ru.itis.spring_11_402.dto.ArticleForm;
import ru.itis.spring_11_402.services.ArticleService;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/users/{userId}/articles")
    public String getArticleOfUser(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("articles", articleService.getByUser(userId));
        model.addAttribute("userId", userId);
        return "article_page";
    }

    @PostMapping("/users/{userId}/articles")
    @ResponseBody
    public ArticleDto addArticleOfUser(@PathVariable("userId") Long userId,
                                       @ModelAttribute ArticleForm articleForm) {
        return articleService.addArticle(userId, articleForm);
    }

    @PostMapping("/users/{userId}/article/{articleId}/like")
    @ResponseBody
    public Object like(@PathVariable ("userId") Long userId,
                       @PathVariable ("articleId") Long articleId) {
        return articleService.like(userId, articleId);
    }

}
