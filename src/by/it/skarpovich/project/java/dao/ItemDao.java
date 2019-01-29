package by.it.skarpovich.project.java.dao;

import by.it.skarpovich.project.java.beans.Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ItemDao implements InterfaceDao<Item> {

    public boolean create(Item item) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `items` (`title`, `floors`, `square`, `materials`, `price`) " +
                        "VALUES ('%s', '%d', '%d', '%s', '%d')",
                item.getTitle(), item.getFloors(), item.getSquare(), item.getMaterials(), item.getPrice()
        );
        int id = Dao.executeCreateAndGetId(sql);
        item.setId(id);
        return (id > 0);
    }

    public boolean delete(Item item) throws SQLException {
        String sql = String.format(
                "DELETE FROM `items` WHERE `items`.`id` = %d",
                item.getId()
        );
        return Dao.executeUpdate(sql);
    }

    public boolean update(Item item) throws SQLException {
        //Устанавливаем английскую локаль, чтобы корректно работало поле DOUBLE в DB (price, etc)
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `items` SET " +
                        "`title` = '%s', `floors` = '%d', " +
                        "`square` = '%d',  `materials` = '%s', " +
                        "`price` = '%d' " +
                        "WHERE `items`.`id` = %d",
                item.getTitle(), item.getFloors(), item.getSquare(), item.getMaterials(), item.getPrice(), item.getId()
        );
        //System.out.println(sql);
        return Dao.executeUpdate(sql);
    }

    public Item read(int id) throws SQLException {
        String sqlSuffix = String.format("WHERE id=%d", id);
        List<Item> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
    }

    @Override
    public List<Item> getAll(String sqlSuffix) throws SQLException {
        List<Item> result = new ArrayList<>();
        String sql = String.format("SELECT * " +
                "FROM `items` %s", sqlSuffix);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                int floors = resultSet.getInt("floors");
                int square = resultSet.getInt("square");
                String materials = resultSet.getString("materials");
                int price = resultSet.getInt("price");
                Item item = new Item(id, title, floors, square, materials, price);
                result.add(item);
            }
            return result;
        }
    }

}
