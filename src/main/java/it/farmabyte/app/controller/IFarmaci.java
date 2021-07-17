package it.farmabyte.app.controller;

import it.farmabyte.app.model.Farmaco;

public interface IFarmaci {
    public Farmaco[] getElencoFarmaci(String idFarmacia);
}
