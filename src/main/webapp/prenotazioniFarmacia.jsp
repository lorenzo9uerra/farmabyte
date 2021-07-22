<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta charset="UTF-8">
    <title>Prenotazioni</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/farmacia.css" rel="stylesheet">
</head>

<body>
    <section class="header">
        <a href="/farmacia" class="title">
            <h1>Prenotazioni</h1>
        </a>
    </section>
    <div class="logout-button">
        <a href="/farmacia/logout"><button class="button">Logout</button></a>
    </div>
    <div class="containerPrenotazioni">
        <p class="message">${message}</p>
        <div class="resultsPrenotazione">
            <c:if test="${empty prenotazioni}">
                Nessuna prenotazione oggi
            </c:if>
            <table>
                <tbody>
                    <c:forEach items="${prenotazioni}" var="prenotazione">
                        <tr>
                            <td>${prenotazione.id} </td>
                            <td>${prenotazione.richiedente.nome} ${prenotazione.richiedente.cognome}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${prenotazione.confermata == true}">
                                        <p class="stato" style="color: green;">Confermata</p>
                                    </c:when>
                                    <c:otherwise>
                                        <form action="/farmacia/prenotazioni" method="get">
                                            <input type="hidden" name="conferma"
                                                value="${prenotazione.id}" />
                                            <input style="background-color: #ff43439b; border-radius: 6px;"
                                                type="submit" class="stato" value="Conferma" />
                                        </form>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <c:if test="${error != null}">
                <p style="color: red;">${error}</p>
            </c:if>
            <c:if test="${success != null}">
                <p style="color: green;">${success}</p>
            </c:if>
        </div>

        <form action="/farmacia/prenotazioni" method="post" class="form-Prenotazioni">
            Da:
            <input type="date" class="form-control dataPrenotazione" name="inizio" /><br/>
            A:&ensp;
            <input type="date" class="form-control dataPrenotazione" name="fine" />
            <input type="submit" class="btn btn-lg btn-primary" value="Cerca" />
        </form>
    </div>
</body>

</html>