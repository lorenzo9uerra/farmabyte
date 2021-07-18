
package it.farmabyte.app.jspLogic;
import it.farmabyte.app.DTO.RicercaFarmaciDTO;
import it.farmabyte.app.model.ClienteRegistrato;
import it.farmabyte.app.model.Farmacista;
import it.farmabyte.app.model.Prenotazione;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

@SpringBootApplication
@Controller
@RequestMapping(value = "/prenotazioniFarmacia")
public class PrenotazioniFarmaciaLogic {

/*
    @GetMapping("")
    public String prenotazioniFarmacia(Model model,@ModelAttribute("farmacista") Farmacista farmacista) {

        RicercaFarmaciDTO filtro= new RicercaFarmaciDTO();

        prenotazioniController.getPrenotazioni( farmacista.getFarmacia(), Date,Date);
        Collection<Prenotazione> prenotazioniOggi= farmacista.getFarmacia().elencaPrenotazioni(Calendar.);


        model.addAttribute("prenotazioniOggi", prenotazioniOggi);
        model.addAttribute("filtro",filtro);
        return "PrenotazioniFarmacia";
    }

    @PostMapping("")
    public String setName(@ModelAttribute("utente1") ClienteRegistrato utente, Model model){
        model.addAttribute("utente1",utente);
        System.out.println("ciao" + utente.getNome());
        return "homeFarmacista";
    }

    @GetMapping("/conferma")
    public String utente(Model model,@ModelAttribute("farmacista") Farmacista farmacista) {
        model.addAttribute("farmacista", farmacista);
        return "homeFarmacista";
    }
*/
}