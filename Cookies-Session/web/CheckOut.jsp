<%-- 
    Document   : CheckOut
    Created on : Dec 1, 2015, 11:47:10 AM
    Author     : RedDevil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Login Success Page</title>
</head>
<body>
    <%
    String userName = null;
    String sessionID = null;
    Cookie[] cookies = request.getCookies();
    if(cookies !=null){
    for(Cookie cookie : cookies){
        if(cookie.getName().equals("user")) userName = cookie.getValue();
    }
    }
    %>
    <h3>Hi <%=userName %>, do the checkout.</h3>
    <br>
    <form action="LogoutServlet" method="post">
    <input type="submit" value="Logout" >
    </form>
</body>
</html>
