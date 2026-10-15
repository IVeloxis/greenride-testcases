package org.alo.greenride;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Eine Verleihstation von GreenRide.
 *
 *   Station  1 -------- 0..*  Fahrrad
 */
public class Station {

    private String name;
    private String adresse;

    private List<Fahrrad> fahrraeder = new ArrayList<>();

    public Station(String name, String adresse) {
        this.name = name;
        this.adresse = adresse;
    }

    /**
     * Nimmt ein Fahrrad an dieser Station auf und traegt die Beziehung
     * in beiden Objekten ein.
     *
     * @param fahrrad das Fahrrad, das hier abgestellt wird
     * @throws IllegalArgumentException wenn fahrrad null ist
     */
    public void fahrradAufnehmen(Fahrrad fahrrad) {
        // Zusage aus @throws noch nicht umgesetzt - kommt nach dem Test (Red/Green)
        fahrraeder.add(fahrrad);
        fahrrad.setStation(this);
    }

    public void fahrraederAusgeben() {
        System.out.println("Fahrraeder an Station " + name + ":");
        for (Fahrrad f : fahrraeder) {
            System.out.println("  " + f.getKennung() + " (" + f.getModell() + ")");
        }
    }

    /**
     * Sucht an dieser Station das Fahrrad mit der angegebenen Kennung.
     *
     * @param kennung die Kennung vom Rahmen, z. B. "GR-014"
     * @return das gefundene Fahrrad; ein leeres Optional, wenn an dieser
     *         Station kein Fahrrad mit dieser Kennung steht
     * @throws IllegalArgumentException wenn kennung null oder leer ist
     */
    public Optional<Fahrrad> findeFahrrad(String kennung) {
        // Zusage aus @throws noch nicht umgesetzt - kommt nach dem Test (Red/Green)
        for (Fahrrad f : fahrraeder) {
            if (f.getKennung().equals(kennung)) {
                return Optional.of(f);
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * Sucht alle Fahrraeder eines Modells an dieser Station.
     *
     * @param modell das Modell, z. B. "City 3"
     * @return eine neue Liste mit allen passenden Fahrraedern;
     *         eine leere Liste, wenn keins passt - niemals null
     */
    public List<Fahrrad> findeFahrraederNachModell(String modell) {
        List<Fahrrad> treffer = new ArrayList<>();
        for (Fahrrad f : fahrraeder) {
            if (f.getModell().equals(modell)) {
                treffer.add(f);
            }
        }
        return treffer;
    }

    public String getName()    { return name; }
    public String getAdresse() { return adresse; }

    public List<Fahrrad> getFahrraeder() { return fahrraeder; }
}
