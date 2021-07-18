package it.farmabyte.app.controller;

import it.farmabyte.app.model.ClienteRegistrato;

public interface IUtenti {
    public ClienteRegistrato[] getElencoUtenti();
    public ClienteRegistrato ricercaUtente(String email);
    public boolean confermaUtente(String email);
    public boolean bloccaUtente(String email);
    public boolean sbloccaUtente(String email);
}
