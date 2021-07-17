
package it.farmabyte.app.controller;
import it.farmabyte.app.model.Utente;
import it.farmabyte.app.services.UtenteService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProvaController {

    @GetMapping("/utente")
    public String hello(Model model) {
        Utente u = new Utente();
        u.setNome("Giorgio");
        model.addAttribute("utente", u);
        return "prova";
    }

}
            