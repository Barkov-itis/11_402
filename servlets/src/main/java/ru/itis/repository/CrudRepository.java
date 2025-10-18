package ru.itis.repository;

import java.sql.SQLException;

public interface CrudRepository<T> {
    void save(T entity) throws SQLException;
}
