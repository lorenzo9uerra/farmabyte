window.addEventListener("load", function () {

    // Add a keyup event listener to our input element
    var inputFarmaco = document.getElementById('farmaco');
    inputFarmaco.addEventListener("keyup", function (event) { hinter(event, "list_farmaci", "/hintFarmaco?farmaco=") });

    var inputFarmaco = document.getElementById('comune');
    inputFarmaco.addEventListener("keyup", function (event) { hinter(event, "list_comuni", "/hintComune?comune=") });

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

        window.hinterXHR.open("GET", url + input.value, true);
        window.hinterXHR.send()
    }
}

function validateForm() {

    var inputFarmaco = document.getElementById('farmaco');
    var list_farmaci = document.getElementById('list_farmaci');
    var inputComune = document.getElementById('comune');
    var list_comuni = document.getElementById('list_comuni');
    var farmaco = false;
    var comune = false;

    // If we find the input inside our list, we submit the form
    for (var element of list_farmaci.children) {
        if (element.value == inputFarmaco.value) {
            farmaco = true;
        }
    }

    for (var element of list_comuni.children) {
        if (element.value == inputComune.value) {
            comune = true;
        }
    }

    if (comune === true && farmaco === true)
        return true;
    else {

        // we send an error message
        alert("Il farmaco o la città scelta non sono disponibili")
        return false;
    }
}