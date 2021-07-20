
package it.farmabyte.app.jspLogic;
import it.farmabyte.app.model.Farmacista;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@SpringBootApplication
@Controller
@RequestMapping(value = "/farmacia/homeFarmacia")
public class HomeFarmaciaLogic {

    @GetMapping("")
    public String homeFarmacia(Model model, Principal farmacista) {


        //model.addAttribute("farmacista", utenteService.findByUsername(farmacista.getName()));
        model.addAttribute("farmacista", new Farmacista("pippo","ckdck","asjkasdjk","dafdfad","kasdf"));
        return "homeFarmacia";
    }


}