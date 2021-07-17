package it.farmabyte.app.controller;

import it.farmabyte.app.model.ClienteRegistrato;

public interface IGestioneAccesso {
    public boolean verificaCredenziali(String email, String password);
    public boolean registra(ClienteRegistrato cliente); //oggetto da inserire nel database
}
