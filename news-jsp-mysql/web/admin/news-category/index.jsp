<%-- 
    Document   : index
    Created on : Oct 30, 2015, 8:33:37 PM
    Author     : Blue Screen
--%>

<%@page import="com.news.dao.NewsCategoryDao"%>
<%@page import="com.news.entity.NewsCategory"%>
<%@page import="com.news.entity.News"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>admin-new-category</title>
    </head>
    <body>
        <%
            String action = request.getParameter("action");
            String msg = "";
            String name = "";
            String urlFriendly = "";
            if("create".equals(action)){
                name = request.getParameter("name");
                urlFriendly = request.getParameter("urlFriendly");
                if(name == null || "".equals(name)) msg = "Vui lòng điền tên chuyên mục!";
                else if(urlFriendly == null || "".equals(urlFriendly)) msg = "Vui long dien url friendly!";
                else{
                    NewsCategory newsCategory = new NewsCategory(null, name, urlFriendly, null);
                    NewsCategoryDao categoryDao = new NewsCategoryDao();
                    if(categoryDao.create(newsCategory)) msg = "<span style='color: green'>Them chuyen muc thanh cong!</span>";
                    else msg = "Them chuyen muc that bai!";
                }
            }
        %>
        <h1>Quan ly News Category</h1>
        <h2 style="color: red"><%= msg %></h2>
        <form method="post">
            Ten chuyen muc: <input name="name" value="<%= name %>"/><br/><br/>
            Url friendly: <input name="urlFriendly" value="<%= urlFriendly %>"/>
            <input type="hidden" name="action" value="create"/>
            <input type="submit" value="Them moi"/>
        </form>
    </body>
</html>
