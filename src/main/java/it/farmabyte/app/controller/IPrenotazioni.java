package it.farmabyte.app.controller;

import java.util.Date;

import it.farmabyte.app.model.Prenotazione;

public interface IPrenotazioni {
    public Prenotazione[] getElencoPrenotazioni(Date giorno);
    public Prenotazione[] getElencoPrenotazioni(Date inizio, Date fine);
    public boolean confermaPrenotazione(String idPrenotazione);
}
