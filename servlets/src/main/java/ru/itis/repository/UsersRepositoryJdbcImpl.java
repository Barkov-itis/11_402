package ru.itis.repository;

import ru.itis.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryJdbcImpl implements UsersRepository{

    private DataSource dataSource;

    private static final String SQL_SELECT_ALL_FROM_DRIVER = "select * from driver";

    private static final String SQL_INSERT_INTO_DRIVER = "insert into driver(login, password, name, surname) values (?,?,?,?)";

    public UsersRepositoryJdbcImpl (DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(User entity) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_INTO_DRIVER);
        preparedStatement.setString(1, entity.getLogin());
        preparedStatement.setString(2, entity.getPassword());
        preparedStatement.setString(3, entity.getName());
        preparedStatement.setString(4, entity.getSurname());
        preparedStatement.executeUpdate();
        System.out.println(entity.getLogin());
    }

    @Override
    public List findAll() {
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_FROM_DRIVER);
            List<User> result = new ArrayList<>();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
                User user = User.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
                        .surname(resultSet.getString("surname"))
                        .build();
                result.add(user);
            }
            return result;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
