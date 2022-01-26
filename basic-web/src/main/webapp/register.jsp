<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="utf-8" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
    <form action="RegisterServlet" method="post" style="padding-top: -700px;">
        输入用户名:<input type="text" name="name"><br><br>
        输入密码:<input type="password" name="pwd"><br><br>
        选择性别:<input type="radio" name="sex" value="男"checked>男
                 <input type="radio" name="sex" value="女">女<br><br>
        选择家乡
        <select name="home">
            <option value="上海"></option>
            <option value="北京"></option>
            <option value="重庆"selected></option>
        </select><br>
        填写个人信息:<br>
        <textarea name="info" row="5" cols="30"></textarea><br>
        <input type="reset" value="重置"><input type="submit" value="注册">
    </form>>
</body>
</html>
