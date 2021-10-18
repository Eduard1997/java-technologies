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

@WebServlet(name = "controller", value = "/")
public class Controller extends HttpServlet {
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;
    String query = null;
    String url = null;
    String username = null;
    String password = null;

    public void init() throws ServletException {

        url = "jdbc:mysql://localhost:3306/java_db?useSSL=false";
        username = "root";
        password = "ediwebmagnat";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            connection = DriverManager.getConnection(url, username , password);
        }
        catch (Exception e) {

            e.printStackTrace();
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        query = "select * from categories";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            out.println("<html><body><h2>The Select query has following results : </h2>");
            out.println("<hr></br><table cellspacing='0' cellpadding='5' border='1'>");
            out.println("<tr>");
            out.println("<td><b>First Name</b></td>");
            out.println("<td><b>Last Name</b></td>");
            out.println("<td><b>Email</b></td>");
            out.println("</tr>");

            while(resultSet.next()) {
                out.println("<tr>");
                out.println("<td>"+resultSet.getString(1) + "</td>");
                out.println("<td>"+resultSet.getString(2) + "</td>");
                out.println("<td>"+resultSet.getString(3) + "</td>");
                out.println("</tr>");

            }

            out.println("</table></br><hr></body></html>");
        } catch (Exception e) {
            log(e.getMessage());
        }
    }

   /* public void destroy() {
        try {
            resultSet.close();
            preparedStatement.close();
        }
        catch (SQLException e) {

            e.printStackTrace();
        }

    }*/
}
