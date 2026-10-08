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
        if (tage >= 3 && tage <= 7) {
            return tage * 9;
        }
        else if (tage >= 1 && tage <= 2) {
            return tage * 10;
        }
        return 0;
    }
}
