
/** 220501
 * Absolute Java
 * Chapter1 Programming Projects
 * 9. A simple rule to estimate your ideal body weight is to allow 110 pounds
 * for the first 5 feet of height and 5 pounds for each additional inch. Write
 * a program with a variable for the height of a person in feet and another
 * variable for the additional inches. Assume the person is at least 5 feet
 * tall. For example, a person that is 6 feet and 3 inches tall would be
 * represented with a variable that stores the number 6 and another variable
 * that stores the number 3. Based on these values, calculate and output the
 * ideal body weight.
 */
public class Proj0109_bodyWeight {

    public static final int FIRST_5FEET = 110;
    public static final int POUND_PER_INCH = 5;

    public static void main(String args[]) {

        int totalInch, heightInFeet, additionInch, bodyWeight;

        heightInFeet = 6;
        additionInch = 3;

        totalInch = heightInFeet * 12 + additionInch;
        bodyWeight = FIRST_5FEET + (totalInch - 5 * 12) * POUND_PER_INCH;

        System.out.println("Ideal body weight: " + bodyWeight + " pounds");
    }
}

/* Sample Dialogue
Ideal body weight: 185 pounds
 */
