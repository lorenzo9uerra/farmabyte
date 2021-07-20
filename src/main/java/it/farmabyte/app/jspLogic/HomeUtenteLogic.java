
package it.farmabyte.app.jspLogic;
import it.farmabyte.app.controller.IRicercaFarmaci;
import it.farmabyte.app.model.ClienteRegistrato;
import it.farmabyte.app.model.Farmacista;
import it.farmabyte.app.services.IUtenteService;
import it.farmabyte.app.services.UtenteService;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class HomeUtenteLogic {

    @Autowired
    private IRicercaFarmaci ricercaFarmaciController;

    @Autowired
    private IUtenteService utenteService;

    @GetMapping({ "/", "/home" })
    public String home(Model model, Principal utente) { // Authentication invece di Principal se si vogliono più
        // informazioni
        if (utente == null) {
            model.addAttribute("hide", true);
            return "home";
        }
        ClienteRegistrato cliente;
        cliente = utenteService.findByUsername(utente.getName());
        if (cliente != null) {
            model.addAttribute("nomeUtente", " " + cliente.getNome());
            model.addAttribute("hide", false);
            return "home";
        }
        Farmacista farmacista = utenteService.findFarmacistaByUsername(utente.getName());
        model.addAttribute("nomeFarmacista", " " + farmacista.getNome());
        model.addAttribute("hide", false);
        return "homeFarmacia";
    }

    @PostMapping("")
    public String setName(@ModelAttribute ClienteRegistrato utente, Model model){
        model.addAttribute("utente", utente);
        System.out.println("ciao " + utente.getNome());
        return "home";
    }
}
            