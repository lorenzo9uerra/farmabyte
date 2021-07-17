package it.farmabyte.app.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class Lotto {
    @Getter @Setter private int quantita;
    @Getter @Setter private Date scadenza;
    
    public Lotto(int quantita, Date scadenza) {
        this.quantita = quantita;
        this.scadenza = scadenza;
    }
       
}
