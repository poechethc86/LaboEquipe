
<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>
<div class="row" style="margin-top:150px">
    <div class="col-sm-2"></div>
    <div class="col-sm-8">
        <h1>Clubs</h1>
        <table class="table table-striped" style="text-align:center">
            <thead>
            <tr>
                <th>Clubs</th>
                <th>Sports</th>
                <th>Membres</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${clubs}" var="club">
                <tr>
                    <!-- <td>${club.nom}</td> <td>${club.sport}</td><td>${club.memberCount}</td> -->

                    <td><a href="infoclub?id=${club.pk_club}">${club.nom}</a></td> <td>${club.sport}</td><td>${club.memberCount}</td>
                    <td><form action="delete-club" method="post">

                        <input type="hidden" name="clubId" value="${club.pk_club}">
                        <input type="hidden" name="redirectLink" value="homepage">
                        <input type="submit" class="btn btn-primary" value="suppression club" alt="ton titre2" title="tous les membres du club vont etre retir&eacute;s du club avant suppression" >
                    </form></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="col-sm-2"></div>
</div>
<form action="add-club" method="post">
    <div class="row" style="margin-top:50px">
        <div class="col-sm-2"></div>
        <div class="col-sm-4">

            <div class="form-inline">
                <div class="form-group">
                    <label for="clubNames">Nom du club:  </label>
                    <input type="text" class="form-control" id="clubNames" name="clubName">

                </div>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="form-group">
                <select name="sportId" class="form-control" id="sel1">
                    <c:forEach items="${sports}" var="sport">

                        <option value="${sport.pk_sport}">${sport.nomSport}</option>


                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="col-sm-2"></div>
    </div>
    <div class="row">
        <div class="col-sm-5"></div>
        <div class="col-sm-2">
            <button type="submit" class="btn btn-primary">Ajouter le club</button>

        </div>
        <div class="col-sm-5"></div>
    </div>
</form>



<div class="row"style="margin-top:150px">
    <div class="col-sm-2"></div>
    <div class="col-sm-8">
        <h1>Sports</h1>
        <table class="table table-striped" style="text-align:center">
            <thead>
            <tr>
                <th>Sport</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sports}" var="sport">
                <tr>
                    <td><a href="infosport?id=${sport.pk_sport}">${sport.nomSport}</a></td>
                    <td><form action="delsport" method="post">

                        <input type="hidden" name="sportId" value="${sport.pk_sport}">
                        <input type="submit" class="btn btn-primary" value="suppression"  >
                    </form></td>
                    <!-- <td>${sport.nomSport}</td> -->
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="col-sm-2"></div>
</div>



<form action="add-sport" method="post">
    <div class="row"style="margin-top:50px">
        <div class="col-sm-2"></div>
        <div class="col-sm-4">

            <div class="form-inline">
                <div class="form-group">
                    <label for="sportname2"> Nom du sport:  </label>
                    <input type="text" class="form-control" name = "sportName" id = "sportname2"></in>

                </div>
            </div>
        </div>

        <div class="col-sm-4">

            <button type="submit" class="btn btn-primary" id="addspoort" name="add">ajouter le sport</button>
        </div>

        <div class="col-sm-2"></div>

    </div>
</form>




<div class="row" style="margin-top:150px">
    <div class="col-sm-2"></div>
    <div class="col-sm-8">
        <h1>Membres</h1>
        <table class="table table-striped" style="text-align:center">
            <thead>
            <tr>
                <th>Nom</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${membres}" var="membre">
                <tr>
                    <td><a href="profileMember?id=${membre.pk_membre}" >${membre.nom} ${membre.prenom}</a></td>
                    <!--<td>${membre.nom}</td>
                    <td>${membre.prenom}</td>
                    <td><a href="profileMember?id=${membre.pk_membre}">Profil</a></td>-->
                    <td><form action="delete-member" method="post">
                        <input type="hidden" name="memberId" value="${membre.pk_membre}">
                        <input type="hidden" name="usernameToDelete" value="${membre.user}">
                        <input type="submit" class="btn btn-primary" value="suppression membre" >
                    </form></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="col-sm-2"></div>
</div>
<form action="add-membre" method="post">
    <div class="row"style="margin-top:50px">

        <div class="col-sm-2"></div>
        <div class="col-sm-8">
            <div class="form-inline">
                <div class="form-group">
                    <label for="membName">Nom:  </label>
                    <input type="text" class="form-control" id="membName" name="nom" size="30">

                    <label for="membFirstName">Prenom:  </label>
                    <input type="text" class="form-control" id="membFirstName" name="prenom" size="30">

                    <label for="membpass">Pass:  </label>
                    <input type="password" class="form-control" id="membpass" name="pass" size="30">

                    <button type="submit" class="btn btn-primary">Ajouter nouveau membre</button>
                </div>
            </div>
        </div>

        <div class="col-sm-2"></div>


    </div>
</form>
<div class="row"style="margin-top:150px"></div>
<%@include file="../templates/footer.jsp"%>



