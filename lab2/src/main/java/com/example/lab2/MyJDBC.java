package com.example.lab2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyJDBC {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_db", "root", "ediwebmagnat");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from categories");

            while(resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
