<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Utenti</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/clienti.css" rel="stylesheet">
</head>
<body>
    <section class="header">
        <h1>Utenti</h1>
    </section>
    Cerca Utente:
    <form:form action="/utenti" method="put" modelAttribute="cr">
        <form:input type="text" path="email"/>
        <input type="submit" value="Cerca"/>
    </form:form>

    <form:form action="/utenti" method="get" modelAttribute="cr">
        <input type="submit" value="Annulla Ricerca"/>
    </form:form>

    <c:choose>
    <c:when test="${risultato == 'noResearchMatch'}">
        La ricerca non ha prodotto nessun risultato
    </c:when>
    <c:otherwise>
        <table>
            <tbody>
                <c:forEach items="${utenti}" var="utente">
                    <tr>
                        <td>${utente.nome} ${utente.cognome}</td>
                        <td>${utente.codiceFiscale}</td>
                        <td>
                            <c:choose>
                            <c:when test="${utente.effrazioni == '1'}">
                                ${utente.effrazioni} mancata conferma
                            </c:when>
                            <c:otherwise>
                                <c:if test="${utente.effrazioni == '1'}">
                                    ${utente.effrazioni} mancate conferme
                                </c:if>
                            </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:choose>
                            <c:when test="${utente.bloccato == 'true'}">
                                <form:form action="/utenti" method="post" modelAttribute="cr">
                                    <input type="submit" value="Sblocca"/>
                                </form:form>
                            </c:when>
                            <c:otherwise>
                                <form:form action="/utenti" method="post" modelAttribute="cr">
                                    <input type="submit" value="Blocca"/>
                                </form:form>
                            </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
    </c:choose>
</body>
</html>