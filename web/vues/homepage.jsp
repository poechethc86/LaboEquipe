<%--
  Created by IntelliJ IDEA.
  User: tenka
  Date: 02-02-19
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>Page Test</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.2.1/cerulean/bootstrap.min.css" rel="stylesheet" integrity="sha384-62+JPIF7fVYAPS4itRiqKa7VU321chxfKZRtkSY0tGoTwcUItAFEH/HGTpvDH6e6" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>

    <style>

        th {
            background-color: #4CB1EA;
        }

        table {
            text-align:center;
        }

        h1 {
            text-align:center
        }


    </style>
</head>
<body>
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
                <c:forEach items="${clubs}" var="todo">
                    <tr>
                        <td>${club.nom}</td>
                    </tr>
                </c:forEach>
                <c:forEach items="${sports}" var="todo">
                    <tr>
                        <td>${sport.nomSport}</td>
                    </tr>
                </c:forEach>
                <c:forEach items="${membres}" var="todo">
                    <tr>
                        <td>${membre.nom}</td>
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
                    <c:forEach items="${clubs}" var="todo">
                            <option>${sport.nomSport}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="col-sm-2"></div>
    </div>
</form>
<div class="row">
    <div class="col-sm-5"></div>
    <div class="col-sm-2">
        <button type="submit" class="btn btn-primary">Ajouter le club</button>
    </div>
    <div class="col-sm-5"></div>
</div>
</div>

<div class="row"style="margin-top:150px">
    <div class="col-sm-2"></div>
    <div class="col-sm-8">
        <h1>Sports</h1>
        <table class="table table-striped" style="text-align:center">
            <thead>
            <tr>
                <th>Clubs</th>
                <th>Sport</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${clubs}" var="todo">
                <tr>
                    <td>${club.nom}</td>
                </tr>
            </c:forEach>
            <c:forEach items="${sports}" var="todo">
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
                    <label for="sportName">Nom du sport:  </label>
                    <input type="text" class="form-control" id="sportName">
                </div>
            </div>
    </div>

    <div class="col-sm-4">
        <button type="submit" class="btn btn-primary">Ajouter le sport</button>
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
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${membres}" var="todo">
                <tr>
                    <td>${membre.nom}</td>
                    <td>${membre.prenom}</td>
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
        <div class="col-sm-3">

                <div class="form-inline">
                    <div class="form-group">
                        <label for="membName">Nom:  </label>
                        <input type="text" class="form-control" id="membName">
                    </div>
                </div>
        </div>

        <div class="col-sm-3">
            <div class="form-inline">
                <div class="form-group">
                    <label for="membFirstName">Prenom:  </label>
                    <input type="text" class="form-control" id="membFirstName">
                </div>
            </div>

        </div>

        <div class="col-sm-2"><button type="submit" class="btn btn-primary">Ajouter nouveau membre</button></div>
        <div class="col-sm-2"></div>


    </div>
</form>
</br>
<%@include file="../templates/footer.jsp"%>
</body>
</html>


