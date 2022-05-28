
/** 220327
 * Absolute Java
 * Chapter2 Programming Projects
 * 1. The Babylonian algorithm to compute the square root of a positive
 * number n is as follows:
 *  1. Make a guess at the answer (you can pick n/2 as your initial guess).
 *  2. Computer = n /guess
 *  3. Set guess = (guess +r)/ 2
 *  4. Go back to step 2 for as many iterations as necessary. The more you
 *      repeat steps 2 and 3, the closer guess will become to the square root
 *      of n.
 * Write a program that inputs a double for n, iterates through the Babylonian
 * algorithm five times, and outputs the answer as a double to two decimal
 * places. Your answer will be most accurate for small values of n.
 */
import java.util.Scanner;

/**
 *
 * @author antw
 */
public class Proj0201_Babylonian {

    public static void main(String args[]) {

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a number: ");
        double n = keyboard.nextDouble();

        // Make a guess
        double guess = 2;
        // The Banylonian algorithm
        double r;
        r = n / guess;
        guess = (guess + r) / 2;
        r = n / guess;
        guess = (guess + r) / 2;
        r = n / guess;
        guess = (guess + r) / 2;
        r = n / guess;
        guess = (guess + r) / 2;
        r = n / guess;
        guess = (guess + r) / 2;

        System.out.printf("The answer is %.2f.%n", guess);

    }
}

/* Sample Dialogue
antw@Mac-mini chapter2 % java Proj0201_Babylonian.java
Enter a number: 25
The answer is 5.00.
*/
