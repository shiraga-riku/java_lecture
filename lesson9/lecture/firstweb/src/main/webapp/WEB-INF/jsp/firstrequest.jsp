<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First Web Application</title>
</head>
<body>

あなたの名前は<%= request.getParameter("name") %>です。
<br/>
あなたの体重は<%= request.getParameter("weight") %>です。

</body>
</html>
