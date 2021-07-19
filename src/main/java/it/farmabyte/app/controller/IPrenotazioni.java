package it.farmabyte.app.controller;

import java.util.Collection;
import java.util.Date;

import it.farmabyte.app.model.Farmacia;
import it.farmabyte.app.model.Prenotazione;

public interface IPrenotazioni {
    public Collection<Prenotazione> getElencoPrenotazioni(Farmacia farmacia, Date giorno);
    public Collection<Prenotazione> getElencoPrenotazioni(Farmacia farmacia, Date inizio, Date fine);
    public boolean confermaPrenotazione(String idPrenotazione);
}
