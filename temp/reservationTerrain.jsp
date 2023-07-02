<%-- 
    Document   : reservationTerrain
    Created on : 7 Jul 2023, 16:42:56
    Author     : andri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String idEmp = (String)request.getAttribute("testSprint12");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% if (idEmp != null) {%>
            <h1><% out.println(idEmp); %></h1>
        <% }else { %>
            <p><% out.println("Mbola tsy tonga ato le idEmp"); %></p>
        <% } %>
    </body>
</html>
