var numFarmaci;
var nextId;

window.addEventListener("load", function () {

    //Aggiungiamo dei listener ai campi in cui vogliamo l'autocompletamento
    //Per i farmaci aggiunti in seguito questo viene fatto dinamicamente dentro le altre funz. di callback

    // Add a keyup event listener to our input element
    var inputFarmacia = document.getElementById('farmacia');
    inputFarmacia.addEventListener("keyup", function (event) { hinter(event, "list_farmacia", "/hintFarmacia?farmacia=") });

    var inputFarmaco = document.getElementById('nomeFarmaco_1');
    inputFarmaco.addEventListener("keyup", function (event) { hinter(event, "list_nomeFarmaco_1", "/hintFarmaco?farmaco=") });

    // create one global XHR object 
    // so we can abort old requests when a new one is make
    window.hinterXHR = new XMLHttpRequest();
});

// Autocomplete for form
function hinter(event, element, url) {

    // retireve the input element
    var input = event.target;

    // retrieve the datalist element
    var huge_list = document.getElementById(element);

    // minimum number of characters before we start to generate suggestions
    var min_characters = 0;

    if (input.value.length < min_characters) {
        return;
    } else {

        // abort any pending requests
        window.hinterXHR.abort();

        window.hinterXHR.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                // We're expecting a json response so we convert it to an object
                var response = JSON.parse(this.responseText);

                // clear any previously loaded options in the datalist
                huge_list.innerHTML = "";

                response.forEach(function (item) {
                    // Create a new <option> element.
                    var option = document.createElement('option');
                    option.value = item;

                    // attach the option to the datalist element
                    huge_list.appendChild(option);
                });
            }
        };
        //Aggiunta url per inviare anche la farmacia nella richiesta get nel caso di hintFarmaco
        var urlAddition = (input.id == 'farmacia')? '' : '&farmacia=' + document.getElementById('farmacia').value;
        window.hinterXHR.open("GET", url + input.value + urlAddition, true);
        window.hinterXHR.send()
    }
}

function prenotazione_init(getInitialized){
    if(getInitialized)
        numFarmaci = 1;
    else
        numFarmaci = 0;

    if(document.getElementById("farmacia").value != ''){
        document.getElementById("farmacia").readOnly = true;
        document.getElementById("text_nomeFarmaco_1").readOnly = true;
    }
    else
        document.getElementById("farmacia").readOnly = false;

    nextId = 2;
}

function increaseFarmaco(id){
    var quantityObj = document.getElementById("num_quantitaFarmaco_" + id);
    quantityObj.value = parseInt(quantityObj.value) + 1;
}

function decreaseFarmaco(id){
    var quantityObj = document.getElementById("num_quantitaFarmaco_" + id);
    if(parseInt(quantityObj.value) > 1)
        quantityObj.value = parseInt(quantityObj.value) - 1;
    else
        eliminaFarmaco(id);
}

function eliminaFarmaco(id){
    var table = document.getElementById("farmaci-tbody");
    //elimina direttamente la <tr>
    table.removeChild(document.getElementById(id));
}

function addFarmaco(){
    var table = document.getElementById("farmaci-tbody");
    var toAdd = document.createElement("tr");
    var nomeFarmaco = document.createElement("td");
    var datalist = document.createElement("datalist");
    var spacer = document.createElement("td");
    var quantitaFarmaco = document.createElement("td");
    var increaseFarmacoButton = document.createElement("td");
    var decreaseFarmacoButton = document.createElement("td");
    var eliminaFarmacoButton = document.createElement("td");

    toAdd.setAttribute("id", nextId);
    
    nomeFarmaco.setAttribute("class", "nomeFarmaco");
    nomeFarmaco.setAttribute("id", "nomeFarmaco_" + nextId);
    nomeFarmaco.innerHTML = '<input type="text" id="text_nomeFarmaco_' + nextId + '1" name="text_nomeFarmaco_' + nextId + '1" list="list_nomeFarmaco_' + nextId + '" placeholder="Nome farmaco">';
    datalist.setAttribute("id", "list_nomeFarmaco_" + nextId);
    spacer.setAttribute("class", "spacer");
    quantitaFarmaco.setAttribute("class", "quantitaFarmaco");
    quantitaFarmaco.setAttribute("id", "quantitaFarmaco_" + nextId);
    quantitaFarmaco.innerHTML = '<input type="text" id="num_quantitaFarmaco_' + nextId + '" name="num_quantitaFarmaco_' + nextId + '" value="1" readonly>';
    increaseFarmacoButton.setAttribute("class", "increaseFarmacoButton");
    increaseFarmacoButton.innerHTML = '<button type="button" onclick="increaseFarmaco(' + nextId + ')">+</button>';
    decreaseFarmacoButton.setAttribute("class", "decreaseFarmacoButton");
    decreaseFarmacoButton.innerHTML = '<button type="button" onclick="decreaseFarmaco(' + nextId + ')">-</button>';
    eliminaFarmacoButton.setAttribute("class", "eliminaFarmacoButton");
    eliminaFarmacoButton.innerHTML = '<button type="button" onclick="eliminaFarmaco(' + nextId + ')">Elimina</button>';

    toAdd.appendChild(nomeFarmaco);
    toAdd.appendChild(datalist);
    toAdd.appendChild(spacer);
    toAdd.appendChild(quantitaFarmaco);
    toAdd.appendChild(increaseFarmacoButton);
    toAdd.appendChild(decreaseFarmacoButton);
    toAdd.appendChild(eliminaFarmacoButton);
    
    table.appendChild(toAdd);

    // listener per l'autocompletamento

    var listName = "list_nomeFarmaco_" + nextId;
    
    document.getElementById("nomeFarmaco_" + nextId).addEventListener("keyup", 
    function (event) { hinter(event, listName, "/hintFarmaco?farmaco=") });

    nextId++;
}

function validate(){
    var returnValue = true;
    if(document.getElementById("farmacia").value == "")
        returnValue = false;
    else if(document.getElementById("dataPrenotazione").value == "")
        returnValue = false;
    else{
        
        for(currentValueTr of document.getElementById("farmaci-tbody").children){
            var nomeFarmacoTd = currentValueTr.firstElementChild;
            if(nomeFarmacoTd.children.length > 0){
                if(nomeFarmacoTd.firstElementChild.value == ''){
                    returnValue = false;
                }
            }
        }
    }

    if(returnValue)
        document.getElementById("error").setAttribute("hidden");
    else
        document.getElementById("error").removeAttribute("hidden");

    var error = document.getElementById("post-error");
    var success = document.getElementById("post-success");
    if(error != null){
        error.setAttribute("hidden");
    }
    if(success != null){
        success.setAttribute("hidden");
    }

    return returnValue;
}