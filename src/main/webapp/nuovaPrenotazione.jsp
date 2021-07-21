<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/clienti.css" rel="stylesheet">
</head>
<body onload="prenotazione_init(eval('${getInitialized}'))">
    <section class="header">
        <a href="/" class="title"><h1>Nuova Prenotazione</h1></a>
    </section>
    <div class="logout-button">
        <a href="logout"><button class="button">Logout</button></a>
    </div>
    <div id="nuovaPrenotazione">
        <form action="nuovaPrenotazione" method="post" modelAttribute="prenotazioneForm" onsubmit="return validate()">
            <label>Farmacia:</label><input type="text" id="farmacia" name="farmacia" list="list_farmacia" class="form-control" placeholder="Nome Farmacia" value="${getInitialized? farmacia : ''}">
            <datalist id="list_farmacia"></datalist>
            <label>Data:</label><input type="date" id="dataPrenotazione" name="dataPrenotazione" min="${dataMinimaPrenotazione}" class="form-control" placeholder="Data Prenotazione"
            autofocus="true"></input>
            <label>Farmaci:</label>
            <div id="nuovaPrenotazione-builder">
                <table id="farmaci-table">
                    <tbody id="farmaci-tbody">
                        <tr>
                            <th class="nomeFarmaco">Nome farmaco</th>
                            <th class="spacer" />
                            <th class="quantitaFarmaco">Quantit&agrave;</th>
                        </tr>
                        <tr id="1">
                            <td class="nomeFarmaco" id="nomeFarmaco_1"><input type="text" id="text_nomeFarmaco_1" name="text_nomeFarmaco_1" list="list_nomeFarmaco_1" value="${getInitialized? firstFarmaco : ''}" placeholder="Nome farmaco"></td>
                            <datalist id="list_nomeFarmaco_1"></datalist>
                            <td class="spacer" />
                            <td class="quantitaFarmaco" id="quantitaFarmaco_1"><input type="text" id="num_quantitaFarmaco_1" name="num_quantitaFarmaco_1" value="1" readonly></td>
                            <td class="increaseFarmacoButton"><button type="button" onClick="increaseFarmaco(1)">+</button></td>
                            <td class="decreaseFarmacoButton"><button type="button" onClick="decreaseFarmaco(1)">-</button></td>
                            <td class="eliminaFarmacoButton"><button type="button" onClick="eliminaFarmaco(1)">Elimina</button></td>
                        </tr>
                    </tbody>
                </table>
                <button type="button" onClick="addFarmaco()" style="margin: 1em">Aggiungi farmaco</button>
            </div>

            <input type="submit" onClick="return validate()" id="inviaPrenotazione" value="Conferma">
        </form>

        <p id="error" hidden>Errore: campi non validi</p>
        <c:if test="${error}"><p id="post-error">Errore: la prenotazione non è valida</p></c:if>
        <c:if test="${success}"><p id="post-success">Prenotazione conclusa con successo!</p></c:if>
    </div>
    
    <script src="${contextPath}/resources/js/clienti.js"></script>

</body>
</html>