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

    public static void saveData(String category, String key, String value) throws SQLException {
        try {
            Connection connection = Helper.getDbConnection();
            PreparedStatement preparedStatement = null;
            String query = "INSERT INTO categories (category, category_key, category_value) values (?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, category);
            preparedStatement.setString(2, key);
            preparedStatement.setString(3, value);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<CategoriesModel> getAllCategoriesData() {
        Connection connection = Helper.getDbConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<CategoriesModel> categoriesList = new ArrayList();
        try {
            String query = "select * from categories ORDER BY category ASC";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                CategoriesModel categoriesModel = new CategoriesModel();
                categoriesModel.setCategoryName(resultSet.getString(2));
                categoriesModel.setKey(resultSet.getString(3));
                categoriesModel.setValue(resultSet.getString(4));
                categoriesList.add(categoriesModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoriesList;
    }
}
