package it.farmabyte.app.model;

import java.util.Date;
import java.util.HashMap;

import lombok.Getter;
import lombok.Setter;

public class Prenotazione {
    @Getter @Setter private Date data;
    @Getter @Setter private boolean confermata;
    @Getter @Setter private ClienteRegistrato richiedente;
    @Getter @Setter private Farmacia farmacia;
    
    @Getter @Setter private HashMap<Farmaco, Integer> farmaci;
    
    public Prenotazione(){
        farmaci = new HashMap<>();
    }

    public Prenotazione(Date data, boolean confermata, ClienteRegistrato richiedente, Farmacia farmacia) {
        this.data = data;
        this.confermata = confermata;
        this.richiedente = richiedente;
        this.farmacia = farmacia;

        farmaci = new HashMap<>();
    }

    public void addFarmaco(Farmaco toAdd, int quantita){
        farmaci.put(toAdd, quantita);
    }
    
}
