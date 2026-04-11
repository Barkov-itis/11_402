package ru.itis.spring_11_402.models;

import jakarta.persistence.*;

//TODO:аннотации + настрйока PK
public class Type {
    @Id
    @GeneratedValue
    private String id;

    @ManyToOne
    @JoinColumn(name = "name")
    private String name;
}
