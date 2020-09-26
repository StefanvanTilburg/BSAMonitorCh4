package model;

/**
 * @author Stefan van Tilburg
 * <p>
 * Opdracht 3.3 BSA Monitor
 * <p>
 * Doel     Class Score. Logica om Vak Class te beoordelen op basis van een behaald cijfer, waarbij het te behalen
 *          punten voor het Vak verwerkt.
 */
public class Score {
    public static final double CESUUR_BSA = 5.0/6.0;
    public static int totaalScorePunten;
    public static int totaalBehaaldePunten;
    private Vak vak;
    private double cijfer;
    private int behaaldePunten;

    public Score(Vak vak, double cijfer) {
        this.vak = vak;
        this.cijfer = cijfer;
        this.behaaldePunten = (this.cijfer >= this.vak.getCesuur()) ? this.vak.getPunten() : 0;
        totaalBehaaldePunten += this.getBehaaldePunten();
        totaalScorePunten += this.getVak().getPunten();
    }

    public Vak getVak() {
        return vak;
    }

    public double getCijfer() {
        return cijfer;
    }

    public int getBehaaldePunten() {
        return behaaldePunten;
    }

    public void printScore() {
        System.out.printf("Vak/project: %-30s Cijfer: %4.1f Behaalde punten: %-2d\n",
                            this.getVak().getNaam(),
                            this.getCijfer(),
                            this.getBehaaldePunten());
    }

    public static void printStudieStatus() {
        System.out.printf("Totaal behaalde studiepunten: %d/%d\n", totaalBehaaldePunten, totaalScorePunten);

        if (totaalBehaaldePunten < (CESUUR_BSA * totaalScorePunten)) {
            System.out.println("PAS OP: je ligt op schema voor een negatief BSA!\n");
        }
    }
}
