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
    <div class="col-sm-8"><h1> ${nom} ${prenom}<br>(${username}) </h1> </div>
    <div class="col-sm-2"></div>
</div>
<div class="row" style="margin-top:100px">
    <div class="col-sm-2"></div>
    <div class="col-sm-5"><img src="vues/default.jpg" class="img-thumbnail" alt="image par défaut" width=50%></div>
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
        <form action="delete-member" method="post">
            <input type="hidden" name="memberId" value="${id}">
            <input type="hidden" name="usernameToDelete" value="${username}">
            <input type="submit" class="btn btn-primary" value="suppression membre" >
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

                <th>Désinscription</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${clubs}" var="club">
                <tr>
                    <td>${club.nom}</td>
                    <td>${club.sport}</td>

                    <td>
                        <form action="unsubscribe-club" method="post">
                            <input type="hidden" name="clubId" value="${club.pk_club}">
                            <input type="hidden" name="memberId" value="${id}">
                            <input type="hidden" name="redirectLink" value="profileMember?id=${id}">
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
<div class="row" style="margin-top:150px">
    <div class="col-sm-12">
        <h1>Inscription</h1>
    </div>
</div>
<c:if test="${!empty clubstosub}">
    <form action="subscribe-club" method="post">
    <div class="row" style="margin-top:50px">
        <div class="col-sm-5"></div>
        <div class="col-sm-3">
            <select name="clubId">
                <c:forEach items="${clubstosub}" var="club">
                    <option value="${club.pk_club}">${club.nom}</option>
                </c:forEach>
            </select>

            <input type="hidden" name="memberId" value="${id}">
            <input type="hidden" name="redirectLink" value="profileMember?id=${id}">
            <input type="submit" class="btn btn-primary" value="Inscription">
        </div>
        <div class="col-sm-4"></div>
    </div>
    </form>
</c:if>
<c:if test="${empty clubstosub}">
    <div class="row" style="margin-top:50px">
        <div class="col-sm-5"></div>
        <div class="col-sm-3">Aucune inscription disponible</div>
        <div class="col-sm-4"></div>
    </div>
</c:if>
<div class="row"style="margin-top:150px"></div>
<%@include file="../templates/footer.jsp"%>


