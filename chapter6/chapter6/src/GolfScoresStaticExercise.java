
/* 220619 Absolute Java  Chapter6 Programming Projects. Exec06.15 */
import java.util.Scanner;

/**
 * Rewrite the class {@code GolfScores} from Display 6.4 making the array of
 * scores a static variable. Also, make the {@code int} variable
 * {@code numberUsed} a static variable. Start with Display 6.4, not with the
 * answer to Self-Test Exercise 14. Hint: All, or at least most, methods will
 * have no parameters.
 */
public class GolfScoresStaticExercise {

    public static final int MAX_NUMBER_SCORES = 10;
    private static double[] score = new double[MAX_NUMBER_SCORES];
    private static int numberUsed = 0;

    /**
     * Shows differences between each of a list of golf scores and their
     * average.
     *
     * @param args args
     */
    public static void main(String[] args) {
        System.out.println("This program reads golf scores and shows");
        System.out.println("how much each differs from the average.");
        System.out.println("Enter golf scores:");
        fillArray();
        showDifference();
    }

    /**
     * Reads values into the array score.
     */
    public static void fillArray() {

        System.out.println("Enter up to " + score.length
                + " nonnegative numbers.");
        System.out.println("Mark the end of the list with a negative number.");
        Scanner keyboard = new Scanner(System.in);

        double next;
        int index = 0;
        next = keyboard.nextDouble();
        while ((next >= 0) && (index < score.length)) {
            score[index] = next;
            index++;

            next = keyboard.nextDouble();
            ////index is the number of array indexed variables used so far.
        }
        //index is the total number of array indexed variables used.
        if (next >= 0) {
            System.out.println("Could only read in " + score.length
                    + " input values.");
        }
        numberUsed = index;
    }

    /**
     * Returns the average of numbers score[0] through score[numberUsed-1].
     * <p>
     * Precondition: numberUsed <<>less= score.length. score[0] through
     * score[numberUsed-1] have values.
     * <p>
     * Returns the average of numbers score[0] through score[numberUsed-1].
     */
    public static double computeAverage() {
        double total = 0;
        for (int index = 0; index < numberUsed; index++) {
            total = total + score[index];
        }
        if (numberUsed > 0) {
            return (total / numberUsed);
        } else {
            System.out.println("ERROR: Trying to average 0 numbers.");
            System.out.println("computeAverage returns 0.");
            return 0;
        }
    }

    /**
     * Gives screen output showing how much each of the first numberUsed
     * elements of the array a differ from their average.
     * <p>
     * Precondition: numberUsed <<>= score.length. The first numberUsed indexed
     * variables of score have values.
     * <p>
     * Postcondition: Gives screen output showing how much each of the first
     * numberUsed elements of the array a differ from their average.
     */
    public static void showDifference() {
        double average = computeAverage();
        System.out.println("Average of the " + numberUsed
                + " scores = " + average);
        System.out.println("The scores are:");
        for (int index = 0; index < numberUsed; index++) {
            System.out.println(score[index] + " differs from average by "
                    + (score[index] - average));
        }
    }
}

/* Sample dialogue
run:
This program reads golf scores and shows
how much each differs from the average.
Enter golf scores:
Enter up to 10 nonnegative numbers.
Mark the end of the list with a negative number.
69 74 68 -1
Average of the 3 scores = 70.33333333333333
The scores are:
69.0 differs from average by -1.3333333333333286
74.0 differs from average by 3.6666666666666714
68.0 differs from average by -2.3333333333333286
BUILD SUCCESSFUL (total time: 13 seconds)
*/