package org.alo.greenride;

import org.junit.jupiter.api.Test;                                    // (1)

import static org.junit.jupiter.api.Assertions.assertEquals;          // (2)
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TarifTest {
    @Test
    public void testTarif3Tage() {
        Tarif tarif = new Tarif();
        int Preis = tarif.berechneMietpreis(3);
        assertEquals(27, Preis);
    }
    @Test
    public void testTarif0Tage() {
        Tarif tarif = new Tarif();
        int Preis = tarif.berechneMietpreis(0);
        assertEquals(0, Preis);
    }

    @Test
    public void negativwirdabgelehnt() {
        Tarif tarif = new Tarif();
        int Preis = tarif.berechneMietpreis(-10);
        assertEquals(0, Preis);
    }

    @Test
    public void uebersieben() {
        Tarif tarif = new Tarif();
        int Preis = tarif.berechneMietpreis(10);
        assertEquals(0, Preis);
    }
}
