package ru.itis.spring_11_402.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    private String name;

    @Column(length = 1000)
    private String text;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private User author;

    @ManyToMany
    @JoinTable(name = "articles_likes",
            joinColumns = @JoinColumn(name = "article_id", referencedColumnName = "articleId"),
            inverseJoinColumns = @JoinColumn(name = "account_id", referencedColumnName = "accountId")
    )
    private List<User> likes;
}
