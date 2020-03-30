<%-- 
    Document   : index
    Created on : 30-mar-2020, 17:34:35
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
        <h1>Diferencia entre GET y POST</h1>
        
        <form name="FormaUno" action="final.jsp" method="POST">
            <input type="text" name="parametro_con_post" value="" />
            <input type="submit" value="Enviar" />
        </form>
        
        <form name="FormaDos" action="final.jsp" method="GET">
            <input type="text" name="parametro_con_get" value="" />
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
