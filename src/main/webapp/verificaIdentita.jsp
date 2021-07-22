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
                        <button class="btn btn-lg btn-primary cercaUtenti" type="submit">Cerca</button>
                    </form>
                </div>

                <c:if test="${risultato == 'true'}">
                    <div class="risultatoVerifica">
                        <c:forEach items="${utentiCercati}" var="utenteCercato">
                            <form action="/farmacia/verificaIdentita" method="post">
                                <input type="hidden" name="email" value="${utenteCercato.email}" />
                                ${utenteCercato.cognome}&emsp;
                                ${utenteCercato.nome}&emsp;
                                ${utenteCercato.codiceFiscale}&emsp;
                                <button class="btn btn-lg" type="submit">Verifica</button>
                            </form>
                        </c:forEach>
                </c:if>
                <c:if test="${risultato != 'init' && risultato != 'true'}">
                    <div class="esitoVerifica">
                        <c:if test="${risultato == 'noResearchMatch'}">
                            <p class="nores">La ricerca non ha prodotto nessun risultato</p>
                        </c:if>
                        <c:if test="${risultato == 'GoodEnd'}">
                            <p class="success">L&#39;utente è stato verificato</p>
                        </c:if>
                        <c:if test="${risultato == 'verificato'}">
                            <p class="success">L'utente è già verificato</p>
                        </c:if>
                    </div>
                </c:if>
                </div>
            </body>

            </html>