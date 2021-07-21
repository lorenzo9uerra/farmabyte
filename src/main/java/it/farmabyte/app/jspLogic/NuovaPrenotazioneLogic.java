
package it.farmabyte.app.jspLogic;
import it.farmabyte.app.DTO.RicercaFarmaciDTO;
import it.farmabyte.app.DTO.RicercaUtenteDTO;
import it.farmabyte.app.controller.IGestionePrenotazioni;
import it.farmabyte.app.controller.MockSingletonDatabase;
import it.farmabyte.app.model.ClienteRegistrato;
import it.farmabyte.app.model.Farmacia;
import it.farmabyte.app.model.Farmaco;
import it.farmabyte.app.model.Prenotazione;
import it.farmabyte.app.services.IUtenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@Controller
@RequestMapping(value = "/nuovaPrenotazione")
public class NuovaPrenotazioneLogic {

    @Autowired
    private IGestionePrenotazioni gestionePrenotazioniController;

    @Autowired
    private IUtenteService utenteService;

    private void initNuovaPrenotazione(Model model, Principal utente){
        model.addAttribute("ricercaUtente", new RicercaUtenteDTO());
        model.addAttribute("trovato","init");
        if(utente != null){
            ClienteRegistrato cliente = utenteService.findByUsername(utente.getName());
            LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            model.addAttribute("dataMinimaPrenotazione", tomorrow.format(formatter));

            model.addAttribute("prenotazioneForm", new Prenotazione());
        }
    }

    /*
    @GetMapping("")
    public String nuovaPrenotazione(Model model, Principal utente) {
        initNuovaPrenotazione(model, utente);
        return "nuovaPrenotazione";
    }
    */

    @GetMapping("")
    public String nuovaPrenotazione(Model model, Principal utente, 
        @RequestParam(value = "farmacia", required = false) String farmacia,
        @RequestParam(value = "farmaco", required = false) String farmaco) {

        initNuovaPrenotazione(model, utente);
        if(farmacia != null && farmaco != null){
            model.addAttribute("farmacia", farmacia);
            model.addAttribute("firstFarmaco", farmaco);
            model.addAttribute("getInitialized", true);    
        }

        return "nuovaPrenotazione";
    }

    @PostMapping(path = "", consumes = "application/x-www-form-urlencoded")
    public String nuovaPrenotazione(Model model, Principal utente, HttpServletRequest request){
        if(request != null){
            ClienteRegistrato cliente = utenteService.findByUsername(utente.getName());
            Farmacia farmacia = MockSingletonDatabase.getDatabaseInstance().findFarmaciaByNome(request.getParameter("farmacia"));
            Date data;

            try {
                data = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataPrenotazione"));
            } catch (ParseException e) {
                data = null;
                e.printStackTrace();
            }
            
            if(cliente == null || farmacia == null || data == null){
                model.addAttribute("error", true);
                return "nuovaPrenotazione";
            }

            Prenotazione prenotazione = new Prenotazione("A" + new Random().nextInt(), data, false, cliente, farmacia);

            Map<String, String[]> parameters = request.getParameterMap();
            Enumeration<String> parameterNames = request.getParameterNames();
            String lastFarmaco = null;
            int quantityLastFarmaco = 0;

            while(parameterNames.hasMoreElements()){
                String parameterName = parameterNames.nextElement();
                if(parameterName.equals("farmacia") || parameterName.equals("dataPrenotazione"))
                    continue;
                
                if(parameterName.startsWith("text")){
                    lastFarmaco = parameters.get(parameterName)[0];
                }
                else if(parameterName.startsWith("num")){
                    if(lastFarmaco == null){
                        model.addAttribute("error", true);
                        return "nuovaPrenotazione";
                    }
                    
                    quantityLastFarmaco = Integer.parseInt(parameters.get(parameterName)[0]);
                }

                if(lastFarmaco != null && quantityLastFarmaco > 0){
                    Farmaco currentFarmaco = MockSingletonDatabase.getDatabaseInstance().findFarmacoByNome(lastFarmaco);
                    prenotazione.addFarmaco(currentFarmaco, quantityLastFarmaco);
                }
            }

            MockSingletonDatabase.getDatabaseInstance().insertPrenotazione(prenotazione);

            System.out.println(cliente.getNome() + " " + cliente.getCognome() + " " + farmacia.getNome() + " " + data
            + "\n" + prenotazione.getId() + "(firstFarmaco) : " + prenotazione.getFarmaci().keySet().toArray(new Farmaco[1])[0].getNome());
            model.addAttribute("success", true);
        }
        else
            model.addAttribute("error", true);

        return "nuovaPrenotazione";
    }
    

}