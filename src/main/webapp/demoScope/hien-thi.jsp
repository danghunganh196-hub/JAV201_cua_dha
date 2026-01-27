<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/24/2026
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>demoScope</title>
</head>
<%
    pageContext.setAttribute("pageMessage","From page scope");
%>
<body>
Message tu request scope: ${requestMessage}<br>

Message tu session scope: ${sessionScope.sessionMessage}<br>

Message tu application scope: ${applicationScope.applicationMessage}<br>

Message tu page scope: ${pageMessage}
</body>
</html>
