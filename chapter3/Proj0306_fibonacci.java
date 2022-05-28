
/** 220512
 * Absolute Java
 * Chapter3 Programming Projects
 * 6. The Fibonacci numbers Fn are defined as follows: F0 is 1, F1 is 1, and
 *      Fi+2 = Fi + Fi+1
 * i = 0, 1, 2, . . . . In other words, each number is the sum of the previous
 * two numbers. The first few Fibonacci numbers are 1, 1, 2, 3, 5, and 8.
 * One place where these numbers occur is as certain population growth rates.
 * If a population has no deaths, then the series shows the size of the
 * population after each time period. It takes an organism two time periods to
 * mature to reproducing age, and then the organism reproduces once every time
 * period. The formula applies most straightforwardly to asexual reproduction at
 * a rate of one offspring per time period.
 * In any event, the green crud population grows at this rate and has a time
 * period of five days. Hence, if a green crud population starts out as 10
 * pounds of crud, then in 5 days, there is still 10 pounds of crud; in 10 days,
 * there is 20 pounds of crud; in 15 days, 30 pounds; in 20 days, 50 pounds; and
 * so forth.
 * Write a program that takes both the initial size of a green crud population
 * (in pounds) and a number of days as input and outputs the number of pounds of
 * green crud after that many days. Assume that the population size is the same
 * for four days and then increases every fifth day. Your program should allow
 * the user to repeat this calculation as often as desired.
 */
import java.util.Scanner;

public class Proj0306_fibonacci {

    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        int size, daysInput, i, num;
        long fi, fi1, fi2;
        String cont;

        boolean toContinue;
        do {
            System.out.println("\nTo calculate the outputs the number of pounds "
                    + "of green crud after that many days.");
            System.out.println("Input initial size (in pounds): ");
            size = keyboard.nextInt();
            System.out.println("Input number of days:");
            daysInput = keyboard.nextInt();
            System.out.println("Assume that the size increases every fifth day.");
            int daysSame = 5;

            // Fibonacci
            fi1 = 0;
            fi2 = size;
            i = 0;
            num = daysInput / daysSame;
            do {
                //System.out.println("fi:" + fi + "  fi1:" + fi1 + "  fi2:" + fi2);
                fi = fi1;
                fi1 = fi2;
                fi2 = fi + fi1;
                i++;
            } while (i < num);
            //System.out.println("fi:" + fi + "  fi1:" + fi1 + "  fi2:" + fi2);

            System.out.printf("Number of pounds of green crud output: %d %n%n", fi2);

            System.out.println("To continue: 'Y'?"); // **** toContinue loop ****
            cont = keyboard.next();
            toContinue = (cont.equalsIgnoreCase("Y"));
        } while (toContinue);
    }
}

/* Sample Dialogue
antw@Mac-mini chapter3 % java Proj0306_fibonacci.java

To calculate the outputs the number of pounds of green crud after that many days.
Input initial size (in pounds): 
10
Input number of days:
20
Assume that the size increases every fifth day.
Number of pounds of green crud output: 50 

To continue: 'Y'?
n
 */
