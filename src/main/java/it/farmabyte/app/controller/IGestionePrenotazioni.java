package it.farmabyte.app.controller;

import java.util.Collection;
import java.util.Map;

import it.farmabyte.app.model.ClienteRegistrato;
import it.farmabyte.app.model.Farmacia;
import it.farmabyte.app.model.Prenotazione;
import it.farmabyte.app.model.Farmaco;

public interface IGestionePrenotazioni {
    public Collection<Prenotazione> getListaPrenotazioni(ClienteRegistrato cliente);
    public Prenotazione creaPrenotazione(ClienteRegistrato cliente, Farmacia farmacia, Map<Farmaco, Integer> listaFarmaci);
}
