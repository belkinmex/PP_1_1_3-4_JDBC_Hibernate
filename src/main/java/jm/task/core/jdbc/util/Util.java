package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String host = "localhost";
    private static final String dbName = "new_schema";
    private static final String login = "root";
    private static final String password = "root";
    private static final String connectionURL = "jdbc:mysql://" + host + ":3306/" + dbName;
    public static Connection getMySQLConnection() {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(connectionURL, login, password);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
// реализуйте настройку соеденения с БД
}
