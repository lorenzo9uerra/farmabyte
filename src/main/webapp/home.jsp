<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Benvenuto ${nomeUtente}!</title>
      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/clienti.css" rel="stylesheet">
</head>
<body>
    <section class="header">
        <h1>FarmaByte</h1>
    </section>

    <div class="${hide ? 'hide' : 'show'}"><h2 class="title">Benvenuto ${nomeUtente}!</h2></div>

    <div class="${hide ? 'hide' : 'show'}"><a href="logout">Logout</a></div>
    <div class="${hide ? 'hide' : 'show'}"><a href="nuovaPrenotazione">Nuova Prenotazione</a></div>
    <div class="${hide ? 'hide' : 'show'}"><a href="prenotazioni">Le mie Prenotazioni</a></div>
    <div class="${hide ? 'show' : 'hide'}"><a href="login">Login</a></div>

    <form>
        <div>
            <a class="">Per ricercare, inserisci la città di interesse:<a>
            <input type="text" name>
        </div>
        <div>
                <a class="">RicercaFarmaco</a>
                <input type="text" >
        </div>
    </form>

</body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${contextPath}/resources/js/ajax.js"></script>
</html>