<%--
  Created by IntelliJ IDEA.
  User: devin
  Date: 2016/12/29
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<html>
<head>
    <title>Home</title>
</head>
<body>
    <a href="${s:mvcUrl('URICC#home').build()}">Click Me</a>
</body>
</html>
