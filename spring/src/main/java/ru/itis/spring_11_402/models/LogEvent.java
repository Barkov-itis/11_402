package ru.itis.spring_11_402.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long logEventId;
    private String text;

    @OneToMany(mappedBy = "name")
    private Type type;
    private String method;

    @Column(updatable = false, nullable = false)
    private Date createdAt;
}
