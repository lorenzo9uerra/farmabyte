var numFarmaci;
var nextId;

function prenotazione_init(getInitialized){
    if(getInitialized)
        numFarmaci = 1;
    else
        numFarmaci = 0;

    if(document.getElementById("farmacia").value != '')
        document.getElementById("farmacia").disabled = true;
    else
        document.getElementById("farmacia").disabled = false;

    nextId = 2;
}

function increaseFarmaco(id){
    var quantityObj = document.getElementById("quantitaFarmaco_" + id);
    quantityObj.innerText = parseInt(quantityObj.innerText) + 1;
}

function decreaseFarmaco(id){
    var quantityObj = document.getElementById("quantitaFarmaco_" + id);
    if(parseInt(quantityObj.innerText) > 1)
        quantityObj.innerText = parseInt(quantityObj.innerText) - 1;
    else
        eliminaFarmaco(id);
}

function eliminaFarmaco(id){
    var table = document.getElementById("farmaci-table");
    table.removeChild(document.getElementById(id));
}

function addFarmaco(){
    var table = document.getElementById("farmaci-table");
    var toAdd = document.createElement("tr");
    var nomeFarmaco = document.createElement("td");
    var spacer = document.createElement("td");
    var quantitaFarmaco = document.createElement("td");
    var increaseFarmacoButton = document.createElement("td");
    var decreaseFarmacoButton = document.createElement("td");
    var eliminaFarmacoButton = document.createElement("td");

    toAdd.setAttribute("id", nextId);
    
    nomeFarmaco.setAttribute("class", "nomeFarmaco");
    nomeFarmaco.setAttribute("id", "nomeFarmaco_" + nextId);
    nomeFarmaco.innerText = "Farmaco" + nextId;
    spacer.setAttribute("class", "spacer");
    quantitaFarmaco.setAttribute("class", "quantitaFarmaco");
    quantitaFarmaco.setAttribute("id", "quantitaFarmaco_" + nextId);
    quantitaFarmaco.innerText = 1;
    increaseFarmacoButton.setAttribute("class", "increaseFarmacoButton");
    increaseFarmacoButton.innerHTML = '<button type="button" onclick="increaseFarmaco(' + nextId + ')">+</button>';
    decreaseFarmacoButton.setAttribute("class", "decreaseFarmacoButton");
    decreaseFarmacoButton.innerHTML = '<button type="button" onclick="decreaseFarmaco(' + nextId + ')">-</button>';
    eliminaFarmacoButton.setAttribute("class", "eliminaFarmacoButton");
    eliminaFarmacoButton.innerHTML = '<button type="button" onclick="eliminaFarmaco(' + nextId + ')">Elimina</button>';

    nextId++;

    toAdd.appendChild(nomeFarmaco);
    toAdd.appendChild(spacer);
    toAdd.appendChild(quantitaFarmaco);
    toAdd.appendChild(increaseFarmacoButton);
    toAdd.appendChild(decreaseFarmacoButton);
    toAdd.appendChild(eliminaFarmacoButton);
    
    table.appendChild(toAdd);
}