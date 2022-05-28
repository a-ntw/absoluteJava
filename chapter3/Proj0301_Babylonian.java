
/** 220402
 * Absolute Java
 * Chapter3 Programming Projects
 * 1. (This is a version of Programming Project 2.1 from Chapter 2.) The
 * Babylonian algorithm to compute the square root of a positive number n is
 * as follows:
 *  1. Make a guess at the answer (you can pick n/2 as your initial guess).
 *  2. Computer = n / guess.
 *  3. Set guess = (guess +r) / 2.
 *  4. Go back to step 2 until the last two guess values are within 1% of each
 * other.
 * Write a program that inputs a double for n, iterates through the Babylonian
 * algorithm until the guess is within 1% of the previous guess and outputs the
 * answer as a double to two decimal places.
 * Your answer should be accurate even for large values of n.
 */
import java.util.Scanner;

/**
 *
 * @author antw
 */
public class Proj0301_Babylonian {

    public static void main(String args[]) {

        double n, guess, r, previous, percentage = 1.00;
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Pick a number: ");
        n = keyboard.nextDouble();

        // Make a guess
        guess = n / 2;

        while (percentage > 0.01) {
            previous = guess;

            // The Banylonian algorithm
            r = n / guess;
            guess = (guess + r) / 2;

            percentage = previous % guess / previous;
        }

        System.out.printf(
                "The Babylonian guess of %.2f within 1%% is %.2f. %n", n, guess
        );
    }
}

/* Sample Dialogue
antw@Mac-mini chapter3 % java Proj0301_Babylonian.java
Pick a number: 121
The Babylonian guess of 121.00 within 1% is 11.00.
 */
