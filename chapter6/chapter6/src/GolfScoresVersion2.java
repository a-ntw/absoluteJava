
/* 220618 Absolute Java  Chapter6 Programming Projects.  Display 6.6 */
import java.util.Scanner;

//Contrary to normal practice, this allows fractional scores, such as 71.5. 
//However, this makes it a better example for our purposes.
/**
 * Demonstrates using the class PartiallyFilledArray,
 *
 * @see PartiallyFilledArray.java
 */
public class GolfScoresVersion2 {

    public static final int MAX_NUMBER_SCORES = 10;

    /**
     * Shows differences between each of a list of golf scores and their
     * average.
     */
    public static void main(String[] args) {

        PartiallyFilledArray score
                = new PartiallyFilledArray(MAX_NUMBER_SCORES);

        System.out.println("This program reads golf scores and shows");
        System.out.println("how much each differs from the average.");
        System.out.println("Enter golf scores:");

        fillArray(score);
        showDifference(score);

    }

    /**
     * Reads values into the array a.
     * @return Returns the number of values placed in the array a.
     */
    public static void fillArray(PartiallyFilledArray a) {

        System.out.println("Enter up to " + a.getMaxCapacity()
                + " nonnegative numbers, one per line.");
        System.out.println("Mark the end of the list with a negative number.");
        Scanner keyboard = new Scanner(System.in);

        double next = keyboard.nextDouble();
        while ((next >= 0) && (!a.full())) {
            a.add(next);
            next = keyboard.nextDouble();
        }
        if (next >= 0) {
            System.out.println("Could only read in " + a.getMaxCapacity()
                    + " input values.");
        }
    }

    /**
     * Returns the average of numbers in the PartiallyFilledArray a.
     *
     * @return Returns the average of numbers a[0] through a[numberUsed-1].
     */
    public static double computeAverage(PartiallyFilledArray a) {
        double total = 0;
        for (int index = 0; index < a.getNumberOfElements(); index++) {
            total = total + a.getElement(index);
        }
        if (a.getNumberOfElements() > 0) {
            return (total / a.getNumberOfElements());
        } else {
            System.out.println("ERROR: Trying to average 0 numbers.");
            System.out.println("computeAverage returns 0.");
            return 0;
        }
    }

    /**
     * Gives screen output showing how much each of the elements in the
     * PartiallyFilledArray a differs from the average.
     */
    public static void showDifference(PartiallyFilledArray a) {
        double average = computeAverage(a);
        System.out.println("Average of the " + a.getNumberOfElements()
                + " scores = " + average);
        System.out.println("The scores are:");
        for (int index = 0; index < a.getNumberOfElements(); index++) {
            System.out.println(a.getElement(index) + " differs from average by "
                    + (a.getElement(index) - average));
        }
    }

    /**
     * Exec 06.13., Precondition: numberUsed <= argumentArray.length; the first
     * numberUsed indexed variables of argumentArray have values.
     *
     * @return Returns an array of length numberUsed whose ith element is
     * argumentArray[i] - adjustment.
     */
    public static double[] differenceArray(
            double[] argumentArray, int numberUsed, double adjustment) {
        double[] temp = new double[numberUsed];
        for (int i = 0; i < numberUsed; i++) {
            temp[i] = argumentArray[i] - adjustment;
        }
        return temp;
    }
}

/* Sample Dialogue
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
BUILD SUCCESSFUL (total time: 10 seconds)
 */
