<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>
<div class="row" style="margin-top:150px">
    <div class="col-sm-2"></div>
    <div class="col-sm-8"><h1>Sport:</h1></div>
    <div class="col-sm-2"></div>
</div>
<div class="row">
    <div class="col-sm-2"></div>
    <div class="col-sm-8">
        <form action="update-sport" method="post">
            Nom:<br>
            <input type="text" name="nom" value="${nom}">

            <input type="hidden" name="id" value="${id}">
            <input type="submit" class="btn btn-primary" value="Éditer">
        </form>


        <h1>${nom}</h1>
        <table class="table table-striped" style="text-align:center">
            <thead>
            <tr>
                <th>Clubs</th>
                <th>Nombre de membres</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${clubs}" var="club">
                <tr>
                    <td><a href="infoclub?id=${club.pk_club}">${club.nom}</a></td> <td>${club.memberCount}</td>

                    <td>
                        <form action="delete-club" method="post">
                            <input type="hidden" name="redirectLink" value="infosport?id=${id}">
                            <input type="hidden" name="clubId" value="${club.pk_club}">
                            <input type="submit" class="btn btn-primary" value="suppression club" alt="ton titre2" title="tous les membres du club vont etre retir&eacute;s du club avant suppression" >
                         </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="col-sm-2"></div>
</div>
<div class="row"style="margin-top:150px"></div>

<%@include file="../templates/footer.jsp"%>

