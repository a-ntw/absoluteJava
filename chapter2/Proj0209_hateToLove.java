
/** 220504
 * Absolute Java
 * Chapter2 Programming Projects
 * 9. (This is a better version of an exercise from Chapter 1.) Write a program
 * that reads in a line of text and then outputs that line of text with the
 * first occurrence of "hate" changed to "love".
 *
 * You can assume that the word "hate" occurs in the input. If the word "hate"
 * occurs more than once in the line, your program should replace only the first
 * occurrence of "hate".
 */
import java.util.Scanner;

public class Proj0209_hateToLove {

    public static void main(String args[]) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a line of text.");
        String sentence = keyboard.nextLine();

        int position = sentence.indexOf("hate"); //         **** .indexOf ****
        String ending = sentence.substring(position + "hate".length());
        sentence = sentence.substring(0, position) + "love" + ending;

        System.out.println("I have rephased that line to read:");
        System.out.println(sentence);
    }
}

/* Sample Dialogue
antw@Mac-mini chapter2 % java Proj0209_hateToLove.java
Enter a line of text.
I hate you. I hate you.
I have rephased that line to readf:
I love you. I hate you.
 */
