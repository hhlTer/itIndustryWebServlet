<%@ page import="developerHomework5.model.GenerallyTable" %>
<%@ page import="developerHomework5.model.Developer" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: root
  Date: 09.06.18
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Create</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"></head>
<body>
    <%
        GenerallyTable table = (GenerallyTable) request.getAttribute("table");
    %>
    <div class="w3-container w3-grey">
        <h1>Create <%=table.getTableName().substring(0, table.getTableName().length() - 1)%></h1>
    </div>
    <form class="w3-container w3-light-grey">
        <%
            for (Map.Entry<String, String> entry:
                 table.getCortege().entrySet()) {
                String type = "text";
                if (entry.getKey().equals("id")){
                    continue;
                }
                if (entry.getKey().equals("sex")){
                    type = "checkbox";
                }
                out.print("<p><label>");
                out.print(entry.getKey());
                out.println("<label>");
                    if (entry.getKey().equals("sex")){

                    }
                out.print("<input class=\"w3-input\" ");
                out.print("name=\"" + entry.getKey() + "\" ");
                out.print("type=\"" + type + "\"");
                out.println("</p>");
            }
        %>
        <p>
            <label>First Name</label>
            <input class="w3-input" type="text" name="first_name"></p>
        <p>
            <label>Last Name</label>
            <input class="w3-input" type="checkbox"></p>
        <p>
            <label>Email</label>
            <input class="w3-input" type="number"></p>
        <input type="submit" href="/itIndustry/create" class="w3-button w3-black" value="Submit">
    </form>
</body>
</html>
