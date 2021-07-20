var number=20;
var result="";
var counter;//numero sul bottone
var control=1;
var found=0;
var tempo=0;
/*
 * Funzione che genera una lista XHTML 
 * con gli item presi dai feed RSS scaricati in formato JSON
 */
function parsificaJSON( jsonText ) {
	var response = JSON.parse(jsonText);
	
	if (control!=counter) {
		control++;
		found+=response.count;
		tempo+=response.time;
	}
	else{
		found+=response.count;
		tempo+=response.time;
		
		result+="La parola è stata trovata "+found+"volte</br>";
		result+="<label value=\"Tempo Totale\">";
		if(counter!=1)
			result+="<input type=\"text\" value=\""+tempo+"\" readonly>";
		document.getElementById("Risultato").innerHTML=result;

		result="";
		counter=1;
		control=1;
		found=0;
		tempo=0;
	}
}// parsificaJSON()



function callback( theXhr ) {
	if ( theXhr.readyState === 2 ) {
	    //	theElement.innerHTML = "Richiesta inviata...";
	}
	else if ( theXhr.readyState === 3 ) {
    		//theElement.innerHTML = "Ricezione della risposta...";
	}
	else if ( theXhr.readyState === 4 ) {
		if ( theXhr.status === 200 ) {
      		parsificaJSON(theXhr.responseText.slice());
	    }
	    else {
	        alert("Errore");
	    }
	}
} // callback();

function caricaFeedAJAX(theMessage, theXhr) {
    
	theXhr.onreadystatechange = function() { callback(theXhr); };

	try {
		theXhr.open("post", "Telefono" , true);
	}
	catch(e) {
		alert(e);
	}
	
	theXhr.send(JSON.stringify(theMessage));
}

function caricaFeed(m) {
	var xhr = myGetXmlHttpRequest();
	if ( xhr ) 
		caricaFeedAJAX(m, xhr );
}


function onfarmacoChange(b){
	counter=b.value;
	turno=0;
	var text = document.getElementById("parola").value;
	var letters = /^[A-Za-z]+$/;
	if( !text.match(letters) ) {
		alert("parola not valid");
	return;
 	}	
	
	
	for(var k=0;k<counter;k++){
		c1+=i;

   		var message = {
   			p: text,
			n: k,
			c: counter
   		}
   		console.log("J: "+JSON.stringify(message));
   		caricaFeed(message);
   	}
}


