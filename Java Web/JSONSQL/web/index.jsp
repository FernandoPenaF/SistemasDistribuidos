<%-- 
    Document   : index
    Created on : 06-may-2020, 18:29:03
    Author     : Fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function loadNewContent(id, target) {
                var ajaxRequest;
                
                if (window.XMLHttpRequest){
                    ajaxRequest=new XMLHttpRequest(); // IE7+, Firefox, Chrome, Opera, Safari
                } else {
                    ajaxRequest=new ActiveXObject("Microsoft.XMLHTTP"); // IE6, IE5
                }
                
                //Parseo de un arreglo de jsons
                ajaxRequest.onreadystatechange = function(){
                    if (ajaxRequest.readyState==4 && ajaxRequest.status==200){
                        var JSONObject = JSON.parse(ajaxRequest.responseText);
                        var txt = "<select name='clients'><option>Select a customer</option>";
                        for (var i = 0; i < JSONObject.customers.length; i++) {
                            txt += "<option>" + JSONObject.customers.[i].name + "</option>"
                        }
                        txt += "</select>";
                        document.getElementById(id).innerHTML = txt;
                    }
                }
                ajaxRequest.open("GET", target, true /*async*/);
                ajaxRequest.send();
            }
        </script>
    </head>
    <body>
        <div id="clients">Acá van los clientes</div>
        <input type="button" value="Ok" onclick="loadNewContent('clients', 'Buscador');"/>
    </body>
</html>
