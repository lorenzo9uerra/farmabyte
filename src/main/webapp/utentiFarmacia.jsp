<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta charset="UTF-8">
    <title>Utenti</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/farmacia.css" rel="stylesheet">
</head>

<body>
    <section class="header">
        <a href="/farmacia" class="title"><h1>Utenti</h1></a>
    </section>
    <div class="logout-button">
        <a href="/farmacia/logout"><button class="button">Logout</button></a>
    </div>
    <div class="containerUtenti">
        <form class="form-cercaUtenti" action="/farmacia/utenti" method="get">
            <label>Cerca Utente: </label>
            <input class="form-control" type="text" name="email" />
            <button class="btn btn-lg btn-primary btn-block cercaUtenti" type="submit">Cerca</button>
        </form>

            <c:if test="${utenti.size() == 1}">
                    <button onclick="window.location.href='/farmacia/utenti';" class="btn btn-lg btn-primary btn-block torna" type="submit">Torna alla lista completa</button>

            </c:if>

            <c:choose>
                <c:when test="${utenti == null}">
                    La ricerca non ha prodotto nessun risultato
                </c:when>
                <c:otherwise>
                    <table class="utentiResults">
                        <tbody>
                            <c:forEach items="${utenti}" var="utente">
                                <tr>
                                    <td>${utente.nome} ${utente.cognome}</td>
                                    <td>${utente.codiceFiscale}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${utente.effrazioni == '1'}">
                                                Una mancata conferma
                                            </c:when>
                                            <c:otherwise>
                                                <c:if test="${utente.effrazioni > '1'}">
                                                    ${utente.effrazioni} mancate conferme
                                                </c:if>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${utente.bloccato == true}">
                                                <form action="/farmacia/utenti" method="post">
                                                    <input type="hidden" value="${utente.email}"
                                                        name="email" />
                                                    <c:if test="${error != null}">
                                                        ${error}
                                                    </c:if>
                                                    <input type="submit"
                                                        style="background-color: #b9dbb3; border-radius: 6px;"
                                                        value="Sblocca" />
                                                </form>
                                            </c:when>
                                            <c:otherwise>
                                                <form action="/farmacia/utenti" method="post">
                                                    <input type="hidden" value="${utente.email}"
                                                        name="email" />
                                                    <c:if test="${error != null}">
                                                        ${error}
                                                    </c:if>
                                                    <input type="submit"
                                                        style="background-color: #ff43439b; border-radius: 6px;"
                                                        value="Blocca" />
                                                </form>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
    </div>
</body>

</html>