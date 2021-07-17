package it.farmabyte.app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import lombok.Getter;
import lombok.Setter;

public class Farmacia {
    @Getter @Setter private String id;
    @Getter @Setter private String nome;
    @Getter @Setter private String provincia;
    @Getter @Setter private String comune;
    @Getter @Setter private String via;
    @Getter @Setter private int numeroCivico;

    @Setter private HashMap<Farmaco, Lotto> magazzino;
    @Setter private ArrayList<Prenotazione> prenotazioni;
    
    public Farmacia(String id, String nome, String provincia, String comune, String via, int numeroCivico) {
        this.id = id;
        this.nome = nome;
        this.provincia = provincia;
        this.comune = comune;
        this.via = via;
        this.numeroCivico = numeroCivico;

        magazzino = new HashMap<>();
    }

    public Farmacia(){
        magazzino = new HashMap<>();
    }

    public void addFarmaco(Farmaco toAdd, Lotto lotto){
        magazzino.put(toAdd, lotto);
    }

    public Prenotazione[] elencaPrenotazioni(Date inizio, Date fine){
        ArrayList<Prenotazione> prenotazioniFiltrate = new ArrayList<>();

        for(Prenotazione prenotazione : prenotazioni){
            if(!inizio.after(prenotazione.getData()) && !fine.before(prenotazione.getData()) ){
                prenotazioniFiltrate.add(prenotazione);
            }
        }

        return prenotazioniFiltrate.toArray(new Prenotazione[prenotazioniFiltrate.size()]);
    }

    public HashMap<Farmaco, Lotto> elencaFarmaci(){
        return magazzino;
    }

}
