
package it.farmabyte.app.jspLogic;
import it.farmabyte.app.controller.IRicercaFarmaci;
import it.farmabyte.app.model.ClienteRegistrato;
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
@RequestMapping(value = "/utente")
public class UtenteLogic {

    @Autowired
    private IRicercaFarmaci ricercaFarmaciController;

    @Autowired
    private IUtenteService utenteService;

    @GetMapping("")
    public String utente(Model model, Principal utente) {

        //this.u = new ClienteRegistrato();
        //u.setNome("Marina");
        //ClienteRegistrato u1 = new ClienteRegistrato();
        if (utente == null)
            return "home";
        ClienteRegistrato cliente;
        cliente = utenteService.findByUsername(utente.getName());
        
        System.out.println("ciao " + cliente.getNome());
        model.addAttribute("utente", cliente);
        //model.addAttribute("utente1",u1);
        return "utente";
    }

    @PostMapping("")
    public String setName(@ModelAttribute ClienteRegistrato utente, Model model){
        model.addAttribute("utente", utente);
        System.out.println("ciao " + utente.getNome());
        return "utente";
    }

}
            