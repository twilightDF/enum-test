<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServletPath() + path + "/";
%>
<html>
<head>
    <title>成功</title>
</head>
    <body>
         ${xiaoxi}<br>
         <a href="SearchAllServlet">查看所有用户</a>>
    </body>
</html>
