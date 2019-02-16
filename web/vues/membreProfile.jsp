<%--
  Created by IntelliJ IDEA.
  User: tenka
  Date: 02-02-19
  Time: 09:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>
<nav class="navbar navbar-expand-sm navbar-dark bg-primary mb-3 fixed-top">
    <a href="#" class="navbar-brand">Home page</a>

    <ul class="navbar-nav mr-auto">

        <li class="nav-item">
            <a href="todo" class="nav-link"></a>
        </li>
    </ul>

    <ul class="navbar-nav">
        <li class="nav-item">
            <a href="Login" class="nav-link active" >Login</a>
        </li>
    </ul>
</nav>

<div class="row"style="margin-top:150px">
    <div class="col-sm-2"></div>
    <div class="col-sm-8"><h1> ${nom} ${prenom} </h1> </div>
    <div class="col-sm-2"></div>
</div>
<div class="row" style="margin-top:100px">
    <div class="col-sm-2"></div>
    <div class="col-sm-5"><img src="default.jpg" class="img-thumbnail" alt="image par défaut" width=50%></div>
    <div class="col-sm-3">
        <form action="/action_page.php">
            Prenom:<br>
            <input type="text" name="firstname" value="Prenom">
            <br>
            Nom:<br>
            <input type="text" name="lastname" value="Nom">
            <br><br>
            <input type="submit" class="btn btn-primary" value="Submit">
        </form>
    </div>
    <div class="col-sm-2"></div>
</div>
<div class="row"style="margin-top:150px">
    <div class="col-sm-2"></div>
    <div class="col-sm-8">
        <h1>Clubs</h1>
        <table class="table table-striped" style="text-align:center">
            <thead>
            <tr>
                <th>Clubs</th>
                <th>Sports</th>
                <th>Membres</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${clubs}" var="club">
                <tr>
                    <td>${club.nom}</td>
                    <td>${club.sport}</td>
                    <td>${club.memberCount}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="col-sm-2"></div>
</div>
<%@include file="../templates/footer.jsp"%>
</body>
</html>
