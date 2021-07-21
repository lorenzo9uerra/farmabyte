
package it.farmabyte.app.jspLogic;
import it.farmabyte.app.model.Farmacista;
import it.farmabyte.app.services.IUtenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@SpringBootApplication
@Controller
public class HomeFarmaciaLogic {

    @Autowired
    IUtenteService utenteService;

    @GetMapping(value = "/farmacia")
    public String farmacia(Model model, Principal utente) {
        System.out.println(utente.getName());
        Farmacista farmacista = utenteService.findFarmacistaByUsername(utente.getName());
        if (farmacista != null) {
            model.addAttribute("nomeFarmacista", " " + farmacista.getNome());
            System.out.println(farmacista.getNome());
        }
        return "homeFarmacia";
    }

}