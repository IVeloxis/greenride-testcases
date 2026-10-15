package org.alo.greenride;

/**
 * Der Mehrtagestarif von GreenRide (gilt ab 01.11.).
 */
public class Tarif {

    /**
     * Berechnet den Mietpreis fuer eine Ausleihe ueber mehrere Tage.
     * Ein Tag kostet 10 Euro. Ab 3 Tagen kostet jeder Tag nur 9 Euro.
     * Ausgeliehen wird mindestens 1 und hoechstens 7 Tage.
     *
     * @param tage die Anzahl der Tage
     * @return der Mietpreis in ganzen Euro
     * @throws IllegalArgumentException wenn tage kleiner als 1 oder groesser als 7 ist
     */
    public int berechneMietpreis(int tage) {
        // Guard
        if (tage > 7 || tage <= 0) {
            throw new IllegalArgumentException();
        }
        else {
            if (tage >= 3) return tage * 9;
            if (tage <= 2) return tage * 10;
        }
        return 0;
    }

    /**
     * Berechnet die Startgebuehr einer Ausleihe.
     * Grundgebuehr 2 Euro. Ein Lastenrad kostet das Doppelte.
     * Wer einen Helm dazu nimmt, zahlt 1 Euro extra.
     *
     * @param lastenrad true, wenn ein Lastenrad ausgeliehen wird
     * @param mitHelm   true, wenn ein Helm dazu ausgeliehen wird
     * @return die Startgebuehr in ganzen Euro
     */
    public int berechneStartgebuehr(boolean lastenrad, boolean mitHelm) {
        int preis = 2;
        if (lastenrad) {
            preis = preis * 2;
        }
        if (mitHelm) {
            preis = preis + 1;
        }
        return preis;
    }

}
