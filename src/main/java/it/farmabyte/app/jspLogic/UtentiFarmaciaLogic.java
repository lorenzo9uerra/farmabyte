package it.farmabyte.app.jspLogic;

import it.farmabyte.app.controller.IUtenti;
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
@RequestMapping("/farmacia/utenti")
public class UtentiFarmaciaLogic {

    @Autowired
    private IUtenti utentiController;

    @GetMapping("")
    public String utenti(@RequestParam(value = "email", required = false) String email, Model model) {
        if (email != null) {
            if (email.isBlank()) {
                Collection<ClienteRegistrato> utenti = utentiController.getElencoUtenti();
                model.addAttribute("utenti", utenti);
                return "utentiFarmacia";
            }
            Collection<ClienteRegistrato> cliente = new ArrayList<ClienteRegistrato>();
            cliente.add(utentiController.ricercaUtente(email));
            model.addAttribute("utenti", cliente);
            return "utentiFarmacia";
        } else {
            Collection<ClienteRegistrato> utenti = utentiController.getElencoUtenti();
            model.addAttribute("utenti", utenti);
            return "utentiFarmacia";
        }
    }

    @PostMapping("")
    public String bloccaUtente(@RequestParam(value = "email") String email, Model model) {
        ClienteRegistrato cliente = utentiController.ricercaUtente(email);
        if (cliente == null) {
            model.addAttribute("error", "Non è stato possibile effettuare l'azione richiesta sull'utente: " + email);
            Collection<ClienteRegistrato> utenti = utentiController.getElencoUtenti();
            model.addAttribute("utenti", utenti);
            return "utentiFarmacia";
        }
        if (!cliente.isBloccato())
            utentiController.bloccaUtente(email);
        else
            utentiController.sbloccaUtente(email);
        Collection<ClienteRegistrato> utenti = utentiController.getElencoUtenti();
        model.addAttribute("utenti", utenti);
        return "utentiFarmacia";
    }
}
