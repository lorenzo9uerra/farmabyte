
package it.farmabyte.app.controller;
import it.farmabyte.app.model.ClienteRegistrato;
import it.farmabyte.app.services.UtenteService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
@RequestMapping(value = "/utente")
public class UtenteController {


    @GetMapping("")
    public String utente(Model model) {
        ClienteRegistrato u = new ClienteRegistrato();

        u.setNome("Marina");
        model.addAttribute("utente", u);
        return "utente";
    }

}
            