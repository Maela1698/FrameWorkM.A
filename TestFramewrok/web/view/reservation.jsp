<%-- 
    Document   : reservation
    Created on : 7 Jul 2023, 07:27:57
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
        <% if(idEmp != null) { %>
            <p><% out.println(idEmp);%></p>
        
        <% } else { %>
            <p><% out.println("mbola Tsy tonga ato le session idEmp");%></p>
        <% } %>
    </body>
</html>
