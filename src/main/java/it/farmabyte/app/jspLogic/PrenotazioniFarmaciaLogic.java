package it.farmabyte.app.jspLogic;

import it.farmabyte.app.controller.IPrenotazioni;
import it.farmabyte.app.controller.MockSingletonDatabase;
import it.farmabyte.app.model.Prenotazione;
import it.farmabyte.app.services.IUtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;

@SpringBootApplication
@Controller
@RequestMapping(value = "/farmacia/prenotazioni")
public class PrenotazioniFarmaciaLogic {

    @Autowired
    private IPrenotazioni prenotazioniController;

    MockSingletonDatabase dbInstance = MockSingletonDatabase.getDatabaseInstance();

    @Autowired
    private IUtenteService utentiService;

    @GetMapping("")
    public String prenotazioniFarmacia(Model model, Principal farmacista,@RequestParam(value="conferma", required= false) String conferma) {
        if (conferma != null) {
            if (!conferma.isEmpty()) {
                if (!prenotazioniController.confermaPrenotazione(conferma)) {
                    model.addAttribute("error", "Errore durante la conferma della prenotazione");
                } else {
                    model.addAttribute("success", "Prenotazione confermata");
                }
            }
        }

        Collection<Prenotazione> prenotazioni= dbInstance.getPrenotazioni();
        model.addAttribute("message", "Prenotazioni di oggi");
        model.addAttribute("prenotazioni", prenotazioni);
        return "prenotazioniFarmacia";
    }

    @PostMapping("")
    public String confermaPrenotazione(String inizio, String fine, Prenotazione prenotazione, Model model, Principal farmacista) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Collection<Prenotazione> prenotazioni= prenotazioniController.getElencoPrenotazioni(utentiService.findFarmacistaByUsername(farmacista.getName()).getFarmacia(), sdf.parse(inizio), sdf.parse(fine));
        model.addAttribute("prenotazioni", prenotazioni);
        model.addAttribute("message", "Prenotazioni tra "+inizio+" e "+fine);
        return "prenotazioniFarmacia";
    }
}