
package it.farmabyte.app.jspLogic;
import it.farmabyte.app.DTO.RicercaFarmaciDTO;
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
@RequestMapping(value = "/prenotazioniFarmacia")
@SessionAttributes({"prenotazioniOggi","listaPrenotazioni"})
public class PrenotazioniFarmaciaLogic {

    //@Autowired
    //private PrenotazioniController prenotazioniController;

    @GetMapping("")
    public String prenotazioniFarmacia(Model model,@ModelAttribute("farmacista") Farmacista farmacista) {

        Date oggi= Calendar.getInstance().getTime();

        //Collection<Prenotazione> prenotazioniOggi= prenotazioniController.getPrenotazioni( farmacista.getFarmacia(), oggi,oggi);


        ClienteRegistrato cr=new ClienteRegistrato();
        cr.setNome("pippo");
        cr.setCognome("Augusto");
        ClienteRegistrato cr1=new ClienteRegistrato();
        cr1.setNome("angela");
        cr1.setCognome("gennara");

        Prenotazione p1= new Prenotazione();
        p1.setId( "Prenotazione1" );
        p1.setConfermata(false);
        p1.setRichiedente(cr);

        Prenotazione p2= new Prenotazione();
        p1.setId( "Prenotazione2" );
        p2.setConfermata(true);
        p2.setRichiedente(cr1);
        p2.setData(oggi);
        Collection<Prenotazione> prenotazioniOggi=new ArrayList<Prenotazione>();

        prenotazioniOggi.add(p1);
        prenotazioniOggi.add(p2);

        model.addAttribute("prenotazioniOggi", prenotazioniOggi);
        model.addAttribute("filtro",new RicercaFarmaciDTO());
        model.addAttribute("pr",new Prenotazione());
        return "prenotazioniFarmacia";
    }

    @PostMapping("/conferma")
    public String confermaPrenotazione(@ModelAttribute("pr") Prenotazione prenotazione, Model model){

        //prenotazioniController.confermaPrenotazione(prenotazione.getId());

        Date oggi= Calendar.getInstance().getTime();
        model.addAttribute("filtro",new RicercaFarmaciDTO());
        model.addAttribute("pr",new Prenotazione());
        //Collection<Prenotazione> prenotazioniOggi= prenotazioniController.getPrenotazioni( farmacista.getFarmacia(), oggi,oggi);
        //model.addAttribute("prenotazioniOggi", prenotazioniOggi);
        return "prenotazioniFarmacia";
    }

    @PostMapping("/ricerca")
    public String utente(Model model,@ModelAttribute("filtro") RicercaFarmaciDTO filtro) {
        //Collection<Prenotazione> ListaPrenotazioni= prenotazioniController.getPrenotazioni( farmacista.getFarmacia(), filtro.getInizio(),filtro.getFine());
        //model.addAttribute("ListaPrenotazioni", ListaPrenotazioni);
        return "prenotazioniFarmacia";
    }

}