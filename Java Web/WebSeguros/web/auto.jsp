<%-- 
    Document   : auto
    Created on : 13-abr-2020, 18:03:44
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
        

        <h3>Datos del auto</h3>
        
        <form action="cotizacion.jsp" method="POST">
            <%
            String nombre, apellidos, genero, edad, estado;
            
            nombre = request.getParameter("nombre");
            apellidos = request.getParameter("apellidos");
            genero = request.getParameter("genero");
            edad = request.getParameter("edad");
            estado = request.getParameter("estado");
            
            edad = (edad != null) ? edad : "Desconocida";
            
            out.println("<p>Estimado " + nombre + " " + apellidos + "</p>");
            out.println("<p>Género: " + genero + "</p>");
            out.println("<p>Edad: " + edad + "</p>");
            out.println("<p>Estado: " + estado + "</p>");
            
            out.println("<input type='hidden' name='nombre' value='" + nombre + "'/>");
            out.println("<input type='hidden' name='apellidos' value='" + apellidos + "'/>");
            out.println("<input type='hidden' name='genero' value='" + genero + "'/>");
            out.println("<input type='hidden' name='edad' value='" + edad + "'/>");
            out.println("<input type='hidden' name='estado' value='" + estado + "'/>");
            %>
            
            <table border="1">
                <thead>
                    <tr>
                        <th>Campo</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Marca</td>
                        <td>
                            <select name="marca">
                                <option>Chevrolet</option>
                                <option>Audi</option>
                                <option>Suzuki</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Modelo</td>
                        <td><input type="text" name="modelo" value="" /></td>
                    </tr>
                    <tr>
                        <td>Placas</td>
                        <td><input type="text" name="placas" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="limpiar" name="Limpiar" /></td>
                        <td><input type="submit" value="enviar" name="Enviar" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
        
    </body>
</html>
