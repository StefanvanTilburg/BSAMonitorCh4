package controller;

import model.Score;
import model.Vak;

import java.util.Scanner;

/**
 * @author Stefan van Tilburg
 * <p>
 * Opdracht 3.3 BSA Monitor
 * <p>
 * Doel     Main voor BSA monitor applicatie. Oordeel cijfers van studenten met behulp van OOP applicatie.
 */
// TODO Zou de input check voor Cijfer verplaatst kunnen worden naar Vak setter setCijfer?
public class BSALauncher {
    public static void main(String[] args) {
        final String[] VAK_OMSCHRIJVING = {"Project Fasten Your Seatbelts", "Programming",
                                "Databases", "Personal Skills", "Project Skills", "OOP 1", "User Interaction"};
        final int[] VAK_STUDIEPUNTEN = {12,3,3,2,2,3,3};
        final double VAK_CESUUR = 5.5;
        final double CIJFER_MAXIMUM = 10.0;
        final double CIJFER_MINIMUM = 1.0;

        Vak[] vakken = new Vak[VAK_OMSCHRIJVING.length];
        for (int vak = 0; vak < vakken.length; vak++) {
            vakken[vak] = new Vak(VAK_OMSCHRIJVING[vak], VAK_STUDIEPUNTEN[vak], VAK_CESUUR);
        }

        Score[] scores = new Score[vakken.length];
        Scanner keyboard = new Scanner(System.in);
        double inputCijfer;

        System.out.println("Voer behaalde cijfers in:");
        for (int vak = 0; vak < vakken.length; vak++) {
            System.out.printf("%s: ", vakken[vak].getNaam());
            inputCijfer = keyboard.nextDouble();
            while (inputCijfer < CIJFER_MINIMUM || inputCijfer > CIJFER_MAXIMUM) {
                System.out.printf("Geef een cijfer tussen %.1f en %.1f: ", CIJFER_MINIMUM, CIJFER_MAXIMUM);
                inputCijfer = keyboard.nextDouble();
            }
            scores[vak] = new Score(vakken[vak], inputCijfer);
        }

        System.out.println();
        for (Score score : scores) {
            score.printScore();
        }

        System.out.println();
        Score.printStudieStatus();
    }
}
