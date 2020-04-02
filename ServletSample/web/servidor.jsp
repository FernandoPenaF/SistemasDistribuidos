<%-- 
    Document   : servidor
    Created on : 01-abr-2020, 18:32:04
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
        <h1>Hello World!</h1>
        <%
            out.println("Me reenviaron info: " + request.getParameter("nombre"));
        %>
    </body>
</html>
