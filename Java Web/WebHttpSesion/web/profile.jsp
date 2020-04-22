<%-- 
    Document   : profile
    Created on : 22-abr-2020, 17:33:38
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
        <%
            HttpSession mySession = request.getSession();
            if(mySession.getAttribute("usuario") != null){
                out.println("<h2>" + mySession.getAttribute("usuario") + ", aquí están tus fotos</h2>");
                out.print("<a href='Signout'>Cerrar sesión</a>");
            } else {
                response.sendRedirect("index.html");
            }

        %>
    </body>
</html>
