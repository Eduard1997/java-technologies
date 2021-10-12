<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lab 1</title>
</head>
<body>
<form action="process-form" method="post">
    <label for="key">Key</label>
    <input type="text" name="key" id="key">
    <br/>
    <br/>

    <label for="value">Value</label>
    <input type="number" name="value" id="value">
    <br/>
    <br/>

    <label for="mock">Mock</label>
    <select name="mock" id="mock">
        <option value="true" selected>True</option>
        <option value="false">False</option>
    </select>
    <br/>
    <br/>

    <label for="sync">Sync</label>
    <select name="sync" id="sync">
        <option value="true">True</option>
        <option value="false" selected>False</option>
    </select>
    <br/>
    <br/>

    <button type="submit">Submit</button>
</form>
</body>
</html>