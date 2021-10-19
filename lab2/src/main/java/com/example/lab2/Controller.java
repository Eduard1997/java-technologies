package com.example.lab2;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

@WebServlet(name = "controller", value = "/")
public class Controller extends HttpServlet {
    Connection connection = null;
    ResultSet categoriesSet = null;
    PreparedStatement preparedStatement = null;
    String query = null;
    String url = null;
    String username = null;
    String password = null;

    public void init() throws ServletException {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            CategoriesModel categoriesModel = new CategoriesModel();
            List<String> categoriesData = categoriesModel.getCategories();
            request.setAttribute("categories", categoriesData);
            request.getRequestDispatcher("/input.jsp").forward(request, response);
        } catch (Exception e) {
            log(e.getMessage());
        }
    }

}
