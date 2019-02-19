
<div class="container">
    <nav class="navbar navbar-expand-sm navbar-dark bg-primary mb-3 fixed-top">
        <a href="homepage.jsp" class="navbar-brand">Home page</a>

        <ul class="navbar-nav mr-auto">

            <li class="nav-item">
                <a href="todo" class="nav-link"></a>
            </li>
        </ul>

        <ul class="navbar-nav">
            <li class="nav-item">
                <c:choose>
                    <c:when test="${nav == 0 or nav == null}">
                        <a href="Login"class="nav-link active" >Login</a>
                    </c:when>
                    <c:otherwise>
                        <a href="Logout"class="nav-link">${nom} Logout</a>
                    </c:otherwise>
                </c:choose>
            </li>
        </ul>
    </nav>
</div>
