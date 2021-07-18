package it.farmabyte.app.controller;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import it.farmabyte.app.model.Farmacia;
import it.farmabyte.app.model.Lotto;
import it.farmabyte.app.model.Farmaco;
import it.farmabyte.app.model.Pair;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class RicercaFarmaciController extends Controller implements IRicercaFarmaci{

    public RicercaFarmaciController(){
        super();
    }

    //Se non si usa mai il metodo get() della mappa, è meglio fare un ArrayList<Pair<>> come array bidimensionale
    public HashMap<Farmacia, Pair<Farmaco, Lotto>> ricercaFarmaci(String citta, String nomeFarmaco) {
        //Cerca sul database, filtra in base alla citta e al nome farmaco
        
        //qui la query si complica un po' ma è normale (deve simulare un join di due tabelle del DB)

        HashMap<Farmacia, Pair<Farmaco, Lotto>> result = new HashMap<>();

        for(Farmacia farmacia : dbInstance.getFarmacie()){
            if(farmacia.getComune().equals(citta)){
                for(Farmaco farmaco : farmacia.getMagazzino().keySet()){
                    if(farmaco.getNome().equals(nomeFarmaco)){
                        result.put(farmacia, new Pair<>(farmaco, farmacia.getMagazzino().get(farmaco)));
                    }
                }
            }
        }

        return result;

    }

    @Override
    public int ricercaFarmaci(Farmacia farmacia, String nomeFarmaco) {
        //restituisce direttamente la quantità del farmaco specificato presente nella farmacia richiesta (può essere 0)

        int result = 0;

        for(Farmaco farmaco : farmacia.getMagazzino().keySet()){
            if(farmaco.getNome().equals(nomeFarmaco)){
                result += farmacia.getMagazzino().get(farmaco).getQuantita();
            }
        }

        return result;
    }
    
}
