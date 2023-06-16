<%-- 
    Document   : form8
    Created on : 16 juin 2023, 08:29:10
    Author     : M.Andriamahery
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String tonga = (String)request.getAttribute("cleSprint8");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> <% out.println(tonga);%></h1>
        <form action="saveDeptWithAttribut" method="post">
            Laharana : <input type="number" name="laharana">
            Anarana : <input type="text" name="anarana">
            <input type="submit" value="envoyer"> 
        </form>
    </body>
</html>
