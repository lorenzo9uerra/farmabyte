package it.farmabyte.app.services;

import it.farmabyte.app.controller.MockSingletonDatabase;
import it.farmabyte.app.model.ClienteRegistrato;

import org.springframework.stereotype.Service;

@Service
public class UtenteService implements IUtenteService{
    public String toString(ClienteRegistrato cliente){
        return cliente.getNome();
    }

    private MockSingletonDatabase db = MockSingletonDatabase.getDatabaseInstance();

    @Override
    public void save(ClienteRegistrato user) {
        db.insertCliente(user);
    }

    @Override
    public ClienteRegistrato findByUsername(String username) {
        return db.findByUsername(username);
    }
}