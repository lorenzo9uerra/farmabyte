
package it.farmabyte.app.jspLogic;
import it.farmabyte.app.DTO.RicercaFarmaciDTO;
import it.farmabyte.app.DTO.RicercaUtenteDTO;
import it.farmabyte.app.controller.IGestionePrenotazioni;
import it.farmabyte.app.controller.MockSingletonDatabase;
import it.farmabyte.app.model.ClienteRegistrato;
import it.farmabyte.app.services.IUtenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@Controller
@RequestMapping(value = "/nuovaPrenotazione")
public class NuovaPrenotazioneLogic {

    @Autowired
    private IGestionePrenotazioni gestionePrenotazioniController;

    @Autowired
    private IUtenteService utenteService;

    private void initNuovaPrenotazione(Model model, Principal utente){
        model.addAttribute("ricercaUtente", new RicercaUtenteDTO());
        model.addAttribute("trovato","init");
        if(utente != null){
            ClienteRegistrato cliente = utenteService.findByUsername(utente.getName());
            LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            model.addAttribute("dataMinimaPrenotazione", tomorrow.format(formatter));
        }
    }

    /*
    @GetMapping("")
    public String nuovaPrenotazione(Model model, Principal utente) {
        initNuovaPrenotazione(model, utente);
        return "nuovaPrenotazione";
    }
    */

    @GetMapping("")
    public String nuovaPrenotazione(Model model, Principal utente, 
        @RequestParam(value = "farmacia", required = false) String farmacia,
        @RequestParam(value = "farmaco", required = false) String farmaco) {

        initNuovaPrenotazione(model, utente);
        if(farmacia != null && farmaco != null){
            model.addAttribute("farmacia", farmacia);
            model.addAttribute("firstFarmaco", farmaco);
            model.addAttribute("getInitialized", true);    
        }

        return "nuovaPrenotazione";
    }
    

}