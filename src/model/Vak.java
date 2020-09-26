package model;

/**
 * @author Stefan van Tilburg
 * <p>
 * Opdracht
 * <p>
 * Doel
 */
public class Vak {
    private String naam;
    private int punten;
    private double cesuur;  // cesuur is beoordelingsgrens tussen geslaagd / niet geslaagd

    public Vak(String naam, int punten, double cesuur) {
        this.naam = naam;
        this.punten = punten;
        this.cesuur = cesuur;
    }

    public String getNaam() {
        return naam;
    }

    public int getPunten() {
        return punten;
    }

    public double getCesuur() {
        return cesuur;
    }
}
