<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Verifica identità</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/farmacia.css" rel="stylesheet">
</head>
<body>
    <section class="header">
        <h1>Verifica Identità</h1>
    </section>

    <div class="ricercaUtente">

     <form action="/farmacia/verificaIdentita" method="get">
        <label class="textVerificaIdentita">Cerca Utente: </label>
        <input class="button inputEmail" type="text" name="email"/>
        <button class="button bottoneRicercaUtente" type="submit">Cerca</button>
     </form>
    </div>

    <div class="risultato">
    <c:if test="${risultato == 'true'}">

        <form action="/farmacia/verificaIdentita" method="post">
            <input type="hidden" name="email"value="${utenteCercato.email}"/>
            ${utenteCercato.cognome}&emsp;
            ${utenteCercato.nome}&emsp;
            ${utenteCercato.codiceFiscale}&emsp;
            <button class="button bottoneRicercaUtente" type="submit" >Verifica</button>
        </form>
    </c:if>
    <c:if test="${risultato == 'noResearchMatch'}">
          <h3 class="textVerificaIdentita">La ricerca non ha prodotto nessun risultato</h3>
    </c:if>
     <c:if test="${risultato == 'GoodEnd'}">
        <h3 class="textVerificaIdentita">L&#39;utente è stato verificato</h3>
     </c:if>
     <c:if test="${risultato == 'BadEnd'}">
          <h3 class="textVerificaIdentita">Si è presentato un errore</h3>
     </c:if>
     </div>
</body>
</html>