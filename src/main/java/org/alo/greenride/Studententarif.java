package org.alo.greenride;

public class Studententarif implements Tarifmodell {
    public int berechneMietpreis(int tage) {
        if (tage > 7 || tage <= 0) {
            throw new IllegalArgumentException();
        }
        else {
            return tage * 8;
        }
    }
}
