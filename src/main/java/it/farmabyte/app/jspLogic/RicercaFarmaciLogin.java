package it.farmabyte.app.jspLogic;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import it.farmabyte.app.controller.IRicercaFarmaci;
import it.farmabyte.app.model.Farmacia;
import it.farmabyte.app.model.Farmaco;
import it.farmabyte.app.model.Lotto;
import it.farmabyte.app.model.Pair;

@SpringBootApplication
@Controller
public class RicercaFarmaciLogin {

    @Autowired
    IRicercaFarmaci ricercaFarmaci;

    @PostMapping("/home")
    public String ricercaFarmaco(Model model, String farmaco, String città) {
        Map<Farmacia, Pair<Farmaco, Lotto>> farmaciResult = ricercaFarmaci.ricercaFarmaci(città, farmaco);
        model.addAttribute("farmaciResult", farmaciResult);
        return "home";
    }
}
