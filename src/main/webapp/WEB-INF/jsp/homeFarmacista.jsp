<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Benvenuto</title>
</head>
<body>
    <h1>FarmaByte</h1>
    <h2>Benvenuto ${farmacista.nome}!</h2>
    <a href="prenotazioniFarmacia">Prenotazioni</a>
    <a href="farmaci">Farmaci</a>
    <a href="utenti">Utenti</a>
    <a href="verificaIdentita">Verifica Identità</a>

</body>
</html>