package it.farmabyte.app.jspLogic;

import it.farmabyte.app.DTO.RicercaFarmaciDTO;
import it.farmabyte.app.controller.UtentiController;
import it.farmabyte.app.model.ClienteRegistrato;

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
    private UtentiController utentiController;

    @GetMapping("")
    public String utenti(Model model) {
        //ClienteRegistrato[] utenti= utentiController.getElencoUtenti( );
        ClienteRegistrato gigi= new ClienteRegistrato();
        gigi.setNome("Gigi");
        gigi.setCognome("Sbarulfi");
        gigi.setCodiceFiscale("AAVV55423");
        gigi.setEmail("gigi@gmail.com");
        gigi.setEffrazioni(2);
        gigi.setBloccato(false);

        ClienteRegistrato gigi1= new ClienteRegistrato();
        gigi1.setNome("Gigione");
        gigi1.setCognome("Sbarulfone");
        gigi1.setCodiceFiscale("AAVV55423ZZZZZZZZZZZ");
        gigi1.setEmail("giggino@gmail.com");
        gigi1.setEffrazioni(1);
        gigi1.setBloccato(true);
        ClienteRegistrato[] utenti= new ClienteRegistrato[2];
        utenti[0]=gigi;
        utenti[1]=gigi1;

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

        ClienteRegistrato[] utenti= utentiController.getElencoUtenti( );

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
