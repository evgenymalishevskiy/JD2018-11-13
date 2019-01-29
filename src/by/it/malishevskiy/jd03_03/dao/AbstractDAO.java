package by.it.malishevskiy.jd03_03.dao;

import by.it.malishevskiy.jd03_02.crud.beans.Ads;
import by.it.malishevskiy.jd03_03.beans.Roles;
import by.it.malishevskiy.jd03_03.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO<T> implements InterfaceDao<T>{


    public void reset(){
            ConnectionCreator.reset();
        }


        static boolean executeUpdate(String sql) throws SQLException {
            try (Connection connection = ConnectionCreator.getConnection();
                 Statement statement = connection.createStatement()) {
                return (1 == statement.executeUpdate(sql));
            }
        }

        static int executeCreateAndGetId(String sql) throws SQLException {
            try (Connection connection = ConnectionCreator.getConnection();
                 Statement statement = connection.createStatement()) {
                if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                    ResultSet generatedKeys = statement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    }
                }
            }
            return -1;
        }

    }
