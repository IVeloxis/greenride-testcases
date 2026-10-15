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
        assertThrows(IllegalArgumentException.class, () -> tarif.berechneMietpreis(0));
    }

    @Test
    public void negativwirdabgelehnt() {
        Tarif tarif = new Tarif();
        assertThrows(IllegalArgumentException.class, () -> tarif.berechneMietpreis(-10));
    }

    @Test
    public void uebersieben() {
        Tarif tarif = new Tarif();
        assertThrows(IllegalArgumentException.class, () -> tarif.berechneMietpreis(10));
    }

    @Test
    public void LastenradHelm() {
        Tarif tarif = new Tarif();
        int SGebuehr = tarif.berechneStartgebuehr(true, true);
        assertEquals(5, SGebuehr);
    }

    @Test
    public void Lastenrad() {
        Tarif tarif = new Tarif();
        int SGebuehr = tarif.berechneStartgebuehr(true, false);
        assertEquals(4, SGebuehr);
    }

    @Test
    public void Helm() {
        Tarif tarif = new Tarif();
        int SGebuehr = tarif.berechneStartgebuehr(false, true);
        assertEquals(3, SGebuehr);
    }

    @Test
    public void LastenradHelmNegativ() {
        Tarif tarif = new Tarif();
        int SGebuehr = tarif.berechneStartgebuehr(false, false);
        assertEquals(2, SGebuehr);
    }
}
