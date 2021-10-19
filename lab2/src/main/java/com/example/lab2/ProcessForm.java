package com.example.lab2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "processForm", value = "/process-form")
public class ProcessForm extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String category = request.getParameter("category");
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        try {
            CategoriesModel.saveData(category, key, value);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<CategoriesModel> categoriesData = CategoriesModel.getAllCategoriesData();

        request.setAttribute("categoriesData", categoriesData);
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
