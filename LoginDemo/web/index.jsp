<%-- 
    Document   : login
    Created on : Oct 13, 2015, 8:00:35 PM
    Author     : Love JAV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        out.print("Check login<br>");
        if(username == null || password == null){
            out.print("Invalid paraters ");
        }
        
    %>
    <body>
        <h1>LoGin Form</h1>
        <form action="">
        <table>
            <tr>
                <td>Username: <td></td> <input name="username" type=""text/></td>
            </tr>
            <tr>
                <td>Password <td></td> <input name="password" type=""text/></td>
            </tr>
        </table>
        <input type="submit" value="login"/>
    </body>
   
</html>
