
/** 220503
 * Absolute Java
 * Chapter2 Programming Projects
 * 3. Write a program that
 * reads in two numbers typed on the keyboard and divides the first number by
 * the second number. The program should output the dividend, divisor, quotient,
 * and remainder on the screen.
 */
import java.util.Scanner;

public class Proj0203_quotientRemainder {

    public static void main(String args[]) {

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int first = keyboard.nextInt();
        System.out.print("Enter next number:");
        int next = keyboard.nextInt();

        System.out.println("Dividend:   " + first);
        System.out.println("Divisor:    " + next);
        System.out.println("Quotient:   " + first / next);
        System.out.println("Remainder:  " + first % next);
    }
}

/* Sample Dialogue
antw@Mac-mini chapter2 % java Proj0203_quotientRemainder.java
Enter first number: 55
Enter next number:9
Dividend:   55
Divisor:    9
Quotient:   6
Remainder:  1
 */
