
/** 220514
 * Absolute Java
 * Chapter3 Programming Projects
 * 11. You have three identical prizes to give away and a pool of 30 finalists.
 * The finalists are assigned numbers from 1 to 30. Write a program to randomly
 * select the numbers of three finalists to receive a prize. Make sure not to
 * pick the same number twice. For example, picking finalists 3, 15, 29 would be
 * valid but picking 3, 3, 31 would be invalid because finalist number 3 is
 * listed twice and 31 is not a valid finalist number.
 */
import java.util.Random;

public class Proj0311_randomlySelect {

    public static final int NO_OF_FINALISTS = 30;

    public static void main(String args[]) {

        Random randomGenerator = new Random(); //               **** Random ****
        int pick1st, pick2nd = 0, pick3rd = 0;

        pick1st = randomGenerator.nextInt(NO_OF_FINALISTS) + 1;
        System.out.println("Finalists: " + pick1st);

        do {
            pick2nd = randomGenerator.nextInt(NO_OF_FINALISTS) + 1;
        } while (pick2nd == pick1st);
        System.out.println("Finalists: " + pick2nd);

        do {
            pick3rd = randomGenerator.nextInt(NO_OF_FINALISTS) + 1;
        } while ((pick3rd == pick1st) || (pick3rd == pick2nd));
        System.out.println("Finalists: " + pick3rd);
    }
}

/* Sample dialogue
Finalists: 26
Finalists: 4
Finalists: 9
 */
