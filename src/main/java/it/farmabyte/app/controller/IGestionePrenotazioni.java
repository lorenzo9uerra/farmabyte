package it.farmabyte.app.controller;

import it.farmabyte.app.model.ClienteRegistrato;
import it.farmabyte.app.model.Prenotazione;

public interface IGestionePrenotazioni {
    public Prenotazione[] getListaPrenotazioni(ClienteRegistrato cliente);
    public Prenotazione creaPrenotazione();
}
