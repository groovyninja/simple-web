<%@ page import="java.util.Enumeration" %>
<%--
  Created by IntelliJ IDEA.
  User: rgordeev
  Date: 01.07.14
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
<div style="margin: 20px auto; width: 300px">
<table>

<%
    Enumeration<String> params = request.getParameterNames();
    while (params.hasMoreElements())
    {
        String param = params.nextElement();
        String value = request.getParameter(param);
%>
    <tr>
        <td><%= param %></td>
        <td><%= value %></td>
    </tr>
<%
    }
%>
</table>
    <form method="post">
        <table>
            <tr>
                <td>name:</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>lastname:</td>
                <td><input type="text" name="lastname"></td>
            </tr>
            <tr>
                <td>comment:</td>
                <td><textarea name="comment"></textarea></td>
            </tr>
            <tr>
                <td><input type="submit" value="submit"></td>
                <td><input type="reset" value="cancel"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
