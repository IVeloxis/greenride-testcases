package org.alo.greenride;

import org.junit.jupiter.api.Test;                                    // (1)

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;          // (2)
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class fahrradAufnehmenTest {
    @Test
    public void dasselbenochmal() {
        Station warschauer = new Station("Warschauer Strasse", "Warschauer Str. 12");

        warschauer.fahrradAufnehmen(new Fahrrad("GR-001", "City 3", 12.00));
        warschauer.fahrradAufnehmen(new Fahrrad("GR-001", "City 3", 12.00));

        //Optional<Fahrrad> ergebnis = warschauer.findeFahrrad("GR-001");

        //assertTrue(ergebnis.isPresent());
        //assertEquals("GR-001", ergebnis.get().getKennung());

        //assertEquals(1, warschauer.getAnzahlFahrraeder());
    }
}
