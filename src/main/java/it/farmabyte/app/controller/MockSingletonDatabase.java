package it.farmabyte.app.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import it.farmabyte.app.model.*;

//Non dovrebbe servire
@Service
public class MockSingletonDatabase {
    
    private static MockSingletonDatabase dbInstance;

    private ArrayList<Prenotazione> prenotazioni;
    private ArrayList<Farmaco> farmaci;
    private ArrayList<Farmacia> farmacie;
    private ArrayList<ClienteRegistrato> clienti;
    private ArrayList<Farmacista> farmacisti;

    public static MockSingletonDatabase getDatabaseInstance(){
        if(dbInstance == null)
            dbInstance = new MockSingletonDatabase();
            
        return dbInstance;
    }

    private MockSingletonDatabase(){
        prenotazioni = new ArrayList<>();
        farmaci = new ArrayList<>();
        farmacie = new ArrayList<>();
        clienti = new ArrayList<>();
        farmacisti = new ArrayList<>();
    }

    public ClienteRegistrato findByUsername(String username){
        for(int i=0; i<clienti.size(); i++){
            if(clienti.get(i).getEmail().equals(username))
                return clienti.get(i);
            System.out.println(clienti.get(i).getEmail());
            System.out.println(username);
        }
        return null;
    }

    public boolean insertPrenotazione(Prenotazione toInsert){
        return prenotazioni.add(toInsert);
    }

    public boolean insertFarmaco(Farmaco toInsert){
        return farmaci.add(toInsert);
    }

    public boolean insertFarmacia(Farmacia toInsert){
        return farmacie.add(toInsert);
    }

    public boolean insertCliente(ClienteRegistrato toInsert){
        return clienti.add(toInsert);
    }
    public boolean insertFarmacista(Farmacista toInsert){
        return farmacisti.add(toInsert);
    }

    public ArrayList<Prenotazione> getPrenotazioni(){
        return prenotazioni;
    }

    public ArrayList<Farmaco> getFarmaci(){
        return farmaci;
    }

    public ArrayList<Farmacia> getFarmacie(){
        return farmacie;
    }

    public ArrayList<ClienteRegistrato> getClienti(){
        return clienti;
    }

    public ArrayList<Farmacista> getFarmacisti(){
        return farmacisti;
    }

    /* (Non ricordo a cosa servisse)
    public Prenotazione[] selectPrenotazione(ClienteRegistrato cliente, Farmacia farmacia){
        ArrayList<Prenotazione> result = new ArrayList<>();
        for(Prenotazione p : this.prenotazioni){
            if(p.getRichiedente().getCodiceFiscale().equals(cliente.getCodiceFiscale()) && p.getFarmacia().getId().equals(farmacia.getId())){
                result.add(p);
            }
        }

        return result.toArray(new Prenotazione[result.size()]);
    }
    */

    //e simili...

}
