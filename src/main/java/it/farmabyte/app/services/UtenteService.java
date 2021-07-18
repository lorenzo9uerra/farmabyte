package it.farmabyte.app.services;

import it.farmabyte.app.controller.MockSingletonDatabase;
import it.farmabyte.app.model.ClienteRegistrato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UtenteService implements IUtenteService{
    public String toString(ClienteRegistrato cliente){
        int i=1;
        return cliente.getNome();
    }
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private MockSingletonDatabase db = MockSingletonDatabase.getDatabaseInstance();

    @Override
    public void save(ClienteRegistrato user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        db.insertCliente(user);
    }

    @Override
    public ClienteRegistrato findByUsername(String username) {
        return db.findByUsername(username);
    }
}