package it.farmabyte.app.jspLogic;

import it.farmabyte.app.DTO.RicercaFarmaciDTO;
import it.farmabyte.app.controller.GestionePrenotazioniController;
import it.farmabyte.app.controller.IGestionePrenotazioni;
import it.farmabyte.app.controller.UtentiController;
import it.farmabyte.app.model.ClienteRegistrato;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;

import it.farmabyte.app.model.Prenotazione;
import it.farmabyte.app.services.IUtenteService;
import it.farmabyte.app.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@Controller
@RequestMapping(value = "/prenotazioni")
public class PrenotazioniClienteLogic {


    @Autowired
    private IGestionePrenotazioni gestionePrenotazioniController;

    @Autowired
    private IUtenteService utenteService;

    @GetMapping("")
    public String prenotazioni(Model model, Principal utente) {

            Collection<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
            //gestionePrenotazioniController.getListaPrenotazioni(utenteService.findByUsername(utente.getName()));
            model.addAttribute("prenotazioni",prenotazioni);

        return "prenotazioniCliente";
    }

}