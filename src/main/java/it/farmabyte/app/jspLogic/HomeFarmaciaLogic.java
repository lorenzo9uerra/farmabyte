
package it.farmabyte.app.jspLogic;
import it.farmabyte.app.services.IUtenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@SpringBootApplication
@Controller
@RequestMapping(value = "/farmacia/")
public class HomeFarmaciaLogic {

    @Autowired
    IUtenteService utenteService;

    @GetMapping("")
    public String homeFarmacia(Model model, Principal farmacista) {
        model.addAttribute("farmacista", utenteService.findByUsername(farmacista.getName()));
        return "homeFarmacia";
    }


}