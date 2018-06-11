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

        <form method="post" action="/itIndustry/">
        <%--<form class="w3-container w3-card-4">--%>
            <h2>Choose tables</h2>
            <p>
                <input class="w3-radio" type="radio" name="tableName" value="developers" checked>
                <label>Developers</label></p>
            <p>
                <input class="w3-radio" type="radio" name="tableName" value="projects">
                <label>Projects</label></p>
            <p>
                <input class="w3-radio" type="radio" name="tableName" value="companies">
                <label>Companies</label></p>
        <%--</form>--%>
        <%--<form class="w3-container w3-card-4">--%>
            <h2>Choose action</h2>
            <p>
                <input class="w3-radio" type="radio" name="crud" value="create" checked>
                <label>Create</label></p>
            <p>
                <input class="w3-radio" type="radio" name="crud" value="list">
                <label>List</label></p>
            <p>
                <input class="w3-radio" type="radio" name="crud" value="getById">
                <label>Get by id</label>
                <input class="w3-input w3-right" type="number" name="id"/>
            </p>
            <p>
            <input class="w3-radio" type="radio" name="crud" value="update">
                <label>Update</label>
                <input class="w3-input w3-right" type="number" name="idUpdate"/>
            </p>
        <%--</form>--%>
            <input type="submit" href="/itIndustry/" class="w3-button w3-black" value="Submit">
        </form>
    </div>
</body>
</html>
