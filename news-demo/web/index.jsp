<%-- 
    Document   : index
    Created on : Oct 6, 2015, 8:01:44 PM
    Author     : Admin
--%>

<%@page import="com.test.cache.NewsCache"%>
<%@page import="com.test.entity.News"%>
<%@page import="java.util.List"%>
<%@page import="com.test.dao.NewsDao"%>
<%@page import="com.test.dao.UserDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <%
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UserDao userDao = new UserDao();
            if(userDao.login(username, password)){ out.println("Dang nhap thanh cong");
            }else out.println("Dang nhap that bai!");
        %>
        <form method="post">
            <input name="username" type="text" placeholder="Username"/>
            <input name="password" type="password" placeholder="Password"/>
            <input type="submit" value="Dang nhap"/>
            <input type="reset" value="reset"/>
        </form>
        <%
            if(userDao.login(username, password)){ 
                %>
                <table>
                    <tr>
                        <td>Ma bai viet</td>
                        <td>Tieu de bai viet</td>
                    </tr>
                    <% 
                        List<News> list = NewsCache.getList("GET_ALL");
                        for(News news : list){
                    %>
                    <tr>
                        <td><%= news.getId() %></td>
                        <td><%= news.getTitle() %></td>
                    </tr>
                    <%
                        }
                    %>
                </table>
                <%
            }
        %>
    </body>
</html>
