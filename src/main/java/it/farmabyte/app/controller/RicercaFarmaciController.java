package it.farmabyte.app.controller;

import java.util.HashMap;

import it.farmabyte.app.model.Farmacia;
import it.farmabyte.app.model.Lotto;

public class RicercaFarmaciController extends Controller implements IRicercaFarmaci{

    //in realtà sarebbe meglio HashMap<Farmacia, Pair<Farmaco, Lotto>>, leggi commenti interfaccia
    public HashMap<Farmacia, Lotto> ricercaFarmaci(String citta, String nomeFarmaco) {
        HashMap<Farmacia, Lotto> risultatiRicerca = new HashMap<>();

        //Cerca sul database, filtra in base alla citta e al nome farmaco

        return risultatiRicerca;
    }
    
}
