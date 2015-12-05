<%-- 
    Document   : LoginSuccess
    Created on : Dec 1, 2015, 11:45:38 AM
    Author     : RedDevil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head
     <title>Login Success Page</title>
    </head>
    <body>
        <%
        //allow access only if session exists
        String user = (String) session.getAttribute("user");
        String userName = null;
        String sessionID = null;
        Cookie[] cookies = request.getCookies();
        if(cookies !=null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("user")) userName = cookie.getValue();
            if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
        }
        }
        %>
        <h3>Hi <%=userName %>, Login successful. Your Session ID=<%=sessionID %></h3>
        <br>
        User=<%=user %>
        <br>
        <a href="CheckoutPage.jsp">Checkout Page</a>
        <form action="LogoutServlet" method="post">
        <input type="submit" value="Logout" >
    </form>
</body>
</html>
