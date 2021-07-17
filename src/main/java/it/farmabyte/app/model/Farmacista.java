package it.farmabyte.app.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

}
