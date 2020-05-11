<%-- 
    Document   : index
    Created on : 11-may-2020, 18:55:09
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
        <h1>Hello World!</h1>
        
    <%-- start web service invocation --%><hr/>
    <%
    try {
	webserviceclient.MyWebService_Service service = new webserviceclient.MyWebService_Service();
	webserviceclient.MyWebService port = service.getMyWebServicePort();
	 // TODO initialize WS operation arguments here
	int a = 4;
	int b = 8;
	// TODO process result here
	int result = port.suma(a, b);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
