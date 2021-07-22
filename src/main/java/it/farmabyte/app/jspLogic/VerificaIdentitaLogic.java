
package it.farmabyte.app.jspLogic;

import it.farmabyte.app.DTO.RicercaUtenteDTO;
import it.farmabyte.app.controller.UtentiController;
import it.farmabyte.app.model.ClienteRegistrato;
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
        if (email == null) {
            return "verificaIdentita";
        }
        if (!email.isBlank()) {
            System.out.println(email);
            ClienteRegistrato cliente = utentiController.ricercaUtente(email);
            if (cliente != null){
                if(cliente.isVerificato()){
                    model.addAttribute("risultato", "verificato");
                }
                else{
                    model.addAttribute("risultato", "true");
                    model.addAttribute("utenteCercato", cliente);
                }
            }
            else
                model.addAttribute("risultato", "noResearchMatch");
        }
        else{
            model.addAttribute("risultato", "noResearchMatch");
        }

        return "verificaIdentita";
    }

    @PostMapping("")
    public String VerificaUtente(@RequestParam(value = "email", required = false) String email, Model model) {
        System.out.println(email);
        // if(utentiController.confermaUtente(email))
        if (true)
            model.addAttribute("risultato", "GoodEnd");
        else
            model.addAttribute("risultato", "BadEnd");
        model.addAttribute("ricercaUtente", new RicercaUtenteDTO());
        return "verificaIdentita";
    }

}