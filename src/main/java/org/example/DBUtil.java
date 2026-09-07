package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/dbconnect";
        String user = "root";
        String password = ""; // put your MySQL password here if you set one
        return DriverManager.getConnection(url, user, password);
    }
}
