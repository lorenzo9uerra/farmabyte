package it.farmabyte.app.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import it.farmabyte.app.model.ClienteRegistrato;
import it.farmabyte.app.model.Farmacia;
import it.farmabyte.app.model.Prenotazione;
import it.farmabyte.app.model.Farmaco;

@Service
public class GestionePrenotazioniController extends Controller implements IGestionePrenotazioni{

    public GestionePrenotazioniController(){
        super();
    }

    @Override
    public Prenotazione[] getListaPrenotazioni(ClienteRegistrato cliente) {
        return cliente.elencaPrenotazioni();
    }



    @Override
    public Prenotazione creaPrenotazione(ClienteRegistrato cliente, Farmacia farmacia, HashMap<Farmaco, Integer> listaFarmaci) {
        
        Prenotazione result = new Prenotazione(new Date(), false, cliente, farmacia, listaFarmaci);

        //salva la prenotazione nel DB.
        //se manteniamo tutto in locale possiamo utilizzare un singleton
        //che faccia da database fittizio per tutti gli oggetti

        dbInstance.insertPrenotazione(result);

        return result;
    }
    
}
