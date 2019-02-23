
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>
<div class="row" style="margin-top:150px">
    <div class="col-sm-2"></div>
    <div class="col-sm-8"><h1>${nom}</h1></div>
    <div class="col-sm-2"></div>
</div>
<div class="row">
    <div class="col-sm-2"></div>
    <div class="col-sm-5"></div>
    <div class="col-sm-3">
        <form action="update-club" method="post">
            Nom:<br>
            <input type="text" name="nom" value="${nom}">
            <br>
            <select name="sportId">
                <c:forEach items="${sports}" var="sport">
                    <option value="${sport.pk_sport}" <c:if test="${sport.pk_sport == sportId}" >selected</c:if> >${sport.nomSport}</option>
                </c:forEach>
            </select>
            <br><br>
            <input type="hidden" name="id" value="${id}">
            <input type="submit" class="btn btn-primary" value="Éditer">
        </form>
    </div>
</div>
<div class="row">
    <div class="col-sm-2"></div>
    <div class="col-sm-8">
        <!--<h1>Membres</h1>-->
        <table class="table table-striped" style="text-align:center">
            <thead>
            <tr>
                <th>Membres</th>

                <th>D&eacute;sinscription</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${membres}" var="membre">
                <tr>

                    <td><a href="profileMember?id=${membre.pk_membre}" >${membre.nom} ${membre.prenom}</a></td>
                    <td>
                        <form action="unsubscribe-membre" method="post">
                            <input type="hidden" name="clubId" value="${id}">
                            <input type="hidden" name="memberId" value="${membre.pk_membre}">
                            <input type="hidden" name="redirectLink" value="infoclub?id=${id}">
                            <input type="submit" class="btn btn-primary" value="D&eacute;sinscription">
                        </form>
                    </td>
                </tr>
            </c:forEach>

            <form action="delete-club" method="post">

                <input type="hidden" name="clubId" value="${id}">
                <input type="hidden" name="redirectLink" value="homepage">
                <input type="submit" class="btn btn-primary" value="suppression club" alt="ton titre2" title="tous les membres du club vont etre retir&eacute;s du club avant suppression" >
            </form>

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
<c:if test="${!empty memberstosub}">
    <form action="subscribe-club" method="post">
        <div class="row" style="margin-top:50px">
            <div class="col-sm-5"></div>
            <div class="col-sm-3">
                <select name="memberId">
                    <c:forEach items="${memberstosub}" var="membre">
                        <option value="${membre.pk_membre}">${membre.nom} ${membre.prenom}</option>
                    </c:forEach>
                </select>

                <input type="hidden" name="clubId" value="${id}">
                <input type="hidden" name="redirectLink" value="infoclub?id=${id}">
                <input type="submit" class="btn btn-primary" value="Inscription">
            </div>
            <div class="col-sm-4"></div>
        </div>
    </form>
</c:if>
<c:if test="${empty memberstosub}">
    <div class="row" style="margin-top:50px">
        <div class="col-sm-5"></div>
        <div class="col-sm-3">Aucune inscription disponible</div>
        <div class="col-sm-4"></div>
    </div>
</c:if>
<div class="row"style="margin-top:150px"></div>

<%@include file="../templates/footer.jsp"%>
