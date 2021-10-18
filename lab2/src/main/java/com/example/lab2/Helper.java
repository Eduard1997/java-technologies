package com.example.lab2;

import java.sql.Connection;
import java.sql.DriverManager;

public class Helper {
    public static Connection getDbConnection() {
        String url = "jdbc:mysql://localhost:3306/java_db?useSSL=false";
        String username = "root";
        String password = "ediwebmagnat";
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, username , password);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
