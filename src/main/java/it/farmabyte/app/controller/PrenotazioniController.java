package it.farmabyte.app.controller;

import java.util.Date;

import it.farmabyte.app.model.Farmacia;
import it.farmabyte.app.model.Prenotazione;

public class PrenotazioniController extends Controller implements IPrenotazioni{

    @Override
    public Prenotazione[] getElencoPrenotazioni(Farmacia farmacia, Date giorno) {
        return farmacia.elencaPrenotazioni(giorno, giorno);
    }

    @Override
    public Prenotazione[] getElencoPrenotazioni(Farmacia farmacia, Date inizio, Date fine) {
        return farmacia.elencaPrenotazioni(inizio, fine);
    }

    @Override
    public boolean confermaPrenotazione(String idPrenotazione) {
        for(Prenotazione p : dbInstance.getPrenotazioni()){
            if(p.getId().equals(idPrenotazione)){
                p.setConfermata(true);
                return true;
            }
        }

        return false;
    }
    
}
