package org.alo.greenride;

import java.util.Optional;
import org.junit.jupiter.api.Test;                                    // (1)

import static org.junit.jupiter.api.Assertions.assertEquals;          // (2)
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FahrradTest {
    @Test
    public void fahrradFindenTest() {
        // Arrange: create the test data
        Station station = new Station("Warschauer Strasse", "Warschauer Str. 12");
        Fahrrad fahrrad = new Fahrrad("GR-014", "Lastenrad", 24.00);

        station.fahrradAufnehmen(fahrrad);

        // Act: test the method
        Optional<Fahrrad> ergebnis = station.findeFahrrad("GR-014");

        // Assert: verify the result
        assertTrue(ergebnis.isPresent());
        assertEquals("GR-014", ergebnis.get().getKennung());
    }

    @Test
    public void fahrradNichtGefundenTest() {
        Station station = new Station("Warschauer Strasse", "Warschauer Str. 12");
        assertThrows(IllegalArgumentException.class, () -> station.findeFahrrad("GR-999"));
    }

    @Test
    public void fahrradEmpty() {
        Station station = new Station("Warschauer Strasse", "Warschauer Str. 12");
        assertThrows(IllegalArgumentException.class, () -> station.findeFahrrad(""));
    }

    @Test
    public void fahrradisNull() {
        Station station = new Station("Warschauer Strasse", "Warschauer Str. 12");
        assertThrows(IllegalArgumentException.class, () -> station.findeFahrrad(null));
    }

    @Test
    public void fahrradwrongwritten() {
        Station station = new Station("Warschauer Strasse", "Warschauer Str. 12");
        Fahrrad fahrrad = new Fahrrad("GR-014", "Lastenrad", 24.00);
        assertThrows(IllegalArgumentException.class, () -> station.findeFahrrad("gr-014"));
    }
}
