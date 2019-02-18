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

<div class="row"style="margin-top:150px">
    <div class="col-sm-2"></div>
    <div class="col-sm-8"><h1> ${nom} ${prenom} </h1> </div>
    <div class="col-sm-2"></div>
</div>
<div class="row" style="margin-top:100px">
    <div class="col-sm-2"></div>
    <div class="col-sm-5"><img src="default.jpg" class="img-thumbnail" alt="image par défaut" width=50%></div>
    <div class="col-sm-3">
        <form action="update-member" method="post">
            Prenom:<br>
            <input type="text" name="firstname" value="${prenom}">
            <br>
            Nom:<br>
            <input type="text" name="lastname" value="${nom}">
            <br><br>
            <input type="hidden" name="id" value="${id}">
            <input type="submit" class="btn btn-primary" value="Éditer">
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
                <th>Désinscription</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${clubs}" var="club">
                <tr>
                    <td>${club.nom}</td>
                    <td>${club.sport}</td>
                    <td>${club.memberCount}</td>
                    <td>
                        <form action="unsubscribe-club" method="post">
                            <input type="hidden" name="clubId" value="${club.pk_club}">
                            <input type="hidden" name="memberId" value="${id}">
                            <input type="submit" class="btn btn-primary" value="Désinscription">
                        </form>
                    </td>
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
