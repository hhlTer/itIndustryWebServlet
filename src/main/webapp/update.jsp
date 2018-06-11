<%@ page import="developerHomework5.model.GenerallyTable" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: valeriy
  Date: 10.06.18
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<%
    GenerallyTable table = (GenerallyTable) request.getAttribute("table");
    String tableName = table.getTableName();
%>
<div class="w3-container w3-grey">
    <h1>Create <%=tableName.substring(0, tableName.length()-1)%></h1>
</div>
<form class="w3-container w3-light-grey" method="post" action="/itIndustry/update">
    <%
        String[] fields = table.getPrm();
        Map<String, String> mapSS = table.getCortege();
        for (String entry:
                fields) {
            String type = "text";
            if (entry.equals("id")){
                continue;
            }
            if (entry.equals("sex")){
                type = "checkbox";
            }
            if (entry.equals("age")){
                type = "number";
            }
            out.print("<p><label>");
            out.print(entry);
            out.println("<label>");

            out.print("<input class=\"w3-input\" ");
            out.print("name=\"" + entry + "\" ");
            out.print("type=\"" + type + "\"");
            out.print("placeholder=\"" + mapSS.get(entry) + "\">");
            out.println("</p>");
        }
    %>
    <%System.out.println("=========================from update.jsp 1");%>
    <input type="submit" href="/itIndustry/update"
           class="w3-button w3-black" value="Submit">
    <%System.out.println("=========================from update.jsp 2");%>
</form>
</body>
</html>
