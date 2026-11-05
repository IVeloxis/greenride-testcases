package org.alo.greenride;

import org.junit.jupiter.api.Test;                                    // (1)

import static org.junit.jupiter.api.Assertions.assertEquals;          // (2)
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StandardtarifTest {
    @Test
    public void testTarif3Tage() {
        Standardtarif tarif = new Standardtarif();
        int Preis = tarif.berechneMietpreis(3);
        assertEquals(27, Preis);
    }
    @Test
    public void testTarif0Tage() {
        Standardtarif tarif = new Standardtarif();
        assertThrows(IllegalArgumentException.class, () -> tarif.berechneMietpreis(0));
    }

    @Test
    public void negativwirdabgelehnt() {
        Standardtarif tarif = new Standardtarif();
        assertThrows(IllegalArgumentException.class, () -> tarif.berechneMietpreis(-10));
    }

    @Test
    public void uebersieben() {
        Standardtarif tarif = new Standardtarif();
        assertThrows(IllegalArgumentException.class, () -> tarif.berechneMietpreis(10));
    }

    @Test
    public void LastenradHelm() {
        Standardtarif tarif = new Standardtarif();
        int SGebuehr = tarif.berechneStartgebuehr(true, true);
        assertEquals(5, SGebuehr);
    }

    @Test
    public void Lastenrad() {
        Standardtarif tarif = new Standardtarif();
        int SGebuehr = tarif.berechneStartgebuehr(true, false);
        assertEquals(4, SGebuehr);
    }

    @Test
    public void Helm() {
        Standardtarif tarif = new Standardtarif();
        int SGebuehr = tarif.berechneStartgebuehr(false, true);
        assertEquals(3, SGebuehr);
    }

    @Test
    public void LastenradHelmNegativ() {
        Standardtarif tarif = new Standardtarif();
        int SGebuehr = tarif.berechneStartgebuehr(false, false);
        assertEquals(2, SGebuehr);
    }
}
