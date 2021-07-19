package it.farmabyte.app.controller;

import java.util.Collection;

import org.springframework.stereotype.Service;

import it.farmabyte.app.model.ClienteRegistrato;

@Service
public class UtentiController extends Controller implements IUtenti{

    public UtentiController(){
        super();
    }

    @Override
    public Collection<ClienteRegistrato> getElencoUtenti() {
        return dbInstance.getClienti();
    }

    @Override
    public ClienteRegistrato ricercaUtente(String email) {
        //può restituire null se email non presente
        for(ClienteRegistrato cliente : dbInstance.getClienti()){
            if(cliente.getEmail().equals(email)){
                return cliente;
            }
        }

        return null;
    }

    @Override
    public boolean confermaUtente(String email) {
        for(ClienteRegistrato cliente : dbInstance.getClienti()){
            if(cliente.getEmail().equals(email)){
                cliente.setVerificato(true);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean bloccaUtente(String email) {
        for(ClienteRegistrato cliente : dbInstance.getClienti()){
            if(cliente.getEmail().equals(email)){
                cliente.setBloccato(true);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean sbloccaUtente(String email) {
        for(ClienteRegistrato cliente : dbInstance.getClienti()){
            if(cliente.getEmail().equals(email)){
                cliente.setBloccato(false);
                return true;
            }
        }

        return false;
    }
    
}
