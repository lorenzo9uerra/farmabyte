<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/clienti.css" rel="stylesheet">
</head>
<body>
    <section class="header">
        <h1>Nuova Prenotazione</h1>
    </section>
    <div id="nuovaPrenotazione">
        <form action="nuovaPrenotazione" method="post">
            <label>Farmacia:</label><input type="text" id="farmacia" name="farmacia" class="form-control" placeholder="Nome Farmacia">
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
                    <tr>
                        <td class="nomeFarmaco">Farmaco1</td>
                        <td class="spacer" />
                        <td class="quantitaFarmaco">8</td>
                        <td class="increaseFarmacoButton"><button onclick="increaseFarmaco()">+</button></td>
                        <td class="decreaseFarmacoButton"><button onclick="decreaseFarmaco()">-</button></td>
                        <td class="eliminaFarmacoButton"><button onclick="eliminaFarmaco()">Elimina</button></td>
                    </tr>
                </table>
                <button onclick="addFarmaco()" style="margin: 1em">Aggiungi farmaco</button>
            </div>

            <input type="submit" id="inviaPrenotazione" value="Conferma">
        </form>
    </div>
    
    <script src="${contextPath}/resources/js/clienti.js" />

</body>
</html>