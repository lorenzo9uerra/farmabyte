<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>

            <head>
                <meta charset="UTF-8">
                <title>Benvenuto${nomeUtente}!</title>
                <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
                <link href="${contextPath}/resources/css/clienti.css" rel="stylesheet">
                <%@ include file="parts/header.jsp" %>
            </head>

            <body>
                <div class="logout-button">
                    <a class="${hide ? 'hide' : 'show'}" href="logout"><button class="button">Logout</button></a>
                </div>
                <div class="menu">
                    <div class="${hide ? 'hide' : 'show'}">
                        <a href="nuovaPrenotazione"><button class="button">Nuova Prenotazione</button></a>
                        <a href="prenotazioni"><button class="button">Le mie prenotazioni</button></a>
                    </div>
                </div>
                <div class="login-button">
                    <a class="${hide ? 'show' : 'hide'}" href="login"><button class="button">Login</button></a>
                </div>
                <div class="container">
                    <form action="home" method="post" class="form-ricerca">
                        <label>Farmaco:</label>&ensp;<input id="farmaco" onkeyup="onFarmacoChange()" class="form-control" type="text" name="farmaco"
                            placeholder="Nome Farmaco"><br />
                        <label>Città:</label>&ensp;<input id="città" class="form-control" type="text" name="città"
                            placeholder="Bologna"><br />
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Cerca</button>
                    </form>
                </div>
                <div class="results">
                    <p class="${farmaciResult == null ? 'hide' : 'show'}">I farmaci sono disponibili nelle seguenti località:</p>
                    <c:forEach var="entry" items="${farmaciResult}">
                        <c:out value="${entry.key.nome}" />&emsp;
                        <c:out value="${entry.key.via}" />&emsp;
                        <c:out value="${entry.value.y.quantita > 10 ? 'disponibili' : 'in esaurimento'}" />&emsp;
                        <a
                            href="/nuovaprenotazione?farmacia=${entry.key.id}&farmaco=${entry.value.x.nome}">prenota</a></br>
                    </c:forEach>
                </div>
            </body>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
            <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
            <script src="${contextPath}/resources/js/ajax.js"></script>

            </html>