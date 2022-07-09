
/* 220616 Absolute Java  Chapter6 Programming Projects.  Display 6.1 Display 6.2 */
import java.util.Scanner;

/**
 * An Array Used in a Program,The length Instance Variable
 */
public class ArrayOfScores {

    /**
     * Reads in 5 scores and shows how much each score differs from the higher
     * score.
     *
     * @param args main args
     */
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        double[] score = new double[5];
        int index;
        double max;

        System.out.println("Enter " + score.length + " scores:");
        //System.out.println("Enter 5 scores:");
        score[0] = keyboard.nextDouble();
        max = score[0];
        for (index = 1; index < 5; index++) {
            score[index] = keyboard.nextDouble();
            if (score[index] > max) {
                max = score[index];
            }
            //max is the largest of the values score[0],..., score[index].
        }

        System.out.println("The highest score is " + max);
        System.out.println("The scores are:");
        for (index = 0; index < score.length; index++) {
            System.out.println(score[index] + " differs from max by "
                    + (max - score[index]));
        }

    }

}

/* Sample dislogue
run:
Enter 5 scores:
80  99.9  75  100  85.5
The highest score is 100.0
The scores are:
80.0 differs from max by 20.0
99.9 differs from max by 0.09999999999999432
75.0 differs from max by 25.0
100.0 differs from max by 0.0
85.5 differs from max by 14.5
BUILD SUCCESSFUL (total time: 2 seconds)
 */
