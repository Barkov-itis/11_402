package ru.itis.spring_11_402.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "account")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    private String email;
    private String password;

    @OneToMany(mappedBy = "author")
    private List<Article> createdArticles;

    @ManyToMany(mappedBy = "likes")
    private List<Article> articles;

    private Role role;
}
