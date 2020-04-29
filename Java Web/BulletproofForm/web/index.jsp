<%-- 
    Document   : index
    Created on : 17/01/2014, 09:44:43 PM
    Author     : JGUTIERRGARC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:mso="urn:schemas-microsoft-com:office:office" xmlns:msdt="uuid:C2F41010-65B3-11d1-A29F-00AA00C14882">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>index</title>
    
<!--[if gte mso 9]><xml>
<mso:CustomDocumentProperties>
<mso:Categoría msdt:dt="string"></mso:Categoría>
</mso:CustomDocumentProperties>
</xml><![endif]-->
</head>
    <body>
    <h1>My first bulletproof form!</h1>
    
    <script>
        function validateForm(){
            x = document.forms["infoForm"]["nombre"].value;
            if (x==null || x=="") {
                alert("First name must be filled out");
                return false;
            }
            
            x = document.forms["infoForm"]["apellidos"].value;
            if (x==null || x=="") {
                alert("Last name must be filled out");
                return false;
            }
            
            x = document.forms["infoForm"]["email"].value;
            if (x==null || x=="") {
                alert("Email must be filled out");
                return false;
            }
            
            if(x.indexOf("@") && x.indexOf(".")){
                alert("E-mail must be valid");
                return false;
            }
            
            x = document.forms["infoForm"]["gender"];
            if (!x[0].checked && !x[1].checked ) {
                alert("Gender must be filled out");
                return false;
            }
            
            x = document.forms["infoForm"]["region"].value;
            if (x==null || x=="") {
                alert("Country must be selected");
                return false;
            }
            
            x = document.forms["infoForm"]["comments"].value;
            if (x == "") {
                alert("Comments must be filled out");
                return false;
            }
            
            return true;
        }
    </script>
    
    <form name ="infoForm" action="info.jsp" method="POST" onsubmit="return validateForm()">
   
        <table border="1">
        <thead>
            <tr>
                <th>Description</th>
                <th>Value</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>First name: </td>
                <td><input type="text" name="nombre" value=""/></td>
            </tr>

            <tr>
                <td>Last name: </td>
                <td><input type="text" name="apellidos" value=""/></td>
            </tr>
            
            <tr>
                <td>E-mail: </td>
                <td><input type="text" name="email" value="" /></td>
            </tr>            

            <tr>
                <td>Gender</td>
                <td><input type="radio" name="gender" value="male" />Male<input type="radio" name="gender" value="female" />Female</td>
            </tr>
            <tr>
                <td>Country region</td>
                <td><select name="region">
                        <option></option>
                        <option>Northern</option>
                        <option>Southern</option>
                        <option>Eastern</option>
                        <option>Western</option>
                    </select></td>
            </tr>
            <tr>
                <td>all the vaccines?</td>
                <td><input type="checkbox" name="vaccine" value="ON" /></td>
                
            </tr>
            <tr>
                <td>Additional comments </td>
                <td><textarea name="comments" rows="4" cols="20"></textarea></td>
            </tr>

            <tr>
                <td><input type="reset" value="Reset" name="reset"/></td>
                <td><input type="submit" value="Send" name="send" /></td>
            </tr>            

        </tbody>
    </table>
    
    </form>

   

    </body>
</html>
