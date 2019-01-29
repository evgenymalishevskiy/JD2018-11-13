package by.it.malishevskiy.jd03_03.dao;

import by.it.malishevskiy.jd03_03.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class UserDao implements InterfaceDao<User> {

    public boolean create(User user) throws SQLException {
        String sql = String.format(
                "INSERT INTO `users` (`Login`, `Password`, `email`, `Roles_ID') " +
                        "VALUES ('%s', '%s', '%s', '%d')",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getRoles_ID()
        );
        int id = AbstractDAO.executeCreateAndGetId(sql);
        user.setId(id);
        return (id > 0);
    }

    public boolean delete(User user) throws SQLException {
        String sql = String.format(
                "DELETE FROM `users` WHERE `users`.`id` = %d",
                user.getId()
        );
        return AbstractDAO.executeUpdate(sql);
    }

    public boolean update(User user) throws SQLException {
        String sql = String.format(
                "UPDATE `users` SET " +
                        "`Login` = '%s', `Password` = '%s', " +
                        "`Email` = '%s'" +
                        "WHERE `users`.`id` = %d",
                user.getLogin(), user.getPassword(),
                user.getEmail(), user.getId()

        );
        return AbstractDAO.executeUpdate(sql);
    }

    public User read(int id) throws SQLException {
        String sqlSuffix = String.format("WHERE id=%d", id);
        List<User> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
    }

    @Override
    public List<User> getAll(String sqlSuffix) throws SQLException {
        List<User> result=new ArrayList<>();
        String sql=String.format("SELECT `id`, `Login`, `Password`, `Email`, `Roles_id` " +
                "FROM `users` %s",sqlSuffix);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){

                int id = resultSet.getInt("id");
                String login=resultSet.getString("Login");
                String password=resultSet.getString("Password");
                String email=resultSet.getString("Email");
                int roles_id=resultSet.getInt("Roles_id");

                User user = new User(id,login,password,email,roles_id);
                result.add(user);
            }
            return result;
        }
    }
}