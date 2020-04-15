<%-- 
    Document   : welcome
    Created on : 15-abr-2020, 17:30:38
    Author     : Fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello <% out.println(request.getParameter("usuario")); %>!</h1>
    </body>
</html>
