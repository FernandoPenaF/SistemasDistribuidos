<%-- 
    Document   : index
    Created on : 15-abr-2020, 17:30:18
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
        <h1>Ingreso al sistema</h1>
        
        <form action="LoginServlet">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Usuario</td>
                        <td><input type="text" name="usuario" value="" /></td>
                    </tr>
                    <tr>
                        <td>Contraseña</td>
                        <td><input type="password" name="contrasena" value="" /></td>
                    </tr>
                </tbody>
                <input type="submit" value="Ingresar" />
            </table>
        </form>
    </body>
</html>
