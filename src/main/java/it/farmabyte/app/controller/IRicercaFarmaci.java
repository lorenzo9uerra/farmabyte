package it.farmabyte.app.controller;

import java.util.Map;

import it.farmabyte.app.model.Farmacia;
import it.farmabyte.app.model.Farmaco;
import it.farmabyte.app.model.Lotto;
import it.farmabyte.app.model.Pair;

public interface IRicercaFarmaci {
    public Map<Farmacia, Pair<Farmaco, Lotto>> ricercaFarmaci(String citta, String nomeFarmaco);

    public int ricercaFarmaci(Farmacia farmacia, String nomeFarmaco);
}
