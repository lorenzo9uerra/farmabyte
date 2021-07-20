<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Benvenuto ${farmacista.nome}!</title>
      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/farmacia.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>
    <section class="header">
        <h1>FarmaByte</h1>
    </section>

    <div class="high_left_menu"></div>
    <div class="high_right_menu">
       <button class="button" href="/farmacia/logout">Logout</button>
    </div>

    <div>
        <h2 class="central_title">Benvenuto ${farmacista.nome}!</h2>
    </div>
    <div class="menu">
        <button class="button" href="prenotazioniFarmacia">Prenotazioni</button>
        <button class="button" href="farmaci">Farmaci</button>
        <button class="button" href="utenti">Utenti</button>
        <button class="button" href="verificaIdentita">Verifica Identità</button>
    </div>
</body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</html>