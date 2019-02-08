<%--
  Created by IntelliJ IDEA.
  User: tenka
  Date: 02-02-19
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../templates/header.jsp"%>

<div class="container contenu" style="margin-top:150px">
    <div class="row justify-content-center">
        <div class="col-4">
            <h3 class="p-3 bg-primary text-white text-center">Login Todo App</h3>
            <form action="login" method="post">
                <p class="bg-danger text-white">${errorMessage}</p>
                <div class="form-group">
                    <input class="form-control" type="text" name="nom"
                           placeholder="Nom">
                </div>
                <div class="form-group">
                    <input class="form-control" type="password" name="pass"
                           placeholder="Mot de passe">
                </div>
                <input class="btn btn-primary btn-block" type="submit" value="login">
            </form>
        </div>
    </div>

</div>
<%@include file="../templates/footer.jsp"%>

