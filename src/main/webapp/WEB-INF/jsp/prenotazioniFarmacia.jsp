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
                            <td>${prenotazione.id}</td>
                            <td>${prenotazione.richiedente.nome} ${prenotazione.richiedente.cognome}</td>
                            <td>
                                <c:when test="${prenotazione.confermata}">
                                    Confermata
                                </c:when>
                                <c:otherwise>
                                    <form:form action="/prenotazioniFarmacia/conferma" method="get" modelAttribute="prenotazione">
                                        <input type="submit" value="Conferma"/>
                                    </form:form>
                                </c:otherwise>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
    </table>

</body>
</html>