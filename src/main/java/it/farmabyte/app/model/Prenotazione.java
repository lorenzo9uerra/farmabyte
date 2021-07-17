package it.farmabyte.app.model;

import java.util.Date;
import java.util.HashMap;


public class Prenotazione {
    private Date data;
    private boolean confermata;
    private ClienteRegistrato richiedente;
    private Farmacia farmacia;
    private HashMap<Farmaco, Integer> farmaci;
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isConfermata() {
        return confermata;
    }

    public void setConfermata(boolean confermata) {
        this.confermata = confermata;
    }

    public ClienteRegistrato getRichiedente() {
        return richiedente;
    }

    public void setRichiedente(ClienteRegistrato richiedente) {
        this.richiedente = richiedente;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    public HashMap<Farmaco, Integer> getFarmaci() {
        return farmaci;
    }

    public void setFarmaci(HashMap<Farmaco, Integer> farmaci) {
        this.farmaci = farmaci;
    }

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
