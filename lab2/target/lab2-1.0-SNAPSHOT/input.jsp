<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    input[type=text], select {
        width: 10%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type=submit] {
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type=submit]:hover {
        background-color: #45a049;
    }

    div {
        border-radius: 5px;
        background-color: #f2f2f2;
        padding: 20px;
    }
</style>
<head>
    <title>Input</title>
</head>
<body>
<form style="margin-left: 100px;">
    <label for="key">Key</label>
    <input type="text" id="key" name="key" placeholder="key">
    <br>

    <label for="value">Value</label>
    <input type="text" id="value" name="value" placeholder="value">
    <br>

    <label for="category">Country</label>
    <select id="category" name="category">

    </select>
    <br>

    <input type="submit" value="Submit">
</form>
</body>
</html>
