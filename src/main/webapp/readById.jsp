<%@ page import="developerHomework5.model.GenerallyTable" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: valeriy
  Date: 10.06.18
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
    <%
        GenerallyTable table = (GenerallyTable)request.getAttribute("table");
        String[] fields = table.getPrm();
        Map<String, String> mapSS = table.getCortege();
    %>
    <div class="w3-container w3-gray">
        <h1><%=table.getTableName()%> Info: </h1>
        <form method="post" action="/itIndustry/">
        <table class="w3-table w3-striped w3-border">
            <tr>
                <%
                    for (int i = 0; i < fields.length; i++) {
                        out.print("<th>");
                        out.print(fields[i]);
                        out.println("</th>");
                    }
                %>
            </tr>
            <tr>
                <%
                    for (int i = 0; i < fields.length; i++) {
                        out.print("<td>");
                        out.print(mapSS.get(fields[i]));
                        out.print("</td>");
                    }
                %>
            </tr>
        </table>
        <input class="w3-button w3-green" type="submit" href="/itIndustry/" value="Ok"/>
        </form>
    </div>

</body>
</html>
