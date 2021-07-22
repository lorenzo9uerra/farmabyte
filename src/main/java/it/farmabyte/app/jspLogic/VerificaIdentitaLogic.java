
package it.farmabyte.app.jspLogic;

import it.farmabyte.app.controller.UtentiController;
import it.farmabyte.app.model.ClienteRegistrato;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@Controller
@RequestMapping(value = "/farmacia/verificaIdentita")
public class VerificaIdentitaLogic {

    @Autowired
    private UtentiController utentiController;

    @GetMapping("")
    public String verificaIdentitaLogic(@RequestParam(value = "email", required = false) String email, Model model) {
        model.addAttribute("risultato", "init");
        Collection<ClienteRegistrato> clienti = new ArrayList<ClienteRegistrato>();
        if (email == null) {
            for (ClienteRegistrato cr : utentiController.getElencoUtenti()) {
                if (!cr.isVerificato()) {
                    clienti.add(cr);
                }
            }
            model.addAttribute("risultato", "true");
            model.addAttribute("utentiCercati", clienti);
            return "verificaIdentita";
        }
        if (!email.isBlank()) {
            System.out.println(email);
            ClienteRegistrato cliente = utentiController.ricercaUtente(email);
            if (cliente != null) {
                if (cliente.isVerificato()) {
                    model.addAttribute("risultato", "verificato");
                } else {
                    clienti.add(cliente);
                    model.addAttribute("risultato", "true");
                    model.addAttribute("utentiCercati", clienti);
                }
            } else
                model.addAttribute("risultato", "noResearchMatch");
        } else {
            model.addAttribute("risultato", "noResearchMatch");
        }

        return "verificaIdentita";
    }

    @PostMapping("")
    public String VerificaUtente(@RequestParam(value = "email", required = false) String email, Model model) {
        ClienteRegistrato cliente = utentiController.ricercaUtente(email);
        cliente.setVerificato(true);
        model.addAttribute("risultato", "GoodEnd");
        return "verificaIdentita";
    }

}