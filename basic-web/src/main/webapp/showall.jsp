<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServletPath() + path + "/";
%>
<html>
    <head>
        <base href="<%=basePath%>">
        <title>所有用户页面</title>
    </head>
    <body>
        <h1>${xiaoxi}</h1>
        <table width="600" border="1" cellpadding="0">
            <tr>
                <th>ID</th>
                <th>姓名</th>
                <th>性别</th>
                <th>密码</th>
                <th>家乡</th>
                <th>备注</th>
                <th>操作</th>
            </tr>
            <c:forEach var="U" items="${userAll}"  >
                <form action="UpdateServlet" method="post">
                    <tr>
                        <td><input type="text" value="${U.id}" name="id" ></td>
                        <td><input type="text" value="${U.name}" name="name"></td>
                        <td><input type="text" value="${U.sex}" name="sex"></td>
                        <td><input type="text" value="${U.pwd}" name="pwd"></td>
                        <td><input type="text" value="${U.home}" name="home"></td>
                        <td><input type="text" value="${U.info}" name="info"></td>
                        <td><a href="DeleteServlet?id=${U.id}">删除</a>  <input type="submit" value="更新"/></td>
                    </tr>
                </form>
            </c:forEach>
        </table>
    </body>
</html>
