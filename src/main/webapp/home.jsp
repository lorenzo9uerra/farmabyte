<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>

            <head>
                <meta charset="UTF-8">
                <title>FarmaByte</title>
                <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
                <link href="${contextPath}/resources/css/clienti.css" rel="stylesheet">
                <%@ include file="parts/header.jsp" %>
            </head>

            <body>
                <div class="logout-button">
                    <a class="${show ? 'show' : 'hide'}" href="logout"><button class="button">Logout</button></a>
                </div>
                <div class="menu">
                    <div class="${show ? 'show' : 'hide'}">
                        <a href="nuovaPrenotazione"><button class="button">Nuova Prenotazione</button></a>
                        <a href="prenotazioni"><button class="button">Le mie prenotazioni</button></a>
                    </div>
                </div>
                <div class="login-button">
                    <a class="${show ? 'hide' : 'show'}" href="login"><button class="button">Login</button></a>
                </div>
                <div class="container">
                    <form action="/" method="post" class="form-ricerca" onsubmit="return validateForm()">
                        <label>Farmaco:</label>&ensp;<input id="farmaco" list="list_farmaci" class="form-control"
                            type="text" name="farmaco" placeholder="Nome Farmaco"><br />
                        <datalist id="list_farmaci">
                        </datalist>
                        <label>Comune:</label>&ensp;<input id="comune" list="list_comuni" class="form-control"
                            type="text" name="comune" placeholder="Bologna"><br />
                        <datalist id="list_comuni">
                        </datalist>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Cerca</button>
                    </form>
                </div>
                <c:if test="${farmaciResult != null && empty farmaciResult}">
                    <p id="results" name="error">I farmaci selezionati
                        non sono disponibili</p>
                </c:if>
                <c:if test="${not empty farmaciResult}">
                    <div id="results">
                        <table>
                            <c:forEach var="entry" items="${farmaciResult}">
                                <tr>
                                    <td>
                                        <c:out value="${entry.key.nome}" />
                                    </td>
                                    <td>
                                        <c:out value="${entry.key.via}" />&emsp;
                                    </td>
                                    <td>
                                        <c:out
                                            value="${entry.value.y.quantita > 10 ? 'disponibili' : 'in esaurimento'}" />
                                    </td>
                                    <td><a
                                            href="/nuovaPrenotazione?farmacia=${entry.key.nome}&farmaco=${entry.value.x.nome}">prenota</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </c:if>
            </body>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
            <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
            <script src="${contextPath}/resources/js/index.js"></script>

            </html>