
/** 220503
 * Absolute Java
 * Chapter2 Programming Projects
 * 7. Write a program that determines the change to be dispensed from a vending
 * machine. An item in the machine can cost between 25 cents and 1 dollar, in
 * 5-cent increments (25, 30, 35, . . . , 90, 95, or 100), and the machine
 * accepts only a single dollar bill to pay for the item.
 *
 * A penny is worth 1 cent. A nickel is worth 5 cents. A dime is worth 10 cents.
 * A quarter is worth 25 cents.
 */
import java.util.Scanner;

public class Proj0207_coinsDispense {

    public static void main(String args[]) {

        int itemPrice, quarter, dime, nickel;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter price of item");
        System.out.println("(from 25 cents to a dollar, in 5-cent increments):");
        itemPrice = keyboard.nextInt(); // cents

        int change = 100 - itemPrice;
        quarter = change / 25;
        dime = (change -= quarter * 25) % 25 / 10;
        nickel = change % 10 / 5;

        System.out.printf("You bought an item for %d cents and gave me a dollar"
                + ",%n", itemPrice);
        System.out.println("so your change is");
        System.out.println(quarter + " quarters,");
        System.out.println(dime + " dimes, and");
        System.out.println(nickel + " nickels.");
    }
}

/* Sample Dialogue
antw@Mac-mini chapter2 % java Proj0207_coinsDispense.java
Enter price of item
(from 25 cents to a dollar, in 5-cent increments):
45
You bought an item for 45 cents and gave me a dollar,
so your change is
2 quarters,
0 dimes, and
1 nickels.
 */
