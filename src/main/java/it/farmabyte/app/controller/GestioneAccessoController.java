
package it.farmabyte.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import it.farmabyte.app.model.ClienteRegistrato;
import it.farmabyte.app.services.IUtenteService;

@SpringBootApplication
@Controller
public class GestioneAccessoController implements IGestioneAccesso{
    @Autowired
    private IUtenteService uService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void registra(ClienteRegistrato cliente) {
        cliente.setBloccato(false);
        cliente.setVerificato(false);
        cliente.setEffrazioni(0);
        cliente.setPassword(bCryptPasswordEncoder.encode(cliente.getPassword()));
        uService.save(cliente);
    }
}