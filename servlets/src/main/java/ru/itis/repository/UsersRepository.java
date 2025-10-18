package ru.itis.repository;

import ru.itis.models.User;

import java.util.List;

public interface UsersRepository extends CrudRepository<User>{
    List findAll();
}
