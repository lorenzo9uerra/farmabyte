package it.farmabyte.app.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Prenotazione {
    private String id;
    private Date data;
    private boolean confermata;
    private ClienteRegistrato richiedente;
    private Farmacia farmacia;
    private Map<Farmaco, Integer> farmaci;

    public String getId(){return id;}
    public void setId(String id){this.id=id;}
    
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

    public Map<Farmaco, Integer> getFarmaci() {
        return farmaci;
    }

    public void setFarmaci(HashMap<Farmaco, Integer> farmaci) {
        this.farmaci = farmaci;
    }

    public Prenotazione(){
        farmaci = new HashMap<>();
    }

    public Prenotazione(String id, Date data, boolean confermata, ClienteRegistrato richiedente, Farmacia farmacia, Map<Farmaco, Integer> farmaci) {
        this.data = data;
        this.confermata = confermata;
        this.richiedente = richiedente;
        this.farmacia = farmacia;
        this.id = id;

        this.farmaci = farmaci;
    }

    public Prenotazione(String id, Date data, boolean confermata, ClienteRegistrato richiedente, Farmacia farmacia) {
        this.data = data;
        this.confermata = confermata;
        this.richiedente = richiedente;
        this.farmacia = farmacia;
        this.id = id;

        farmaci = new HashMap<>();
    }
    

    public void addFarmaco(Farmaco toAdd, int quantita){
        farmaci.put(toAdd, quantita);
    }
    
}
