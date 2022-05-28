
/** 2022-03-26
 * Absolute Java
 * Chapter2 Self-Test Exercises
 * 15. Something could go wrong with the following code. Identify and fix the problem.
 *      Scanner keyboard = new Scanner(System.in);
 *      System.out.println("Enter your age.");
 *      int age = keyboard.nextInt();
 *      System.out.println("Enter your name.");
 *      String name = keyboard.nextLine();
 *      System.out.println(name + ",you are " + age + " years old.");
 */
import java.util.Scanner;

/**
 *
 * @author antw
 */
public class Excs0215_newLineChar {

    public static void main(String args[]) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter your age.");
        int age = keyboard.nextInt();
        keyboard.nextLine(); // to removed the newline char that left in the input buffer
        System.out.println("Enter your name.");
        String name = keyboard.nextLine();
        System.out.println(name + ", you are " + age + " years old.");

    }
}

/* Sample Dialogue
antw@Mac-mini chapter2 % java Excs0215_newLineChar.java
Enter your age.
59
Enter your name.
Alvin
Alvin, you are 59 years old.
*/
