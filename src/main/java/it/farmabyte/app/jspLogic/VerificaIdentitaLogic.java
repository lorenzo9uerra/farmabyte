
package it.farmabyte.app.jspLogic;
import it.farmabyte.app.DTO.RicercaUtenteDTO;
import it.farmabyte.app.controller.UtentiController;
import it.farmabyte.app.model.ClienteRegistrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

@SpringBootApplication
@Controller
@RequestMapping(value = "/farmacia/verificaIdentita")
public class VerificaIdentitaLogic {

    @Autowired
    private UtentiController utentiController;

    @GetMapping("")
    public String verificaIdentitaLogic(Model model) {

        model.addAttribute("ricercaUtente", new RicercaUtenteDTO());
        model.addAttribute("trovato","init");
        return "verificaIdentita";
    }

    @PostMapping("")
    public String ricercaUtente(@ModelAttribute("ricercaUtente") RicercaUtenteDTO ricerca, Model model){
        model.addAttribute("risultato","true");
        try {
            //ClienteRegistrato cliente = utentiController.ricercaUtente(ricerca.getEmail());
            ClienteRegistrato cliente=new ClienteRegistrato("Federico","Chesani","CC4564BB","ggg@gmail.com", Calendar.getInstance().getTime(),0,false,false);
            model.addAttribute("utenteCercato",cliente);
        }catch(Exception e){
            model.addAttribute("risultato","noResearchMatch");
        }
        return "verificaIdentita";
    }

    @PutMapping("")
    public String VerificaUtente(@ModelAttribute("utenteCercato") ClienteRegistrato cliente, Model model){
            System.out.println("ciao"+ cliente.getEmail());
            boolean risultato=utentiController.confermaUtente(cliente.getEmail());
            if(true)
                model.addAttribute("risultato","GoodEnd");
            else
                model.addAttribute("risultato","BadEnd");
        return this.verificaIdentitaLogic(model);
    }

}