package org.alo.greenride;

public class Kasse {
    public int kassieren(Tarifmodell tarif, int tage) {
        return tarif.berechneMietpreis(tage);
    }
}
