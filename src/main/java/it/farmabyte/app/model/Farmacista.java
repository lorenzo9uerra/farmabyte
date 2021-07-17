package it.farmabyte.app.model;

import lombok.Getter;
import lombok.Setter;

public class Farmacista {
    @Getter @Setter private String nome;
    @Getter @Setter private String cognome;
    @Getter @Setter private String codiceFiscale;
    @Getter @Setter private String email;
    @Getter @Setter private Farmacia farmacia;
    
    public Farmacista(String nome, String cognome, String codiceFiscale, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.email = email;
    }

}
