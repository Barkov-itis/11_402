package ru.itis.spring_11_402.repository;

import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.spring_11_402.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    public Optional<User> findByEmail(String email);
}
