<%@ page import="developerHomework5.model.GenerallyTable" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: valeriy
  Date: 11.06.18
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<%
    System.out.println("=====================Debug from delete.jsp");
        GenerallyTable table = (GenerallyTable)request.getAttribute("table");
    System.out.println("=====================Debug from delete.jsp" + table.getTableName());
        String tableName = table.getTableName();
        String[] fields = table.getPrm();
        Map<String, String> mapSS = table.getCortege();
%>

<div class="w3-container w3-gray">
    <h1><%=tableName%> Info: </h1>
    <form method="post" action="/itIndustry/delete">
        <table class="w3-table w3-striped w3-border">
            <tr>
                <%
                    for (String field : fields) {
                        out.print("<th>");
                        out.print(field);
                        out.println("</th>");
                    }
                %>
            </tr>
            <%
                    out.print("<tr>");
                for (String field : fields) {
                    out.print("<td>");
                    out.print(mapSS.get(field));
                    out.print("</td>");
                }
                    out.print("</tr>");
            %>
        </table>
        <input class="w3-button w3-green" type="submit" href="/itIndustry/delete" value="Delete"/>
        <a href="/itIndustry/" class="w3-button w3-blue">Home</a>
    </form>

</div>

</body>
</html>


