<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Verifica identità</title>
</head>
<body>

    <h1> Verifica identità</h1>
    Cerca Utente:
     <form:form action="/verificaIdentita" method="post" modelAttribute="ricercaUtente">
        <form:input type="text" path="email"/>
        <input type="submit" value="Cerca"/>
     </form:form>

     <c:if test="${risultato == 'true'}">
        ${utenteCercato.nome} ${utenteCercato.Cognome}

        ${utenteCercato.codiceFiscale}

        <form:form action="/verificaIdentita" method="put" modelAttribute="utenteCercato">
                <input type="submit" value="Verifica"/>
        </form:form>
     </c:if>
     <c:if test="${risultato == 'noResearchMatch'}">
          La ricerca non ha prodotto nessun risultato
     </c:if>
     <c:if test="${risultato == 'GoodEnd'}">
        "L'utente è stato verificato"
     </c:if>
     <c:if test="${risultato == 'BadEnd'}">
          Si è presentato un errore
     </c:if>
</body>
</html>