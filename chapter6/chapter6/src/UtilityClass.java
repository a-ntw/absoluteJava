
/* 220619 Absolute Java  Chapter6 Programming Projects. Display 6.7 */
import java.util.Scanner;

/**
 * Method with a Variable Number of Parameters.
 */
public class UtilityClass {

    /**
     * Returns the largest of any number of {@code int} values.
     *
     * @param arg arg
     * @return Return
     */
    public static int max(int... arg) {
        if (arg.length == 0) {
            System.out.println("Fatal Error: maximum of zero values.");
            System.exit(0);
        }

        int largest = arg[0];
        for (int i = 1; i < arg.length; i++) {
            if (arg[i] > largest) {
                largest = arg[i];
            }
        }
        return largest;
    }

    public static void main(String[] args) {

        System.out.println("Enter scores for Tom, Dick, and Harriet:");
        Scanner keyboard = new Scanner(System.in);
        int tomsScore = keyboard.nextInt();
        int dicksScore = keyboard.nextInt();
        int harrietsScore = keyboard.nextInt();
        int highestScore = UtilityClass.max(tomsScore, dicksScore,
                harrietsScore);
        System.out.println("Highest score = " + highestScore);
    }

}

/* Sample dialogue
run:
Enter scores for Tom, Dick, and Harriet:
55 100 99
Highest score = 100
BUILD SUCCESSFUL (total time: 8 seconds)
*/