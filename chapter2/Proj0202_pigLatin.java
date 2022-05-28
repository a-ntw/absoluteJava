
/** 220327
 * Absolute Java
 * Chapter2 Programming Projects
 * 2. Write a program that inputs two string variables, first and last, which
 * the user should enter with his or her name. First, convert both strings to
 * all lowercase. Your program should then cre- ate a new string that contains
 * the full name in pig latin with the first letter capitalized for the first
 * and last name. Use only the pig latin rule of moving the first letter to
 * the end of the word and adding “ay.” Output the pig latin name to the
 * screen. Use the substring and toUpperCase methods to construct the new name.
 *
 * For example, if the user inputs “Walt” for the first name and “Savitch” for
 * the last name, then the program should create a new string with the text
 * “Altway Avitchsay” and print it.
 */
import java.util.Scanner;

public class Proj0202_pigLatin {

    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("First name: ");
        String first = keyboard.next();
        System.out.print("Last name: ");
        String last = keyboard.next();

        first = first.toLowerCase(); //     **** .charAt(1) .substring(2) ****
        String letter = (first.charAt(1) + "").toUpperCase();
        first = letter + first.substring(2) + first.charAt(0) + "ay";

        last = last.toLowerCase();
        letter = (last.charAt(1) + "").toUpperCase();
        last = letter + last.substring(2) + last.charAt(0) + "ay";

        System.out.println("Pig latin name is " + first + " " + last);

    }
}

/* Sample Dialogue
antw@Mac-mini chapter2 % java Proj0202_pigLatin.java
First name: WALT
Last name: SAVITCH
Pig latin name is Altway Avitchsay
 */
