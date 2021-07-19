package it.farmabyte.app.controller;

import java.util.HashMap;

import it.farmabyte.app.model.Farmaco;
import it.farmabyte.app.model.Lotto;

public interface IFarmaci {
    public HashMap<Farmaco,Lotto> getElencoFarmaci(String idFarmacia);
}
