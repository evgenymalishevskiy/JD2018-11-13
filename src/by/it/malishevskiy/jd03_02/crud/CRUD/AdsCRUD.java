package by.it.malishevskiy.jd03_02.crud.CRUD;

import by.it.malishevskiy.jd03_02.crud.beans.Ads;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;


public class AdsCRUD {

    boolean create(Ads ads) throws SQLException {
        String sql = String.format(
                "INSERT INTO `ads` (`animal`, `weight`,`color`, 'price', `description`, 'users_ID') " +
                        "VALUES ('%s', '%s', '%s', '%s', '%s', '%d')",
        ads.getAnimal(),ads.getWeight(),ads.getColor(),ads.getPrice(),ads.getDescription(),ads.getUser_ID());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    ads.setID((int) generatedKeys.getLong(1));
                }
                return true;
            }
        }
        return false;
    }

    Ads read(long id) throws SQLException {
        String sql = String.format("SELECT `ID`, `animal`, `weight`,`color`, 'price', `description`, 'users_ID' " +
                "FROM `ads` WHERE id=%d", id);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String animal = resultSet.getString("animal");
                double weight = resultSet.getLong("weight");
                String color = resultSet.getString("color");
                int price = resultSet.getInt("price");
                String description = resultSet.getString("description");
                int users_ID = resultSet.getInt("users_ID");

                return new Ads(ID, animal, weight, color, price, description, users_ID);
            } else
                return null;
        }
    }

    public boolean update(Ads ads) throws SQLException {
        //локаль нужна,т.к. есть дробные числа. Их нужно указывать через точку
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `ads` SET " + "`Animal`=%d " +
                        ",`Weight`='%.3f'" + ",`Color`='%.3f'" +
                        ",`Price`=%d" + ",`Description`=%d" +
                        ",`Adress`='%s'" + ",`Users_ID`=%d " +
                        " WHERE `ad`.`ID` = %d",
                ads.getAnimal(), ads.getWeight(),
                ads.getColor(), ads.getPrice(),
                ads.getDescription(), ads.getAdress(),
                ads.getUser_ID(), ads.getID()
        );
        return false;
    }

    boolean delete(Ads ads) throws SQLException {
        String sql = String.format(
                "DELETE FROM `buyers` WHERE `users`.`id` = %d",
                ads.getID());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }
}
