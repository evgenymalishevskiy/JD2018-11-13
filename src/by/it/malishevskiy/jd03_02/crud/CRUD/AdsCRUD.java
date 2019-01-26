package by.it.malishevskiy.jd03_02.crud.CRUD;

import by.it.berdnik.jd03_02.beans.Buyer;
import by.it.malishevskiy.jd03_02.crud.beans.Ads;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdsCRUD {

    boolean create(Buyer buyer) throws SQLException {
        String sql = String.format(
                "INSERT INTO `ads` (`animal`, `weight`,`color`, 'price', `description`, 'users_ID') " +
                        "VALUES ('%s', '%s', '%s', '%s', '%s', '%d')",
                buyer.getItem(), buyer.getSpecif(), buyer.getPrice(), buyer.getAddress(), buyer.getUsers_Id());
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    buyer.setId(generatedKeys.getLong(1));
                }
                return true;
            }
        }
        return false;
    }

    Ads read(long id) throws SQLException {
        String sql = String.format("SELECT `ID`, `animal`, `weight`,`color`, 'price', `description`, 'users_ID' " +
                "FROM `ads` WHERE id=%d", id);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String ID = resultSet.getString("ID");
                String animal = resultSet.getString("animal");
                double weight = resultSet.getLong("weight");
                String color = resultSet.getString("color");
                String price = resultSet.getString("price");
                String description = resultSet.getString("description");
                long users_ID = resultSet.getLong("users_ID");

                return new Ads(ID, animal, weight, color, price, description, users_ID);
            } else
                return null;
        }
    }

    boolean update(Buyer buyer) throws SQLException {
        String sql = String.format(
                "UPDATE `ads` SET " +
                        "`animal` = '%s', " +
                        "`weight` = '%s', `color` = '%s', `price` = '%s', " +
                        "`description` = '%s', `users_ID` = '%d' " +
                        "WHERE `buyers`.`id` = %d",
                buyer.getItem(), buyer.getSpecif(), buyer.getPrice(),
                buyer.getAddress(), buyer.getId());
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    boolean delete(Buyer buyer) throws SQLException {
        String sql = String.format(
                "DELETE FROM `buyers` WHERE `users`.`id` = %d",
                buyer.getId());
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }
}
