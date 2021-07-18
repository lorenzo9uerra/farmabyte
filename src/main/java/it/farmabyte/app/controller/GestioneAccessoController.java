
package it.farmabyte.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.farmabyte.app.model.ClienteRegistrato;
import it.farmabyte.app.security.UserValidator;
import it.farmabyte.app.services.ISecurityService;
import it.farmabyte.app.services.UtenteService;

@SpringBootApplication
@Controller
public class GestioneAccessoController implements IGestioneAccesso{
    @Autowired
    private UtenteService userService;

    @Autowired
    private ISecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registrazione")
    public String registrazione(Model model) {
        model.addAttribute("userForm", new ClienteRegistrato());

        return "registrazione";
    }

    @PostMapping("/registrazione")
    public String registra(@ModelAttribute("userForm") ClienteRegistrato userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registrazione";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getEmail(), userForm.getPasswordConfirm());

        return "redirect:/";
    }

    @GetMapping("/login")
    public String verificaCredenziali(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
}
            