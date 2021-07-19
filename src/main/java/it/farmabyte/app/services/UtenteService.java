package it.farmabyte.app.services;

import it.farmabyte.app.controller.MockSingletonDatabase;
import it.farmabyte.app.model.ClienteRegistrato;
import it.farmabyte.app.model.Farmacista;

import org.springframework.stereotype.Service;

@Service
public class UtenteService implements IUtenteService{
    private MockSingletonDatabase db = MockSingletonDatabase.getDatabaseInstance();

    public String toString(ClienteRegistrato cliente){
        return cliente.getNome();
    }

    @Override
    public void save(ClienteRegistrato user) {
        db.insertCliente(user);
    }

    @Override
    public ClienteRegistrato findByUsername(String username) {
        return db.findByUsername(username);
    }

    @Override
    public Farmacista findFarmacistaByUsername(String username) {
        return db.findFarmacistaByUsername(username);
    }
}