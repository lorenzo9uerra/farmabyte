package it.farmabyte.app.jspLogic;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.farmabyte.app.controller.IRicercaFarmaci;
import it.farmabyte.app.controller.MockSingletonDatabase;
import it.farmabyte.app.model.ClienteRegistrato;
import it.farmabyte.app.model.Farmacia;
import it.farmabyte.app.model.Farmaco;
import it.farmabyte.app.model.Lotto;
import it.farmabyte.app.model.Pair;
import it.farmabyte.app.services.IUtenteService;

@SpringBootApplication
@Controller
public class RicercaFarmaciLogic {

    @Autowired
    IRicercaFarmaci ricercaFarmaci;

    @Autowired
    IUtenteService utenteService;

    MockSingletonDatabase mockSingletonDatabase = MockSingletonDatabase.getDatabaseInstance();

    @PostMapping({ "/home", "/" })
    public String ricercaFarmaco(Model model, String farmaco, String comune, Principal utente) {
        Map<Farmacia, Pair<Farmaco, Lotto>> farmaciResult = ricercaFarmaci.ricercaFarmaci(comune, farmaco);
        model.addAttribute("farmaciResult", farmaciResult);
        if(utente == null)
            return "home";
        ClienteRegistrato cliente = new ClienteRegistrato();
        cliente = utenteService.findByUsername(utente.getName());
        if (cliente != null) {
            model.addAttribute("nomeUtente", " " + cliente.getNome());
            System.out.println(utente.getName());
            model.addAttribute("show", true);
        }
        return "home";
    }

    @RequestMapping(value = "/hintFarmaco", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ArrayList<String> hinterFarmaco(@RequestParam("farmaco") String farmaco, 
                                                        @RequestParam(value = "farmacia", required = false) String farmacia) {
        
        ArrayList<String> resp = new ArrayList<String>();
        
        if(farmacia == null){
            for (int i = 0; i < mockSingletonDatabase.getFarmaci().size(); i++) {
                if (mockSingletonDatabase.getFarmaci().get(i).getNome().toLowerCase().startsWith(farmaco.toLowerCase()))
                    resp.add(mockSingletonDatabase.getFarmaci().get(i).getNome());
            }
        }
        else{
            //autocompletamento di farmaci relativi a una farmacia specifica (caso di NuovaPrenotazione)
            
        }

        return resp;
    }

    @RequestMapping(value = "/hintComune", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ArrayList<String> hinterComune(@RequestParam("comune") String comune) {
        ArrayList<String> resp = new ArrayList<String>();
        for (int i = 0; i < mockSingletonDatabase.getComuni().size(); i++) {
            if (mockSingletonDatabase.getComuni().get(i).toLowerCase().startsWith(comune.toLowerCase()))
                resp.add(mockSingletonDatabase.getComuni().get(i));
        }
        return resp;
    }

    @RequestMapping(value = "/hintFarmacia", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ArrayList<String> hinterFarmacia(@RequestParam("farmacia") String farmacia) {
        ArrayList<String> resp = new ArrayList<String>();

        //processing...

        return resp;
    }

}
