package by.it.malishevskiy.jd03_02.crud.CRUD;

import by.it.berdnik.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {

    boolean create(User user) throws SQLException {
        String sql = String.format(
                "INSERT INTO `users` (`login`, `password`, `email`, `roles_ID`)" +
                        "VALUES ('%s', '%s', '%s', '%d')",
                user.getNickname(), user.getPassword(), user.getEmail(), user.getRoles_Id());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getLong(1));
                }
                return true;
            }
        }
        return false;
    }

    User read(long id) throws SQLException {
        String sql = String.format("SELECT `id`, `login`, `password`, `email`, `roles_ID` " +
                "FROM `users` WHERE id=%d", id);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String nickname = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                long roles_ID = resultSet.getLong("roles_ID");
                return new User(id, nickname, password, email, roles_ID);
            } else
                return null;
        }
    }

    boolean update(User user) throws SQLException {
        String sql = String.format(
                "UPDATE `users` SET " +
                        "`login` = '%s', `password` = '%s', " +
                        "`email` = '%s',  `roles_ID` = '%d' " +
                        "WHERE `users`.`id` = %d",
                user.getNickname(), user.getPassword(),
                user.getEmail(), user.getRoles_Id(),
                user.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    boolean delete(User user) throws SQLException {
        String sql = String.format(
                "DELETE FROM `users` WHERE `users`.`id` = %d",
                user.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }
}