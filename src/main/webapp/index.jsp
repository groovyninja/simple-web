<%--
  Created by IntelliJ IDEA.
  User: rgordeev
  Date: 01.07.14
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple JSP page</title>
</head>
<body>
    <h1><%= "hello!".toUpperCase() %></h1>
    <p>
<%
    for (int i = 0; i < 10; i++)
    {
        out.println(String.format("Hello %d<br/>", i));
    }
%>
    </p>
</body>
</html>
