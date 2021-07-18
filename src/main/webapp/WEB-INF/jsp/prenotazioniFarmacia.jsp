<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Prenotazioni</title>
</head>
<body>
    <h1>Prenotazioni</h1>
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
                                    <form:form action="/prenotazioniFarmacia/conferma" method="post" modelAttribute="pr">
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

    <form:form action="/prenotazioniFarmacia/ricerca" method="post" modelAttribute="filtro">
        Da :
        <input type="date" path="inizio">
        A:
        <input type="date" path="fine">
        <input type="submit" value="Cerca"/>
    </form:form>


    <table>
                    <tbody>
                        <c:forEach items="${prenotazioniOggi}" var="prenotazione">
                            <tr>
                                <td>${prenotazione.richiedente.nome} ${prenotazione.richiedente.cognome}</td>
                                <td>
                                <c:choose>
                                    <c:when test="${prenotazione.confermata == true}">
                                        Confermata
                                    </c:when>
                                    <c:otherwise>
                                        <form:form action="/prenotazioniFarmacia/conferma" method="get" modelAttribute="prenotazione">
                                            <input type="submit" value="Conferma"/>
                                        </form:form>
                                    </c:otherwise>
                                </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
        </table>

</body>
</html>