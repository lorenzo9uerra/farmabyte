package it.farmabyte.app.model;

import java.util.Date;

public class Lotto {
    private int quantita;
    private Date scadenza;
    
    public Lotto(int quantita, Date scadenza) {
        this.quantita = quantita;
        this.scadenza = scadenza;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public Date getScadenza() {
        return scadenza;
    }

    public void setScadenza(Date scadenza) {
        this.scadenza = scadenza;
    }
       
}
