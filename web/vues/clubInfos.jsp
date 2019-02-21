<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>
<div class="row" style="margin-top:150px">
    <div class="col-sm-2"></div>
    <div class="col-sm-8"><h1>${nom}</h1></div>
    <div class="col-sm-2"></div>
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
                            <input type="submit" class="btn btn-primary" value="D&eacute;sinscription">
                        </form>
                    </td>
                </tr>
            </c:forEach>

            <form action="delete-clubs" method="post">

                <input type="hidden" name="clubId" value="${id}">
                <input type="submit" class="btn btn-primary" value="suppression club" alt="ton titre2" title="tous les membres du club vont etre retir&eacute;s du club avant suppression" >
            </form>

            </tbody>
        </table>
    </div>
    <div class="col-sm-2"></div>
</div>
<div class="row"style="margin-top:150px"></div>

<%@include file="../templates/footer.jsp"%>
