package it.farmabyte.app.controller;

import java.util.Map;

import it.farmabyte.app.model.Farmaco;
import it.farmabyte.app.model.Lotto;

public interface IFarmaci {
    public Map<Farmaco,Lotto> getElencoFarmaci(String idFarmacia);
}
