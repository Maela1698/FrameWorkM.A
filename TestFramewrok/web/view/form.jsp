<%-- 
    Document   : form.jsp
    Created on : 25 avr. 2023, 08:29:11
    Author     : MAELA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String tonga = (String)request.getAttribute("testKey");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form</title>
    </head>
    <body>
        <p> <% out.println(tonga); %> </p>
        <form action="/saveDept" method="post">
            Nom : <input type="text" name="nom">
            Num : <input type="text" name="num">
            <input type="submit" value="envoyer"> 
        </form>
    </body>
</html>
