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
        <form action="saveDept" method="post">
            Nom : <input type="text" name="nom">
            Num : <input type="text" name="num">
            <input type="checkbox" id="langage1" name="langue[]" value="C">
            <label for="langage1">C</label><br>

            <input type="checkbox" id="langage2" name="langue[]" value="Java">
            <label for="langage2">Java</label><br>

            <input type="checkbox" id="langage3" name="langue[]" value="Python">
            <label for="langage3">Python</label><br>

            <input type="checkbox" id="langage4" name="langue[]" value="JavaScript">
            <label for="langage4">JavaScript</label><br>

            <input type="checkbox" id="langage5" name="langue[]" value="Ruby">
            <label for="langage5">Ruby</label><br> 
            <input type="submit" value="envoyer"> 
        </form>
    </body>
</html>
