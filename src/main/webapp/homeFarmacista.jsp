<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Benvenuto</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/clienti.css" rel="stylesheet">
</head>
<body>
    <section class="header">
        <h1>Farmabyte</h1>
    </section>
    <h2>Benvenuto ${farmacista.nome}!</h2>
    <a href="prenotazioniFarmacia">Prenotazioni</a>
    <a href="farmaci">Farmaci</a>
    <a href="utenti">Utenti</a>
    <a href="verificaIdentita">Verifica Identità</a>

</body>
</html>