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
        System.out.println("==========From create.jsp 1");
        GenerallyTable table = (GenerallyTable) request.getAttribute("table");
    %>
    <div class="w3-container w3-grey">
        <h1>Create <%=table.getTableName()%></h1>
    </div>
    <form class="w3-container w3-light-grey">
        <%
            System.out.println("==========From create.jsp 2");
            String[] fields = table.getPrm();
            System.out.println("==========From create.jsp 3 + " + fields[3]);
            for (String entry:
                 fields) {
                System.out.println("==========From create.jsp 4 + " + entry);
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
                    if (entry.equals("sex")){

                    }
                out.print("<input class=\"w3-input\" ");
                out.print("name=\"" + entry + "\" ");
                out.print("type=\"" + type + "\"");
                out.println("</p>");
                System.out.println("==========From create.jsp 5 + " + entry);
            }
        %>
        <input type="submit" href="/itIndustry/create" class="w3-button w3-black" value="Submit">
    </form>
</body>
</html>
