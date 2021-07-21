<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta charset="UTF-8">
    <title>FarmaByte</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/farmacia.css" rel="stylesheet">
</head>

<body>
    <%@ include file="parts/headerFarmacia.jsp" %>
        <a class="logout-button" href="/farmacia/logout"><button class="button">Logout</button></a>
        <h2 class="hello-title">Benvenuto${nomeFarmacista}!</h2>
        </div>
        <div class="menu">

            <a href="/farmacia/prenotazioni">
                <button class="button">Prenotazioni</button>
            </a>
            <a href="/farmacia/farmaci">
                <button class="button">Farmaci</button>
            </a>
            <a href="/farmacia/utenti">
                <button class="button" href="utenti">Utenti</button>
            </a>
            <a href="/farmacia/verificaIdentita">
                <button class="button">Verifica Identità</button>
            </a>
        </div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</html>