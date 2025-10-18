package ru.itis.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.core.SpringVersion;

@Data
@Builder
public class SignUpForm {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
