
/** 220501
 * Absolute Java
 * Chapter1 Programming Projects
 * 4. A government research lab has concluded that an artificial sweetener
 * commonly used in diet soda pop will cause death in laboratory mice. A friend
 * of yours is desperate to lose weight but cannot give up soda pop. Your friend
 * wants to know how much diet soda pop it is possible to drink without dying as
 * a result. Write a program to supply the answer. The program has no input but
 * does have defined constants for the following items: the amount of artificial
 * sweetener needed to kill a mouse, the weight of the mouse, the starting
 * weight of the dieter, and  the desired weight of the dieter.
 * To ensure the safety of your friend, be sure the program uses the weight at
 * which the dieter will stop dieting, rather than the dieter’s current weight,
 * to calculate how much soda pop the dieter can safely drink. You may use any
 * reasonable values for these defined constants.
 * Assume that diet soda contains 1/10th of 1% artificial sweetener. Use another
 * named constant for this fraction. You may want to express the percent as the
 * double value 0.001. (If your program turns out not to use a defined constant,
 * you may remove that defined constant from your program.)
 */
public class Proj0104_sweetener {

    public static final double CONTAINS_ARTIFICIAL_SWEETENER = 0.1 * 0.01;

    public static void main(String[] args) {

        double amountKillMouse;
        double mouseWeight = 0.020; // assume 20 gram 
        int weightStart;
        int weightDesired = 70;     // assume 70 kg

        int dietSoda = 340;         // assume 340 gram
        amountKillMouse = dietSoda * CONTAINS_ARTIFICIAL_SWEETENER; // gram

        System.out.println("Amount of sweetener for a " + mouseWeight
                + " Kg mouse: " + amountKillMouse + " gram.");

        System.out.println("Amount of sweetener for a " + weightDesired
                + " Kg friend: " + (weightDesired * amountKillMouse
                / mouseWeight) + " gram.");

        System.out.println("Soda pop the dieter can safely drink: "
                + (int) (weightDesired * amountKillMouse / mouseWeight
                / amountKillMouse) + " cans.");
    }
}

/* Sample Dialogue
Amount of sweetener for a 0.02 Kg mouse: 0.34 gram.
Amount of sweetener for a 70 Kg friend: 1190.0 gram.
Soda pop the dieter can safely drink: 3499 cans.
 */
