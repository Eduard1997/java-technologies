<%@ page import="java.util.List" %>
<%@ page import="com.example.lab2.CategoriesModel" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: developer
  Date: 20.10.2021
  Time: 00:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    table, tr, td, th {
        border: 1px solid black;
    }
</style>
<head>
    <title>Response</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Category</th>
        <th>Key</th>
        <th>Value</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<CategoriesModel> results = (List<CategoriesModel>) request.getAttribute("categoriesData");
        Iterator it = results.iterator();

        if(results!=null){
            while(it.hasNext()){
                CategoriesModel categoriesModel = (CategoriesModel) it.next();
                out.println("<tr>");
                out.println("<td>" + categoriesModel.getCategoryName() + "</td>");
                out.println("<td>" + categoriesModel.getKey() + "</td>");
                out.println("<td>" + categoriesModel.getValue() + "</td>");
                out.println("</tr>");
            }
        }
    %>
    </tbody>
</table>
</body>
</html>
