<%-- 
    Document   : welcome
    Created on : 22-abr-2020, 17:33:26
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
            if(request.getParameter("contrasena") != null){
                if(request.getParameter("contrasena").equals("123456")){
                    HttpSession mySession = request.getSession();
                    mySession.setAttribute("usuario", request.getParameter("usuario"));
                    mySession.setAttribute("contrasena", request.getParameter("contrasena"));
                    
                    out.println("<h1>Bienvenido, " + request.getParameter("usuario") + "</h1>");
                    out.println("<a href='profile.jsp'>Visita tu perfíl</a>");
                } else {
                    response.sendRedirect("index.html");
                }
            } else {
                response.sendRedirect("index.html");
            }

        %>
    </body>
</html>
