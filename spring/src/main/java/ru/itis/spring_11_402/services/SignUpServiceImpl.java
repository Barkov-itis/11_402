package ru.itis.spring_11_402.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.spring_11_402.dto.UserForm;
import ru.itis.spring_11_402.models.User;
import ru.itis.spring_11_402.repository.UsersRepository;

@Component
public class SignUpServiceImpl implements SignUpService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void addUser(UserForm userForm) {
        User user = User.builder()
                .email(userForm.getEmail())
                .password(userForm.getPassword())
                .build();
        usersRepository.save(user);
    }
}
