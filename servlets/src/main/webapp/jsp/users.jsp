<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>FROM JSP USERS</h1>
<div>
    <table>
        <tr>
            <th>ID</th>
            <th>FIRST NAME</th>
            <th>LAST NAME</th>
            <th>AGE</th>
        </tr>
        <c:forEach items="${usersForJsp}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.age}</td>
            </tr>
        </c:forEach>

<%--        <% List<User> userList = (java.util.List<User>) request.getAttribute("usersForJsp");%>--%>
    </table>
</div>
</body>
</html>
