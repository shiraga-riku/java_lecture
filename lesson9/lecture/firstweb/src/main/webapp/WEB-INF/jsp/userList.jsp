<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>First Web Application</title>

    <style>
        table {
            border: 1px solid gray;
        }
        table th, table td {
            border: 1px solid gray;
        }
    </style>
</head>
<body>

<h2>ユーザ一覧</h2>

<table>
    <thead>
    <tr>
        <th>名前</th>
        <th>年齢</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.age}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
