
package it.farmabyte.app.jspLogic;

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
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@Controller
@RequestMapping(value = "/nuovaPrenotazione")
public class NuovaPrenotazioneLogic {

    @Autowired
    private IUtenteService utenteService;

    private void initNuovaPrenotazione(Model model, Principal utente){
        if(utente != null){
            LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            model.addAttribute("dataMinimaPrenotazione", tomorrow.format(formatter));

            model.addAttribute("prenotazioneForm", new Prenotazione());
        }
    }

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
        initNuovaPrenotazione(model, utente);

        if(request != null){
            ClienteRegistrato cliente = utenteService.findByUsername(utente.getName());
            Farmacia farmacia = MockSingletonDatabase.getDatabaseInstance().findFarmaciaByNome(request.getParameter("farmacia"));
            Date data;

            System.out.println("Parameter farmacia: " + request.getParameter("farmacia"));
            System.out.println("(Parameter)Principal cliente: " + utente.getName());

            try {
                data = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataPrenotazione"));
            } catch (ParseException e) {
                data = null;
                e.printStackTrace();
            }
            
            if(cliente == null || farmacia == null || data == null){
                model.addAttribute("error", true);
                System.out.println("Null objects");
                if(cliente == null)
                    System.out.println("Cliente bnn");
                else if(farmacia == null){
                    System.out.println("Farmacia dsds");
                }
                return "nuovaPrenotazione";
            }

            if(cliente.isBloccato() || !cliente.isVerificato()){
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
                        System.out.println(parameterName);
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
            cliente.addPrenotazione(prenotazione);
            model.addAttribute("success", true);
        }
        else{
            System.out.println("Request null");
            model.addAttribute("error", true);
        }
        return "nuovaPrenotazione";
    }
    

}