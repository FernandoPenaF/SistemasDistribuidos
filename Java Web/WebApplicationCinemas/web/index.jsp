<%-- 
    Document   : index
    Created on : 15-abr-2020, 18:42:39
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
        <h1>Bienvenido a CineMAS!</h1>
        <p>Permitenos recomendarte una película</p>
        
        <form action="GetSuggestion" method="POST">
            <table border="0 ">
                <tbody>
                    <tr>
                        <td>Zona</td>
                        <td><select name="zona">
                                <option>Norte</option>
                                <option>Sur</option>
                                <option>Este</option>
                                <option>Oeste</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td>Tipo de película</td>
                        <td><select name="tipo">
                                <option>Comedia</option>
                                <option>Terror</option>
                                <option>Accion</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td><input type="reset" value="Limpiar" /></td>
                        <td><input type="submit" value="Ver recomendación" /></td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
