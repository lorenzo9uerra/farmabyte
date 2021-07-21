package it.farmabyte.app.jspLogic;

import it.farmabyte.app.controller.IGestionePrenotazioni;

import java.security.Principal;
import java.util.ArrayList;

import it.farmabyte.app.model.Prenotazione;
import it.farmabyte.app.services.IUtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@Controller
public class PrenotazioniClienteLogic {


    @Autowired
    private IGestionePrenotazioni gestionePrenotazioniController;

    @Autowired
    private IUtenteService utenteService;

    @GetMapping("/prenotazioni")
    public String prenotazioni(Model model, Principal utente) {
        ArrayList<Prenotazione> prenotazioni=gestionePrenotazioniController.getListaPrenotazioni(utenteService.findByUsername(utente.getName()));
        model.addAttribute("prenotazioni",prenotazioni);

        return "prenotazioniCliente";
    }

}