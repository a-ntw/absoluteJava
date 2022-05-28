
/** 220327
 * Absolute Java
 * Chapter2 Programming Projects
 * 8. Write a program that reads in a string containing three words separated
 * by commas and then outputs that string with each word in a different line.
 */
import java.util.Scanner;

public class Proj0208_commas {

    public static void main(String args[]) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter three words separate by commas: ");

        keyboard.useDelimiter(",");             // **** useDelimiter ****
        String word1, word2, word3;
        word1 = keyboard.next();
        word2 = keyboard.next();
        word3 = keyboard.nextLine();

        System.out.println("The three words are are:");
        System.out.println(word1);
        System.out.println(word2);
        System.out.println(word3.substring(1));
    }
}

/* Sample Dialogue
antw@Mac-mini chapter2 % java Proj0208_commas.java
Enter three words separate by commas: 
One, two,three
The three words are are:
One
 two
three
 */
