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

//    public List<GunStats> findGunStatsByLogin(String login) {
//        System.out.println("Function: findGunStatsByLogin started");
//        try {
//            Connection connection = dataSource.getConnection();
//            PreparedStatement statement = connection.prepareStatement(SQL_GET_GUN_STATS);
//
//            statement.setString(1, login);
//
//            ResultSet resultSet = statement.executeQuery();
//            System.out.println(resultSet);
//            List<GunStats> list = new ArrayList<>();
//
//            boolean hasRows = resultSet.next(); // перемещаем курсор на первую строку
//            System.out.println("ResultSet has rows: " + hasRows);
//
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString(1) + ", " + resultSet.getInt(2) + ", " + resultSet.getInt(3) + ", " + resultSet.getInt(4));
//                GunStats gunStats = new GunStats(
//                        resultSet.getString(1),
//                        resultSet.getInt(2),
//                        resultSet.getInt(3),
//                        resultSet.getInt(4)
//                );
//                list.add(gunStats);
//            }
//            System.out.println("Function: findGunStatsByLogin finished");
//            return list;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
