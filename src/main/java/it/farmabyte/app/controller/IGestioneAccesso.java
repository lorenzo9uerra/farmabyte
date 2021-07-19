package it.farmabyte.app.controller;

import it.farmabyte.app.model.ClienteRegistrato;

public interface IGestioneAccesso {
    // public void verificaCredenziali(); non viene utilizzato perché viene utilizzato quello di Spring
    public void registra(ClienteRegistrato cliente);
}
