<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <meta charset="UTF-8">
    <title>Prenotazioni</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/clienti.css" rel="stylesheet">
</head>
<body>
    <section class="header">
        <h1>Prenotazioni</h1>
    </section>
    <div class="logout-button">
        <a href="logout"><button class="button">Logout</button></a>
    </div>
    <table>
        <tbody>
            <tr>
                <th>ID</th>
                <th>Nome Farmacia</th>
                <th>Data Prenotazione</th>
                <th>Stato Prenotazione</th>
            </tr>
            <c:forEach items="${prenotazioni}" var="prenotazione">
                <tr>
                    <td>${prenotazione.id} </td>
                    <td>${prenotazione.farmacia.nome}</td>
                    <td><fmt:formatDate value="${prenotazione.data}" pattern="dd/MM/yyyy" /></td>
                    <td>${prenotazione.confermata ? 'Confermata' : 'Non Confermata'}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>