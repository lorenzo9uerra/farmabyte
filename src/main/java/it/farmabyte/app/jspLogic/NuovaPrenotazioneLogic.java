
package it.farmabyte.app.jspLogic;
import it.farmabyte.app.DTO.RicercaFarmaciDTO;
import it.farmabyte.app.DTO.RicercaUtenteDTO;
import it.farmabyte.app.controller.UtentiController;
import it.farmabyte.app.model.ClienteRegistrato;
import it.farmabyte.app.model.Farmacista;
import it.farmabyte.app.model.Prenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

@SpringBootApplication
@Controller
@RequestMapping(value = "/nuovaPrenotazione")
public class NuovaPrenotazioneLogic {

    @Autowired
    private UtentiController utentiController;

    @GetMapping("")
    public String nuovaPrenotazione(Model model) {

        model.addAttribute("ricercaUtente", new RicercaUtenteDTO());
        model.addAttribute("trovato","init");
        return "verificaIdentita";
    }

}