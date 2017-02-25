<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<div style="width: 40%;margin-left: auto;margin-right: auto;">
    <form action="/login" method="post">
        用户名:<input type="text" name="userName" value="zhuzhenke"/><br/>
        密 码:<input type="password" name="password" value="123"/><br/>
        <input type="submit" value="登录"/>
    </form>
    <span style="color: red">${errorInfo}</span>
</div>
</body>
</html>