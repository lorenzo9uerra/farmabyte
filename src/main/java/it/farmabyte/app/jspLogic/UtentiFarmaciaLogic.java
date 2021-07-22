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
            Collection<ClienteRegistrato> utenti = new ArrayList<ClienteRegistrato>();
            ClienteRegistrato cliente = utentiController.ricercaUtente(email);
            if(cliente == null){
                model.addAttribute("utenti", new ArrayList<>());
                return "utentiFarmacia";
            }
            utenti.add(cliente);
            model.addAttribute("utenti", utenti);
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
