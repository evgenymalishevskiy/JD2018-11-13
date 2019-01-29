package by.it.malishevskiy.jd03_03.dao;

import by.it.malishevskiy.jd03_03.beans.Ads;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AdsDao extends AbstractDAO<Ads> {
    @Override
    public Ads read(int id) {
        List<Ads> roles = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Ads ads) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "insert INTO ads (Animal, Weight (kg), Color,Price ($), Description, Address, users_ID)" +
                        "\n values('%s', '%d', '%s', '%d', '%s', '%s', '%d');",
                ads.getAnimal(), ads.getWeight(),
                ads.getColor(), ads.getPrice(),
                ads.getDescription(), ads.getAdress(),
                ads.getUser_ID()
        );
        ads.setID(executeCreateAndGetId(sql));
        return (ads.getID() > 0);
    }

    @Override
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

        return (executeUpdate(sql));
    }

    @Override
    public boolean delete(Ads ads) throws SQLException {
        String sql = String.format(
                "DELETE FROM `ads` WHERE `ad`.`ID`=%d;", ads.getID()
        );
        return executeUpdate(sql);
    }

    @Override
    public List<Ads> getAll(String WHERE) {
        List<Ads> ads = new ArrayList<>();
        String sql = "SELECT * FROM ads " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Ads ads1 = new Ads();
                ads1.setID(rs.getInt("ID"));
                ads1.setAnimal(rs.getString("Animal"));
                ads1.setWeight(rs.getDouble("Weight"));
                ads1.setColor(rs.getString("Color"));
                ads1.setPrice(rs.getInt("price"));
                ads1.setDescription(rs.getString("Description"));
                ads1.setAdress(rs.getString("Floors"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ads;
    }
}
