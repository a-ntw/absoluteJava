
/** 220514
 * Absolute Java
 * Chapter3 Programming Projects
 * 9. Write a program that calculates the total grade for N classroom exercises
 * as a percentage. Use the DecimalFormat class to output the value as a percent.
 * The user should input the value for N followed by each of the N scores and
 * totals. Calculate the overall percentage (sum of the total points earned
 * divided by the total points possible) and output it using the DecimalFormat
 * class.
 */
import java.text.DecimalFormat;
import java.util.Scanner;

public class Proj0309_decimalFormat {

    public static void main(String args[]) {

        Scanner keyboard = new Scanner(System.in);
        DecimalFormat percent = new DecimalFormat("0.00%"); // **** to % ****

        int totalEx, index = 1;
        int scoreRecd, scoreSum = 0, pointTotal, pointSum = 0;
        String numeral;

        System.out.println("How many exercises to input?");
        totalEx = keyboard.nextInt();

        while (index <= totalEx) {
            System.out.printf("Score received for exercise %d: %n", index);
            scoreRecd = keyboard.nextInt();
            scoreSum += scoreRecd;

            System.out.printf("Total points possible for exercise %d: %n", index);
            pointTotal = keyboard.nextInt();
            pointSum += pointTotal;

            index++;
        }

        numeral = percent.format((float) scoreSum / pointSum);
        System.out.printf("Your total is %d out of %d, or %s.%n",
                scoreSum, pointSum, numeral);
    }
}

/* Sample dialogue
antw@Mac-mini chapter3 % java Proj0309_decimalFormat.java
How many exercises to input?
3
Score received for exercise 1: 
10
Total points possible for exercise 1: 
10
Score received for exercise 2: 
7
Total points possible for exercise 2: 
12
Score received for exercise 3: 
5
Total points possible for exercise 3: 
8
Your total is 22 out of 30, or 73.33%.
 */
