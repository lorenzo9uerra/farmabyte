
package it.farmabyte.app.jspLogic;
import it.farmabyte.app.DTO.RicercaFarmaciDTO;
import it.farmabyte.app.model.ClienteRegistrato;
import it.farmabyte.app.model.Farmacista;
import it.farmabyte.app.model.Prenotazione;
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
@RequestMapping(value = "/prenotazioniFarmacia")
public class PrenotazioniFarmaciaLogic {

    //@Autowired private PrenotazioniController prenotazioniController;

    @GetMapping("")
    public String prenotazioniFarmacia(Model model,@ModelAttribute("farmacista") Farmacista farmacista) {

        RicercaFarmaciDTO filtro= new RicercaFarmaciDTO();
        Date oggi= Calendar.getInstance().getTime();

        //Collection<Prenotazione> prenotazioniOggi= prenotazioniController.getPrenotazioni( farmacista.getFarmacia(), oggi,oggi);


        ClienteRegistrato cr=new ClienteRegistrato();
        cr.setNome("pippo");
        cr.setCognome("Augusto");
        ClienteRegistrato cr1=new ClienteRegistrato();
        cr1.setNome("angela");
        cr1.setCognome("gennara");

        Prenotazione p1= new Prenotazione();
        p1.setId( "" );
        p1.setConfermata(false);
        p1.setRichiedente(cr);

        Prenotazione p2= new Prenotazione();
        p2.setConfermata(true);
        p2.setRichiedente(cr1);
        Collection<Prenotazione> prenotazioniOggi=new ArrayList<Prenotazione>();

        prenotazioniOggi.add(p1);
        prenotazioniOggi.add(p2);

        model.addAttribute("prenotazioniOggi", prenotazioniOggi);
        model.addAttribute("filtro",filtro);
        model.addAttribute("pr",new Prenotazione());
        return "prenotazioniFarmacia";
    }

    @PostMapping("/conferma")
    public String confermaPrenotazione(@ModelAttribute("pr") Prenotazione prenotazione, Model model){
        //TODO
        Collection<Prenotazione> prenotazioni= (Collection<Prenotazione>) model.getAttribute("prenotazioniOggi");

        prenotazioni.

        return "prenotazioniFarmacia";
    }

    @PostMapping("/ricerca")
    public String utente(Model model,@ModelAttribute("filtro") RicercaFarmaciDTO filtro) {
        //TODO
        return "prenotazioniFarmacia";
    }

}