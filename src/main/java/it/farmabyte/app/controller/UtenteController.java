
package it.farmabyte.app.controller;
import it.farmabyte.app.model.ClienteRegistrato;
import it.farmabyte.app.model.Farmacista;
import it.farmabyte.app.services.UtenteService;
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
public class UtenteController {

    @Autowired
    UtenteService utenteService;

    ClienteRegistrato u;

    @GetMapping("")
    public String utente(Model model) {
        this.u = new ClienteRegistrato();

        u.setNome("Marina");
        ClienteRegistrato u1 = new ClienteRegistrato();
        System.out.println("ciao" + u.getNome());
        model.addAttribute("utente", u);
        model.addAttribute("utente1",u1);
        //model.addAttribute("belooo",new Farmacista("peppino","smaruzzi","CC22","gg@gmail.com"));
        return "utente";
    }

    @PostMapping("")
    public String setName(@ModelAttribute ClienteRegistrato utente, Model model){
        model.addAttribute("utente1",utente);
        model.addAttribute("utente",u);
        System.out.println("ciao" + utente.getNome());
        return "utente";
    }

}
            