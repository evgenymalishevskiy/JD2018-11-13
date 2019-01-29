package by.it.malishevskiy.jd03_03.dao;

import by.it.malishevskiy.jd03_03.beans.Roles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class RoleDao extends AbstractDAO<Roles>{

    public boolean create(Roles role) throws SQLException {
        String sql = String.format(
                "INSERT INTO `roles` (`role`) " +
                        "VALUES ('%s')",
                role.getRole()
        );
        int id = AbstractDAO.executeCreateAndGetId(sql);
        role.setId(id);
        return (id > 0);
    }

    public boolean delete(Roles role) throws SQLException {
        String sql = String.format(
                "DELETE FROM `roles` WHERE `roles`.`id` = %d",
                role.getId()
        );
        return AbstractDAO.executeUpdate(sql);
    }

    public boolean update(Roles role) throws SQLException {
        String sql = String.format(
                "UPDATE `roles` SET " +
                        "`role` = '%s'" +
                        "WHERE `roles`.`id` = %d",
                role.getRole(), role.getId()
        );
        return AbstractDAO.executeUpdate(sql);
    }

    public Roles read(int id) throws SQLException {
        String sqlFix = String.format("WHERE id=%d", id);
        List<Roles> all = getAll(sqlFix);
        return all.size() > 0 ? all.get(0) : null;
    }

    @Override
    public List<Roles> getAll(String sqlFix) throws SQLException {
        List<Roles> result=new ArrayList<>();
        String sql = String.format("SELECT * " +
                "FROM `roles` %s",sqlFix);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
             ResultSet resultSet= statement.executeQuery(sql);
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String strRole = resultSet.getString("role");
                Roles role = new Roles(id,strRole);
                result.add(role);
            }
            return result;
        }
    }
}

