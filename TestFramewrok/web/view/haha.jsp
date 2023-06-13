<%-- 
    Document   : haha
    Created on : 30 mars 2023, 18:53:11
    Author     : MAELA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String data = (String)request.getAttribute("testKey");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! <% out.print(data);%></h1>
    </body>
</html>
