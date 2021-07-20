package it.farmabyte.app.jspLogic;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.farmabyte.app.controller.IGestioneAccesso;
import it.farmabyte.app.model.ClienteRegistrato;
import it.farmabyte.app.model.Farmacista;
import it.farmabyte.app.security.UserValidator;
import it.farmabyte.app.services.ISecurityService;
import it.farmabyte.app.services.IUtenteService;

@SpringBootApplication
@Controller
@SessionAttributes("login")
public class GestioneAccessoLogic {

    @Autowired
    private ISecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private IGestioneAccesso gestioneAccesso;

    @Autowired
    private IUtenteService utenteService;

    @GetMapping("/registrazione")
    public String registrazione(Model model) {
        model.addAttribute("userForm", new ClienteRegistrato());

        return "registrazione";
    }

    @PostMapping("/registrazione")
    public String registrazione(@ModelAttribute("userForm") ClienteRegistrato userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registrazione";
        }
        gestioneAccesso.registra(userForm);

        securityService.autoLogin(userForm.getEmail(), userForm.getPasswordConfirm());

        return "redirect:/";
    }

    @GetMapping(value = "/login")
    public String verificaCredenziali(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping(value = "/farmacia/login")
    public String verificaCredenzialiFarmacista(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "loginFarmacia";
    }

    @GetMapping(value = "/farmacia")
    public String farmacia(Model model, Principal utente) {
        Farmacista farmacista = utenteService.findFarmacistaByUsername(utente.getName());
        if (farmacista != null) {
            model.addAttribute("nomeFarmacista", " " + farmacista.getNome());
        }
        return "homeFarmacia";
    }
}
