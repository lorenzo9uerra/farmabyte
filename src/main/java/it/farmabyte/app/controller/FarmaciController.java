package it.farmabyte.app.controller;

import java.util.HashMap;

import it.farmabyte.app.model.Farmaco;
import it.farmabyte.app.model.Farmacia;
import it.farmabyte.app.model.Lotto;


public class FarmaciController extends Controller implements IFarmaci{
    
    public FarmaciController(){
        super();
    }
    
    public HashMap<Farmaco,Lotto> getElencoFarmaci(String idFarmacia){
        for(Farmacia farmacia : dbInstance.getFarmacie()){
            if(farmacia.getId().equals(idFarmacia)){
                return farmacia.getMagazzino();
            }
        }

        return null;
    }
}
