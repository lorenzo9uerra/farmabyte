package it.farmabyte.app.model;

import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;


@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class Farmacista {
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private String email;
    private Farmacia farmacia;
    
    public Farmacista(String nome, String cognome, String codiceFiscale, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

}
