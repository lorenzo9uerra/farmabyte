<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Prenotazioni</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/clienti.css" rel="stylesheet">
</head>
<body>
    <section class="header">
        <a href="/farmacia" class="title"><h1>Prenotazioni</h1></a>
    </section>
    <div class="logout-button">
        <a href="/farmacia/logout"><button class="button">Logout</button></a>
    </div>
    <h2>Oggi:</h2>
    <table>
                <tbody>
                    <c:forEach items="${prenotazioniOggi}" var="prenotazione">
                        <tr>
                            <td>${prenotazione.id} </td>
                            <td>${prenotazione.richiedente.nome} ${prenotazione.richiedente.cognome}</td>
                            <td>
                            <c:choose>
                                <c:when test="${prenotazione.confermata == true}">
                                    Confermata
                                </c:when>
                                <c:otherwise>
                                    <form:form action="/prenotazioniFarmacia" method="post" modelAttribute="pr">
                                        <form:input type="hidden" path="id" value="${prenotazione.id}"/>
                                        <input type="submit" value="Conferma"/>
                                    </form:form>
                                </c:otherwise>
                            </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
    </table>

    <form:form action="/prenotazioniFarmacia" method="put" modelAttribute="filtro">
        Da :
        <form:input type="date" path="inizio"/>
        A:
        <form:input type="date" path="fine"/>
        <input type="submit" value="Cerca"/>
    </form:form>
    <table>
        <tbody>
                        <c:forEach items="${ListaPrenotaioni}" var="prenotazione">
                            <tr>
                            <td>${prenotazione.id} </td>
                                <td>${prenotazione.richiedente.nome} ${prenotazione.richiedente.cognome}</td>
                                <td>${prenotazione.data} </td>
                                <td>
                                <c:choose>
                                    <c:when test="${prenotazione.confermata == true}">
                                        Confermata
                                    </c:when>
                                    <c:otherwise>
                                       Non Confermata
                                    </c:otherwise>
                                </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
    </table>

</body>
</html>