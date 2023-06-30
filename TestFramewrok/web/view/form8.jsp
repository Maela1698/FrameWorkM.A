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
            <input type="checkbox" id="langage1" name="langage[]" value="C">
            <label for="langage1">C</label><br>

            <input type="checkbox" id="langage2" name="langage[]" value="Java">
            <label for="langage2">Java</label><br>

            <input type="checkbox" id="langage3" name="langage[]" value="Python">
            <label for="langage3">Python</label><br>

            <input type="checkbox" id="langage4" name="langage[]" value="JavaScript">
            <label for="langage4">JavaScript</label><br>

            <input type="checkbox" id="langage5" name="langage[]" value="Ruby">
            <label for="langage5">Ruby</label><br>
            <input type="submit" value="envoyer"> 
        </form>
    </body>
</html>
