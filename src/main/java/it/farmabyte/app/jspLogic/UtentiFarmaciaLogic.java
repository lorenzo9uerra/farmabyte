package it.farmabyte.app.jspLogic;

import it.farmabyte.app.controller.IUtenti;
import it.farmabyte.app.model.ClienteRegistrato;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@Controller
@RequestMapping(value = "/utenti")
public class UtentiFarmaciaLogic {


    @Autowired
    private IUtenti utentiController;

    @GetMapping("")
    public String utenti(Model model) {
        Collection<ClienteRegistrato> utenti= utentiController.getElencoUtenti( );

        model.addAttribute("utenti", utenti);
        model.addAttribute("cr",new ClienteRegistrato());
        model.addAttribute("risultato","init");
        return "utentiFarmacia";
    }

    @PostMapping("")
    public String bloccaUtente(@ModelAttribute("cr") ClienteRegistrato cliente, Model model){
        if(!cliente.isBloccato())
            utentiController.bloccaUtente(cliente.getEmail());
        else
            utentiController.sbloccaUtente(cliente.getEmail());

        Collection<ClienteRegistrato> utenti= utentiController.getElencoUtenti( );

        model.addAttribute("utenti", utenti);
        model.addAttribute("cr",new ClienteRegistrato());
        return "utentiFarmacia";
    }

    @PutMapping("")
    public String ricercaUtente(@ModelAttribute("cr") ClienteRegistrato cliente, Model model){
        model.addAttribute("risultato", "init");
        try {
            ClienteRegistrato utenti = utentiController.ricercaUtente(cliente.getEmail());
            model.addAttribute("utenti", utenti);
        }catch(Exception e){
            model.addAttribute("risultato","noResearchMatch");
        }
        model.addAttribute("cr",new ClienteRegistrato());
        return "utentiFarmacia";
    }

}
