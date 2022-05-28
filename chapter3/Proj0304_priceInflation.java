
/** 220507
 * Absolute Java
 * Chapter3 Programming Projects
 * 4. It is difficult to make a budget that spans several years, because prices
 * are not stable. If your company needs 200 pencils per year, you cannot simply
 * use this year’s price as the cost of pencils two years from now. Because of
 * inflation, the cost is likely to be higher than it is today. Write a program
 * to gauge the expected cost of an item in a specified number of years. The
 * program asks for the cost of the item, the number of years from now that the
 * item will be purchased, and the rate of inflation. The program then outputs
 * the estimated cost of the item after the specified period. Have the user
 * enter the inflation rate as a percentage, such as 5.6 (percent). Your program
 * should then convert the percent to a fraction, such as 0.056 and should use a
 * loop to estimate the price adjusted for inflation.
 */
import java.util.Scanner;

public class Proj0304_priceInflation {

    public static void main(String args[]) {

        Scanner keyboard = new Scanner(System.in);
        int years;
        double cost, rate;

        System.out.println("Enter the cost of the item ($): ");
        cost = keyboard.nextDouble();
        System.out.println("Enter the number of years from now: ");
        years = keyboard.nextInt();
        System.out.println("Enter the rate of inflation in percent (%): ");
        rate = keyboard.nextDouble();
        rate = rate / 100; // percent to a fration

        int count = 0;
        while (count < years) {
            cost = (cost * (1 + rate));
            count++;
        }
        System.out.printf("The price adjusted for inflation is $%.2f. %n", cost);

    }
}

/* Sample Dialogue
antw@Mac-mini chapter3 % java Proj0304_priceInflation.java
Enter the cost of the item ($): 
1.50
Enter the number of years from now: 
2
Enter the rate of inflation in percent (%): 
5.6
The price adjusted for inflation is $1.67.
 */
