<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
hello ADMIN!
<shiro:hasRole name="admin">
    <p>您已经是经过验证且有admin角色</p>
    主体信息：<shiro:principal/>
</shiro:hasRole>
<shiro:hasRole name="boss">
    <p>您已经是经过验证且有boss角色</p>
    主体信息：<shiro:principal/>
</shiro:hasRole>
</body>
</html>