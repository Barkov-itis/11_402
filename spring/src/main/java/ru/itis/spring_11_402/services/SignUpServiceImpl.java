package ru.itis.spring_11_402.services;

import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.spring_11_402.dto.UserForm;
import ru.itis.spring_11_402.models.Role;
import ru.itis.spring_11_402.models.User;
import ru.itis.spring_11_402.repository.UsersRepository;

import java.io.IOException;
import java.util.UUID;

@Component
public class SignUpServiceImpl implements SignUpService{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private MailService mailService;

    @Override
    public void addUser(UserForm userForm) throws TemplateException, IOException {
        User user = User.builder()
                .name(userForm.getName())
                .email(userForm.getEmail())
                .role(Role.ADMIN)
                .password(passwordEncoder.encode(userForm.getPassword()))
                .confirmed("NOT_CONFIRMED")
                .confirmCode(UUID.randomUUID().toString())
                .build();
        usersRepository.save(user);
        mailService.sendEmailForConfirm(user.getEmail(), user.getConfirmCode());
    }
}
