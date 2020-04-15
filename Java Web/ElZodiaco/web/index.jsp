<%-- 
    Document   : index
    Created on : 13-abr-2020, 18:48:43
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
        <h1>Zodiaco</h1>
        <%
            if(request.getParameter("error") != null){
                out.println("¡Hubo un error en la captura de los datos!");
            }
        %>
        <form action="signZodiac" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th>¿Cuál es tu fecha de nacimiento?</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Día</td>
                        <td><input type="text" name="dia" value="" /></td>
                    </tr>
                    <tr>
                        <td>Mes</td>
                        <td><input type="text" name="mes" value="" /></td>
                    </tr>
                    <tr>
                        <td>Año</td>
                        <td><input type="text" name="anio" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="reset" value="limpiar" name="Limpiar" /></td>
                        <td><input type="submit" value="enviar" name="Enviar" /></td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
