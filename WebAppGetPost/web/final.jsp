<%-- 
    Document   : final
    Created on : 30-mar-2020, 17:35:49
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
        <h1>Resultado</h1>
        
        <%
            if(request.getParameter("parametro_con_post") != null){
                out.println("<p>Recibí un parámetro vía POST con valor = "
                        + request.getParameter("parametro_con_post") + "</p>");
            }
            
            if(request.getParameter("parametro_con_get") != null){
                out.println("<p>Recibí un parámetro vía GET con valor = "
                        + request.getParameter("parametro_con_get") + "</p>");
            }
        %>
        
    </body>
</html>
