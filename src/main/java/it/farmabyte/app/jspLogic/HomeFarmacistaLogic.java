
package it.farmabyte.app.jspLogic;
import it.farmabyte.app.controller.RicercaFarmaciController;
import it.farmabyte.app.model.ClienteRegistrato;
import it.farmabyte.app.model.Farmacista;
import it.farmabyte.app.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@Controller
@RequestMapping(value = "/homeFarmacista")
@SessionAttributes("farmacista")
public class HomeFarmacistaLogic {

    @GetMapping("")
    public String utente(Model model,@ModelAttribute("farmacista") Farmacista farmacista) {
        model.addAttribute("farmacista", farmacista);
        return "homeFarmacista";
    }

    @PostMapping("")
    public String setName(@ModelAttribute("utente1") ClienteRegistrato utente, Model model){
        model.addAttribute("utente1",utente);
        System.out.println("ciao" + utente.getNome());
        return "homeFarmacista";
    }

    @ModelAttribute("farmacista")
    public Farmacista farmacista(){
        return new Farmacista("Gino", "veffo", "CCa44","email@gmail.it", "password");
    }

}