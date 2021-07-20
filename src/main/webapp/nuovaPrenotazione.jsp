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
        <h1>Nuova Prenotazione</h1>
    </section>
    <div id="nuovaPrenotazione">
        <form action="nuovaPrenotazione" method="post">
            <label>Farmacia:</label><input type="text" id="farmacia" name="farmacia" class="form-control" placeholder="Nome Farmacia" value="${getInitialized? farmacia : ''}">
            <label>Data:</label><input type="date" min="${dataMinimaPrenotazione}" class="form-control" placeholder="Data Prenotazione"
            autofocus="true"></input>
            <label>Farmaci:</label>
            <div id="nuovaPrenotazione-builder">
                <table id="farmaci-table">
                    <tr>
                        <th class="nomeFarmaco">Nome Farmaco</th>
                        <th class="spacer" />
                        <th class="quantitaFarmaco">Quantit&agrave;</th>
                    </tr>
                    <tr id="1">
                        <td class="nomeFarmaco" id="nomeFarmaco_1">${getInitialized? firstFarmaco : 'Farmaco1'}</td>
                        <td class="spacer" />
                        <td class="quantitaFarmaco" id="quantitaFarmaco_1">1</td>
                        <td class="increaseFarmacoButton"><button type="button" onClick="increaseFarmaco(1)">+</button></td>
                        <td class="decreaseFarmacoButton"><button type="button" onClick="decreaseFarmaco(1)">-</button></td>
                        <td class="eliminaFarmacoButton"><button type="button" onClick="eliminaFarmaco(1)">Elimina</button></td>
                    </tr>
                </table>
                <button type="button" onClick="addFarmaco()" style="margin: 1em">Aggiungi farmaco</button>
            </div>

            <input type="submit" id="inviaPrenotazione" value="Conferma">
        </form>
    </div>
    
    <script src="${contextPath}/resources/js/clienti.js"></script>

</body>
</html>