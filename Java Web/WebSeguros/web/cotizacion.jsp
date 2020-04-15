<%-- 
    Document   : cotizacion
    Created on : 13-abr-2020, 18:25:45
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
        <h1>Cotización del seguro</h1>
        
        <%
            out.println("<p>Estimado: " + request.getParameter("nombre") + " "
                    + request.getParameter("apellidos") + "</p>");
            
            out.println("<p>En función de los datos proporcionados </p>");
            
            out.println("<p>Género: " + request.getParameter("genero") + "</p>");
            out.println("<p>Edad: " + request.getParameter("edad") + "</p>");
            out.println("<p>Estado: " + request.getParameter("estado") + "</p>");
            out.println("<p>Marca: " + request.getParameter("marca") + "</p>");
            out.println("<p>Modelo: " + request.getParameter("modelo") + "</p>");
            out.println("<p>Placas: " + request.getParameter("placas") + "</p>");
            
            out.println("<h2>Cotización del seguro: $5000</h2>");
        %>
    </body>
</html>
