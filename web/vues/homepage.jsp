
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
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${clubs}" var="club">
                <tr>
                    <td>${club.nom}</td> <td>${club.sport}</td><td>${club.memberCount}</td>
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
                    <label for="clubName">Nom du club:  </label>
                    <input type="text" class="form-control" id="clubName">

                </div>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="form-group">
                <select class="form-control" id="sel1">
                    <c:forEach items="${sports}" var="sport">
                        <option>${sport.nomSport}</option>
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
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sports}" var="sport">
                <tr>
                    <td>${sport.nomSport}</td>
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
                <th>Prenom</th>
                <th>Profil</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${membres}" var="membre">
                <tr>
                    <td>${membre.nom}</td>
                    <td>${membre.prenom}</td>
                    <td><a href="profileMember?id=${membre.pk_membre}">Profil</a></td>
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



