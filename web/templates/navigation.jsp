<%--
  Created by IntelliJ IDEA.
  User: tenka
  Date: 08-02-19
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <nav class="navbar navbar-expand-sm navbar-dark bg-primary mb-3 fixed-top">
        <a href="#" class="navbar-brand">Home page</a>

        <ul class="navbar-nav mr-auto">

            <li class="nav-item">
                <a href="todo" class="nav-link"></a>
            </li>
        </ul>

        <ul class="navbar-nav">
            <li class="nav-item">
                <c:choose>
                    <c:when test="${nav == 0 or nav == null}">
                        <a href="/Login"class="nav-link active" >Login</a>
                    </c:when>
                    <c:otherwise>
                        <a href="/Logout"class="nav-link">${nom} Logout</a>
                    </c:otherwise>
                </c:choose>
            </li>
        </ul>
    </nav>
</body>
</html>
