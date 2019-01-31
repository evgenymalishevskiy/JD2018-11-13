package by.it.malishevskiy.jd03_02.crud.CRUD;

import by.it.malishevskiy.jd03_02.crud.beans.Roles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleCRUD {
    boolean create(Roles roles) throws SQLException {
        String sql = String.format("INSERT INTO `roles`(`role`)" +
                "VALUES ('%s')", roles.getRole());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    roles.setId((int) generatedKeys.getLong(1));
                }
                return true;
            }
        }
        return false;
    }

    Roles read(long id) throws SQLException {
        String sql = String.format("SELECT `ID`, `role`" +
                "FROM `roles` WHERE ID=%d", id);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String role = resultSet.getString("role");
                long ID = resultSet.getLong("id");
                return new Roles((int) id, role);
            } else
                return null;
        }
    }

    boolean update(Roles roles) throws SQLException {
        String sql = String.format(
                "UPDATE `roles` SET " +
                        "`role` = '%s'," +
                        "WHERE `role`.`id` = %d",
                roles.getRole(), roles.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    boolean delete(Roles roles) throws SQLException {
        String sql = String.format(
                "DELETE FROM `roles` WHERE `roles`.`id` = %d",
                roles.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }
}
