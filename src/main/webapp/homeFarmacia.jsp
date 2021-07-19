<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Benvenuto${nomeFarmacista}!</title>
      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/farmacia.css" rel="stylesheet">
      <%@ include file="parts/header.jsp" %>
</head>
<body>
    <h2>Benvenuto${nomeFarmacista}!</h2>
    <a href="prenotazioniFarmacia">Prenotazioni</a>
    <a href="farmaci">Farmaci</a>
    <a href="utenti">Utenti</a>
    <a href="verificaIdentita">Verifica Identità</a>
    <a href="/farmacia/logout">Logout</a>

</body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</html>