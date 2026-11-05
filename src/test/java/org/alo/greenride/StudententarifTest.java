package org.alo.greenride;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudententarifTest {
    @Test
    public void testTarif3Tage() {
        Studententarif tarif = new Studententarif();
        int Preis = tarif.berechneMietpreis(3);
        assertEquals(24, Preis);
    }
    @Test
    public void testTarif0Tage() {
        Studententarif tarif = new Studententarif();
        assertThrows(IllegalArgumentException.class, () -> tarif.berechneMietpreis(0));
    }

    @Test
    public void negativwirdabgelehnt() {
        Studententarif tarif = new Studententarif();
        assertThrows(IllegalArgumentException.class, () -> tarif.berechneMietpreis(-10));
    }

    @Test
    public void uebersieben() {
        Studententarif tarif = new Studententarif();
        assertThrows(IllegalArgumentException.class, () -> tarif.berechneMietpreis(10));
    }
}
