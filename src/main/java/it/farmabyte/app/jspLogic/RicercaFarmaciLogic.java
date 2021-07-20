package it.farmabyte.app.jspLogic;

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
import it.farmabyte.app.model.Farmacia;
import it.farmabyte.app.model.Farmaco;
import it.farmabyte.app.model.Lotto;
import it.farmabyte.app.model.Pair;

@SpringBootApplication
@Controller
public class RicercaFarmaciLogic {

    @Autowired
    IRicercaFarmaci ricercaFarmaci;
    MockSingletonDatabase mockSingletonDatabase = MockSingletonDatabase.getDatabaseInstance();

    @PostMapping({ "/home", "/" })
    public String ricercaFarmaco(Model model, String farmaco, String città) {
        Map<Farmacia, Pair<Farmaco, Lotto>> farmaciResult = ricercaFarmaci.ricercaFarmaci(città, farmaco);
        model.addAttribute("farmaciResult", farmaciResult);
        return "home";
    }

    @RequestMapping(value = "/hintFarmaco", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ArrayList<String> hinterFarmaco(@RequestParam("farmaco") String farmaco) {
        ArrayList<String> resp = new ArrayList<String>();
        for (int i = 0; i < mockSingletonDatabase.getFarmaci().size(); i++) {
            if (mockSingletonDatabase.getFarmaci().get(i).getNome().toLowerCase().startsWith(farmaco.toLowerCase()))
                resp.add(mockSingletonDatabase.getFarmaci().get(i).getNome());
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

}
