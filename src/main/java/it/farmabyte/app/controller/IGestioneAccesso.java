package it.farmabyte.app.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import it.farmabyte.app.model.ClienteRegistrato;

public interface IGestioneAccesso {
    public String verificaCredenziali(Model model, String error, String logout);
    public String registra(@ModelAttribute("userForm") ClienteRegistrato userForm, BindingResult bindingResult);
}
