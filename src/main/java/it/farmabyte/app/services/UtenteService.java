package it.farmabyte.app.services;

import it.farmabyte.app.model.ClienteRegistrato;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {
    public String toString(ClienteRegistrato cliente){
        int i=1;
        return cliente.getNome();
    }
}