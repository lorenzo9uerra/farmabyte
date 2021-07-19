package it.farmabyte.app.services;

import it.farmabyte.app.model.ClienteRegistrato;
import it.farmabyte.app.model.Farmacista;

public interface IUtenteService {
    void save(ClienteRegistrato user);
    String toString(ClienteRegistrato cliente);

    ClienteRegistrato findByUsername(String username);
    Farmacista findFarmacistaByUsername(String username);
}
