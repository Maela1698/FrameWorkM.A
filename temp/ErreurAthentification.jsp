<%-- 
    Document   : ErreurAthentification
    Created on : 6 Jul 2023, 13:14:37
    Author     : andri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String erreur = (String)request.getAttribute("Erreur authentification");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><% out.print(erreur);%></h1>
    </body>
</html>
