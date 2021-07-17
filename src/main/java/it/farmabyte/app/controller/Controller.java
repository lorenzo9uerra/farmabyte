package it.farmabyte.app.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;

public class Controller {
    //private dbConnection

    private Writer logWriter;

    //Occhio che per scrivere qua servono i permessi di root
    private static final String DEFAULT_LOG_PATH = "/var/log/farmabyte/farmabyte.log";

    public Controller(String logPath){
        try {
            logWriter = apriLog(logPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Controller(){
        try {
            logWriter = apriLog(DEFAULT_LOG_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //private apriConnessione()

    private Writer apriLog(String logPath) throws IOException{
        return new FileWriter(new File(logPath));
    }

    protected void scriviLog(String operazione, String descrizione, String codiceFiscaleOperatore) throws IOException{
        logWriter.write("$ - " + LocalDateTime.now().toString() + " - " + operazione + " - " + descrizione + " - " + codiceFiscaleOperatore
                        + "\n");
    }

    //protected getConnection()
}
