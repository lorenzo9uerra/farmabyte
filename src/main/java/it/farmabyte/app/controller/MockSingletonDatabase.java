package it.farmabyte.app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import it.farmabyte.app.model.*;

//Non dovrebbe servire
@Service
public class MockSingletonDatabase {

    private static MockSingletonDatabase dbInstance;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    private ArrayList<Prenotazione> prenotazioni;
    private ArrayList<Farmaco> farmaci;
    private ArrayList<Farmacia> farmacie;
    private ArrayList<ClienteRegistrato> clienti;
    private ArrayList<Farmacista> farmacisti;
    private ArrayList<String> comuni;

    public static MockSingletonDatabase getDatabaseInstance() {
        if (dbInstance == null)
            dbInstance = new MockSingletonDatabase();

        return dbInstance;
    }

    private MockSingletonDatabase() {
        prenotazioni = new ArrayList<>();
        farmaci = new ArrayList<>();
        farmacie = new ArrayList<>();
        clienti = new ArrayList<>();
        farmacisti = new ArrayList<>();
        comuni = new ArrayList<>();

        Farmaco aspirina = new Farmaco("AICKL1134LP", "ASPIRINA 20 mg");
        Farmaco collirio = new Farmaco("BNJKA9589OE", "COLLIRIO ABC");
        Farmaco oki = new Farmaco("NKNJS8457BB", "OKI 15 mg");
        Farmaco tachipirina = new Farmaco("AJSNV1247KG", "TACHIPIRINA 20 mg");
        Farmaco gaviscon = new Farmaco("GDNBH2853FA", "GAVISCON 200 ml");

        farmaci.add(aspirina);
        farmaci.add(collirio);
        farmaci.add(oki);
        farmaci.add(tachipirina);
        farmaci.add(gaviscon);

        Farmacia farmaciaSD = new Farmacia("BO1GRBZ1", "Farmacia San Domenico", "BO", "Bologna", "Via Garibaldi", 1);
        Farmacia farmaciaTV = new Farmacia("BO2TVNZ1", "Farmacia Tavernari", "BO", "Bologna", "Via d'Azeglio", 88);
        Farmacia farmaciaDM = new Farmacia("BO3MLLZ1", "Farmacia dei Mille", "BO", "Bologna", "Via dei Mille", 7);
        comuni.add("Bologna");
        Farmacia farmaciaMZ = new Farmacia("LE8MAUO5", "Farmacia Mazzini", "LE", "Lecce", "Via Borsellino", 5);
        comuni.add("Lecce");
        Farmacia farmaciaDA = new Farmacia("GE9JOIE2", "Farmacia Danimarca", "GE", "Genova", "Via Carlo Marx", 74);
        comuni.add("Genova");
        Farmacia farmaciaMI = new Farmacia("MI2TDJF1", "Farmacia Lunari", "MI", "Milano", "Via Roma", 12);
        comuni.add("Milano");

        farmaciaSD.addFarmaco(aspirina, new Lotto(245, new Date(122, 9, 14)));
        farmaciaSD.addFarmaco(collirio, new Lotto(300, new Date(124, 11, 23)));
        farmaciaSD.addFarmaco(oki, new Lotto(450, new Date(122, 7, 9)));
        farmaciaTV.addFarmaco(oki, new Lotto(2, new Date(121, 12, 1)));

        farmaciaMZ.addFarmaco(oki, new Lotto(129, new Date(122, 2, 12)));
        farmaciaMZ.addFarmaco(tachipirina, new Lotto(97, new Date(124, 4, 5)));
        farmaciaMZ.addFarmaco(gaviscon, new Lotto(156, new Date(123, 12, 9)));

        farmacie.add(farmaciaSD);
        farmacie.add(farmaciaTV);
        farmacie.add(farmaciaDM);
        farmacie.add(farmaciaMZ);
        farmacie.add(farmaciaDA);
        farmacie.add(farmaciaMI);

        farmacisti.add(new Farmacista("Orazio", "Grinzosi", "GRNRZO43M13H703T", "orazio.grinzosi@farmacia.com",
                farmaciaSD, bCryptPasswordEncoder.encode("password")));
        farmacisti.add(new Farmacista("Alberto", "Rossi", "RSSLRT63B04G337G", "alberto.rossi@farmacia.com", farmaciaMZ,
                bCryptPasswordEncoder.encode("password")));

        ClienteRegistrato benson = new ClienteRegistrato("Riccardo", "Benzoni", "BNZRCR66B07H501D",
                "riccardo.benzoni@studio.unibo.it", new Date(66, 2, 7), 0, false, false);
        benson.setPassword(bCryptPasswordEncoder.encode("password"));
        benson.setPasswordConfirm("password");

        ClienteRegistrato matteo = new ClienteRegistrato("Matteo", "Montesi", "MNTMTT72B08KO98S",
                "matteo.montesi@studio.unibo.it", new Date(72, 7, 12), 0, true, false);
        benson.setPassword(bCryptPasswordEncoder.encode("password"));
        benson.setPasswordConfirm("password");

        ClienteRegistrato paul = new ClienteRegistrato("Paul", "Niceview", "PALNCV70B25I241A", "paul.niceview@unibo.it",
                new Date(70, 2, 5), 0, true, false);
        benson.setPassword(bCryptPasswordEncoder.encode("password"));
        benson.setPasswordConfirm("password");

        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("cliente"));
        benson.setAuthorities(grantedAuthorities);
        clienti.add(benson);
        clienti.add(matteo);
        clienti.add(paul);

        Map<Farmaco, Integer> farmaciPrenotazione = new HashMap<Farmaco, Integer>();
        farmaciPrenotazione.put(oki, 3);
        farmaciPrenotazione.put(tachipirina, 2);
        farmaciPrenotazione.put(gaviscon, 1);
        Prenotazione prenotazione = new Prenotazione("2398KJHIB1", new Date(124, 5, 12), false, benson, farmaciaMZ,
                farmaciPrenotazione);
        prenotazioni.add(prenotazione);
        farmaciPrenotazione = new HashMap<Farmaco, Integer>();
        farmaciPrenotazione.put(tachipirina, 6);
        prenotazione = new Prenotazione("840BKJ29KH", new Date(121, 6, 22), false, benson, farmaciaMZ, 
                farmaciPrenotazione);
        prenotazioni.add(prenotazione);
        farmaciaMZ.addPrenotazione(prenotazione);
    }

    public ClienteRegistrato findByUsername(String username) {
        for (int i = 0; i < clienti.size(); i++) {
            if (clienti.get(i).getEmail().equals(username))
                return clienti.get(i);
        }
        return null;
    }

    public Farmacista findFarmacistaByUsername(String username) {
        for (int i = 0; i < farmacisti.size(); i++) {
            if (farmacisti.get(i).getEmail().equals(username))
                return farmacisti.get(i);
        }
        return null;
    }

    public Farmacia findFarmaciaByNome(String nomeFarmacia) {
        for (Farmacia farmacia : farmacie) {
            if (farmacia.getNome().toLowerCase().equals(nomeFarmacia.toLowerCase())) {
                return farmacia;
            }
        }

        return null;
    }

    public Farmaco findFarmacoByNome(String nomeFarmaco) {
        for (Farmaco farmaco : farmaci) {
            if (farmaco.getNome().equals(nomeFarmaco))
                return farmaco;
        }

        return null;
    }

    public boolean insertPrenotazione(Prenotazione toInsert) {
        return prenotazioni.add(toInsert);
    }

    public boolean insertFarmaco(Farmaco toInsert) {
        return farmaci.add(toInsert);
    }

    public boolean insertFarmacia(Farmacia toInsert) {
        return farmacie.add(toInsert);
    }

    public boolean insertCliente(ClienteRegistrato toInsert) {
        return clienti.add(toInsert);
    }

    public boolean removeCliente(String email) {
        for (ClienteRegistrato cliente : clienti) {
            if (cliente.getEmail().equals(email)) {
                clienti.remove(cliente);
                return true;
            }
        }
        return false;
    }

    public boolean insertComune(String toInsert) {
        return comuni.add(toInsert);
    }

    public boolean insertFarmacista(Farmacista toInsert) {
        return farmacisti.add(toInsert);
    }

    public ArrayList<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public ArrayList<Farmaco> getFarmaci() {
        return farmaci;
    }

    public ArrayList<String> getComuni() {
        return comuni;
    }

    public ArrayList<Farmacia> getFarmacie() {
        return farmacie;
    }

    public ArrayList<ClienteRegistrato> getClienti() {
        return clienti;
    }

    public ArrayList<Farmacista> getFarmacisti() {
        return farmacisti;
    }

    /*
     * (Non ricordo a cosa servisse) public Prenotazione[]
     * selectPrenotazione(ClienteRegistrato cliente, Farmacia farmacia){
     * ArrayList<Prenotazione> result = new ArrayList<>(); for(Prenotazione p :
     * this.prenotazioni){
     * if(p.getRichiedente().getCodiceFiscale().equals(cliente.getCodiceFiscale())
     * && p.getFarmacia().getId().equals(farmacia.getId())){ result.add(p); } }
     * 
     * return result.toArray(new Prenotazione[result.size()]); }
     */

    // e simili...

}
