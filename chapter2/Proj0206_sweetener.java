
/** 220503
 * Absolute Java
 * Chapter2 Programming Projects
 * 6. (This is a better version of an exercise from Chapter 1.) A government
 * research lab has concluded that an artificial sweetener commonly used in diet
 * soda pop causes death in laboratory mice. A friend of yours is desperate to
 * lose weight but cannot give up soda pop. Your friend wants to know how much
 * diet soda pop it is possible to drink without dying as a result. Write a
 * program to supply the answer. The input to the program is the amount of
 * artificial sweetener needed to kill a mouse, the weight of the mouse, and the
 * desired weight of the dieter. Assume that diet soda contains 1/10th of 1%
 * artificial sweetener. Use a named constant for this fraction. You may want
 * to express the percent as the double value 0.001.
 */
import java.util.Scanner;

public class Proj0206_sweetener {

    public static final double CONTAINS_ARTIFICIAL_SWEETENER = 0.1 * 0.01;

    public static void main(String args[]) {

        double amountKillMouse; // gram
        int mouseWeight;        // gram
        int weightDesired;      // kg

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the amount of artificial sweetener needed to "
                + "kill a mouse (in gram): ");
        amountKillMouse = keyboard.nextDouble();

        System.out.println("Enter the weight of the mouse (in gram): ");
        mouseWeight = keyboard.nextInt();

        System.out.println("Enter the desired weight of the dieter: ");
        weightDesired = keyboard.nextInt();

        System.out.printf("Amount of sweetener to kill a %d gram mouse: %.2f gram.%n",
                mouseWeight, amountKillMouse);
        double desiredAmount = weightDesired * amountKillMouse / mouseWeight * 1000;
        System.out.printf("Amount of sweetener allow for a %d Kg friend: %.0f gram.%n",
                weightDesired, desiredAmount);
    }
}

/* Sample Dialogue
antw@Mac-mini chapter2 % java Proj0206_sweetener.java
Enter the amount of artificial sweetener needed to kill a mouse (in gram): 
0.34
Enter the weight of the mouse (in gram): 
20
Enter the desired weight of the dieter: 
70
Amount of sweetener to kill a 20 gram mouse: 0.34 gram.
Amount of sweetener allow for a 70 Kg friend: 1190 gram.
 */
