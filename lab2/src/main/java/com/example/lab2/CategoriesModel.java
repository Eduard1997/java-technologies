package com.example.lab2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriesModel {
    public String categoryName;
    public String key;
    public String value;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<String> getCategories() throws SQLException {
        Connection connection = Helper.getDbConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<String> categoriesList = new ArrayList();
        try {
            String query = "select distinct category from categories";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                categoriesList.add(resultSet.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoriesList;
    }
}
