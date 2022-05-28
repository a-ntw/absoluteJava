
/** 2022-03-26
 * Absolute Java
 * Chapter1 Programming Projects
 * 1. Body Mass Index (BMI) helps in specifying the weight category a person
 * belongs to, depending on their body weight. BMI is estimated using the
 * following formula:
 * BMI = Weight in kilograms / (Height in meters)2
 *
 * Write a program that calculates and outputs the BMI. Assume various input
 * values wherever required.
 */

/**
 *
 * @author antw
 */
public class Proj0101_BMI {

    public static void main(String args[]) {
        int weight = 62;
        double height = 1.65;

        int BMI = (int) (weight / (height * height));
        System.out.println("BMI = " + BMI);
    }
}

/* Sample Dialogue
BMI = 22
*/
