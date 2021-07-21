
package it.farmabyte.app.jspLogic;

import it.farmabyte.app.model.ClienteRegistrato;
import it.farmabyte.app.model.Farmacista;
import it.farmabyte.app.services.IUtenteService;

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
    private IUtenteService utenteService;

    @GetMapping({ "/", "/home" })
    public String home(Model model, Principal utente) { // Authentication invece di Principal se si vogliono più
        // informazioni
        model.addAttribute("show", false);
        if(utente==null)
            return "home";
        ClienteRegistrato cliente;
        cliente = utenteService.findByUsername(utente.getName());
        if (cliente != null) {
            model.addAttribute("nomeUtente", " " + cliente.getNome());
            System.out.println(utente.getName());
            model.addAttribute("show", true);
            return "home";
        }
        Farmacista farmacista = utenteService.findFarmacistaByUsername(utente.getName());
        if (farmacista != null) {
            model.addAttribute("nomeFarmacista", " " + farmacista.getNome());
            System.out.println(utente.getName());
            model.addAttribute("show", true);
            return "homeFarmacia";
        }
        return "home";
    }
}
