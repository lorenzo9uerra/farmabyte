package it.farmabyte.app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;


public class ClienteRegistrato {
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private String email;
    private String password;
    private String passwordConfirm;
    private Set authorities;
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

    public ClienteRegistrato() {
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
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

    public String getUsername() {
        return email;
    }

    public void setUsername(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set authorities) {
        this.authorities = authorities;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public int getEffrazioni() {
        return effrazioni;
    }

    public void setEffrazioni(int effrazioni) {
        this.effrazioni = effrazioni;
    }

    public boolean isVerificato() {
        return verificato;
    }

    public void setVerificato(boolean verificato) {
        this.verificato = verificato;
    }

    public boolean isBloccato() {
        return bloccato;
    }

    public void setBloccato(boolean bloccato) {
        this.bloccato = bloccato;
    }

    public ArrayList<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public void setPrenotazioni(ArrayList<Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }

    public void addPrenotazione(Prenotazione toAdd){
        prenotazioni.add(toAdd);
    }

    public Prenotazione[] elencaPrenotazioni(){
        //TODO: controllare che funzioni correttamente
        return prenotazioni.toArray(new Prenotazione[prenotazioni.size()]);
    }

}
