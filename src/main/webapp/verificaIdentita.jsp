<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta charset="UTF-8">
    <title>Verifica identità</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/farmacia.css" rel="stylesheet">
</head>

<body>
    <section class="header">
        <a href="/farmacia" class="title">
            <h1>Verifica Identità</h1>
        </a>
    </section>
    <div class="logout-button">
        <a href="/farmacia/logout"><button class="button">Logout</button></a>
    </div>

    <div class="ricercaUtente">

        <form action="/farmacia/verificaIdentita" class="form-cercaUtenti" method="get">
            <label>Cerca Utente: </label>
            <input class="form-control" type="text" name="email" />
            <button class="btn btn-lg btn-primary btn-block" type="submit">Cerca</button>
        </form>
    </div>

    <c:if test="${risultato == 'true'}">
        <div class="risultato">

            <form action="/farmacia/verificaIdentita" method="post">
                <input type="hidden" name="email" value="${utenteCercato.email}" />
                ${utenteCercato.cognome}&emsp;
                ${utenteCercato.nome}&emsp;
                ${utenteCercato.codiceFiscale}&emsp;
                <button class="btn btn-lg" type="submit">Verifica</button>
            </form>
    </c:if>
    <c:if test="${risultato == 'noResearchMatch'}">
        <h3>La ricerca non ha prodotto nessun risultato</h3>
    </c:if>
    <c:if test="${risultato == 'GoodEnd'}">
        <h3>L&#39;utente è stato verificato</h3>
    </c:if>
    <c:if test="${risultato == 'BadEnd'}">
        <h3>Si è presentato un errore</h3>
    </c:if>
    </div>
</body>

</html>