<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>First Web Application</title>
</head>
<body>

<h2>簡単足し算アプリ</h2>

<form action="/firstweb/form" method="POST">

    <input type="text" name="num1" value="${num1}">
    ＋
    <input type="text" name="num2" value="${num2}">
    <button type="submit">＝</button>
    ${result}
</form>

</body>
</html>
