package it.farmabyte.app.jspLogic;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class NPFormBody {
    private String farmacia;
    private Date data;
    private Map<String, Integer> farmaci;
    
    public NPFormBody(String farmacia, Date data, Map<String, Integer> farmaci) {
        this.farmacia = farmacia;
        this.data = data;
        this.farmaci = farmaci;
    }

    public NPFormBody(){
        this.farmaci = new HashMap<>();
    }

    public String getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(String farmacia) {
        this.farmacia = farmacia;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Map<String, Integer> getFarmaci() {
        return farmaci;
    }

    public void setFarmaci(Map<String, Integer> farmaci) {
        this.farmaci = farmaci;
    }

}
