package it.farmabyte.app.controller;

import java.util.HashMap;

import it.farmabyte.app.model.Farmacia;
import it.farmabyte.app.model.Lotto;

public interface IRicercaFarmaci {
    //TODO: decidere valore di ritorno della funzione, idealmente sarebbe HashMap<Farmacia, Pair<Farmaco,Lotto>> 
    //(esiste la classe Pair)
    public HashMap<Farmacia, Lotto> ricercaFarmaci(String citta, String nomeFarmaco);
}
