package it.farmabyte.app.model;

import java.util.ArrayList;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

@Getter
@Setter
@NoArgsConstructor
public class ClienteRegistrato {
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private String email;
    private Date dataDiNascita;
    private int effrazioni;
    private boolean verificato;
    private boolean bloccato;

    private ArrayList<Prenotazione> prenotazioni;

    public ClienteRegistrato(String nome, String cognome, String codiceFiscale, String email, Date dataDiNascita,
            int effrazioni, boolean verificato, boolean bloccato) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.effrazioni = effrazioni;
        this.verificato = verificato;
        this.bloccato = bloccato;

        prenotazioni = new ArrayList<>();
    }

    public void addPrenotazione(Prenotazione toAdd){
        prenotazioni.add(toAdd);
    }

    public Prenotazione[] elencaPrenotazioni(){
        //TODO: controllare che funzioni correttamente
        return prenotazioni.toArray(new Prenotazione[prenotazioni.size()]);
    }

}
