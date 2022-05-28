
/** 220501
 * Absolute Java
 * Chapter1 Programming Projects
 * 6. Write a program for calculating the simple interest on a loan when the
 * initial principal amount (princi_amnt) is $1000, the initial interest rate
 * (int_rate) is 5.0%, and the number of years (no_of_yrs) is 5. Use suitable
 * data types to declare these variables. Simple interest is calculated using
 * the following equation:
 *
 * Simple interest = (Principal amount * Interest rate * Number of years) / 100
 */
public class Proj0106_simpleInterest {

    public static void main(String args[]) {

        int princi_amnt, no_of_yrs, simple_int;
        float int_rate;

        princi_amnt = 1000; // $
        int_rate = 5;       // %
        no_of_yrs = 5;

        simple_int = (int) (princi_amnt * int_rate * no_of_yrs) / 100;

        System.out.println("Simple interest: $" + simple_int);
    }
}

/* Sample Dialogue
Simple interest: $250
 */
