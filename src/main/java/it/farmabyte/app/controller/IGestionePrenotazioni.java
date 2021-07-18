package it.farmabyte.app.controller;

import java.util.HashMap;

import it.farmabyte.app.model.ClienteRegistrato;
import it.farmabyte.app.model.Farmacia;
import it.farmabyte.app.model.Prenotazione;
import it.farmabyte.app.model.Farmaco;

public interface IGestionePrenotazioni {
    public Prenotazione[] getListaPrenotazioni(ClienteRegistrato cliente);
    public Prenotazione creaPrenotazione(ClienteRegistrato cliente, Farmacia farmacia, HashMap<Farmaco, Integer> listaFarmaci);
}
