<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/22
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言</title>
</head>
<body>
<h1>登录成功，可进行留言</h1>
<form method="post" action="/ChangeMessage">
    Username:<input type="text" name="username"><br>
    Password:<input type="password" name="password"><br>
    Pid:<input type="number" name="pid"><br>
    <input type="submit" value="提交留言">
</form>
<a href="/ScanMessage"><input type="button" value="查看留言板"></a>
<a href="/login.jsp"><input type="submit" value="返回登录界面"></a>
</body>
</html>
