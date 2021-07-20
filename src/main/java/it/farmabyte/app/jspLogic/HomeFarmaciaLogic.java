
package it.farmabyte.app.jspLogic;
import it.farmabyte.app.controller.RicercaFarmaciController;
import it.farmabyte.app.model.ClienteRegistrato;
import it.farmabyte.app.model.Farmacista;
import it.farmabyte.app.services.IUtenteService;
import it.farmabyte.app.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@SpringBootApplication
@Controller
@RequestMapping(value = "/homeFarmacia")
public class HomeFarmaciaLogic {

    @Autowired
    private IUtenteService utenteService;
    @GetMapping("")
    public String homeFarmacia(Model model, Principal farmacista) {


        //model.addAttribute("farmacista", utenteService.findByUsername(farmacista.getName()));
        model.addAttribute("farmacista", new Farmacista("pippo","ckdck","asjkasdjk","dafdfad","kasdf"));
        return "homeFarmacia";
    }


}