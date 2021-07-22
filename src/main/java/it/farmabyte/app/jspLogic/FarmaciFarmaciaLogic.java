
package it.farmabyte.app.jspLogic;
import it.farmabyte.app.controller.IFarmaci;
import it.farmabyte.app.model.Farmaco;
import it.farmabyte.app.model.Lotto;
import it.farmabyte.app.services.IUtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@SpringBootApplication
@Controller
@RequestMapping(value = "/farmacia/farmaci")
public class FarmaciFarmaciaLogic {

    @Autowired
    private IFarmaci farmaciController;

    @Autowired
    private IUtenteService utentiService;

    @GetMapping("")
    public String farmaciFarmacia(Model model, Principal farmacista) {
        Map<Farmaco, Lotto> farmaci= farmaciController.
                getElencoFarmaci( utentiService.findFarmacistaByUsername( farmacista.getName() ).getFarmacia().getId() );
        model.addAttribute("farmaci", farmaci);
        return "farmaciFarmacia";
    }
}