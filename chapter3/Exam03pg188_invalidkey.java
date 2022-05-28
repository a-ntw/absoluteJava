
/** 220330
 * Absolute Java
 * Chapter 3
 * .
 * An even better solution is to declare a boolean variable to control
 * the do-while loop.
 */
import java.util.Scanner;

/**
 *
 * @author antw
 */
public class Exam03pg188_invalidkey {

    public static void main(String args[]) {

        String s;
        char c;
        Scanner keyboard = new Scanner(System.in);
        boolean invalidKey;
        do {
            System.out.println("Enter 'A' for option A "
                    + "or 'B' for option B.");
            s = keyboard.next();
            s = s.toLowerCase();
            c = s.charAt(0);
            if (c == 'a') {
                invalidKey = false;
            } else if (c == 'b') {
                invalidKey = false;
            } else {
                invalidKey = true; //       **** boolean to control loop ****
            }
        } while (invalidKey);
    }
}

/* Sample Dialogue
antw@Mac-mini chapter3 % java Exam03pg188_invalidkey.java
Enter 'A' for option A or 'B' for option B.
c
Enter 'A' for option A or 'B' for option B.
b
antw@Mac-mini chapter3 % 
*/
