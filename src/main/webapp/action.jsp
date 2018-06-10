<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 08.06.18
  Time: 0:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Action</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
    <div class="w3-container w3-grey">
        <div class="w3-container w3-margin w3-blue">
            <h2>Make you choose</h2>
        </div>
        <div class="w3-container">
            <h2>Tables:</h2>
            <div class="w3-bar w3-border w3-light-grey">
                <a href="/itindustry/crud?command=create" class="w3-bar-item w3-button w3-hover-green">Create</a>
                <a href="/itindustry/crud?command=list" class="w3-bar-item w3-button w3-hover-red">List</a>
            </div>
        </div>
    </div>
</body>
</html>
