<%-- 
    Document   : index
    Created on : 30-mar-2020, 18:40:37
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
        <h1>Sistema de cotización de seguros de auto</h1>
        <h3>Datos personales</h3>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Campo</th>
                    <th>Valor</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="" /></td>
                </tr>
                <tr>
                    <td>Apellidos</td>
                    <td><input type="text" name="apellidos" value="" /></td>
                </tr>
                <tr>
                    <td>Género</td>
                    <td>
                        <input type="radio" name="genero" value="Hombre" checked="checked" />
                        <input type="radio" name="genero" value="Mujer" />
                    </td>
                </tr>
                <tr>
                    <td>Edad</td>
                    <td><input type="text" name="edad" value="" /></td>
                </tr>
                <tr>
                    <td>Estado</td>
                    <td>
                        <select name="estado">
                            <option>Ciudad de México</option>
                            <option>Estado de México</option>
                            <option>Jalisco</option>
                            <option>Morelos</option>
                            <option>Tabasco</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><input type="reset" value="limpiar" name="Limpiar" /></td>
                    <td><input type="submit" value="enviar" name="Enviar" /></td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
