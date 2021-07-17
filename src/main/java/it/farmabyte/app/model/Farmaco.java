package it.farmabyte.app.model;

import lombok.Getter;
import lombok.Setter;

public class Farmaco {
    @Getter @Setter private String id;
    @Getter @Setter private String nome;
    
    public Farmaco(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
}
