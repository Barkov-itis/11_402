package ru.itis.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.dto.SignUpForm;
import ru.itis.models.User;
import ru.itis.repository.UsersRepository;

import java.sql.SQLException;

public class SignUpServiceImpl implements SignUpService{

    private PasswordEncoder passwordEncoder;
    private UsersRepository usersRepository;

    public SignUpServiceImpl(UsersRepository usersRepository) {
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.usersRepository = usersRepository;
    }
    @Override
    public void signUp(SignUpForm form) throws SQLException {
        User user = User.builder()
                .name(form.getFirstName())
                .surname(form.getLastName())
                .login(form.getEmail())
                .password(passwordEncoder.encode(form.getPassword()))
                .build();
        usersRepository.save(user);
    }
}

// Boolean pass = passwordEncoder.matches(rawPass, encodePass);