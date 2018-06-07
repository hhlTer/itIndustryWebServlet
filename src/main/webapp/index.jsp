<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <meta charset="UTF-8"/>
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
                <a href="/itIndustry/action?table=developers" class="w3-bar-item w3-button w3-hover-green">Developers</a>
                <a href="/itIndustry/action?table=projects" class="w3-bar-item w3-button w3-hover-red">Projects</a>
            </div>
        </div>
    </div>
</body>
</html>
