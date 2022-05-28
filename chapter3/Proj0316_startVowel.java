
/** 220516
 * Absolute Java
 * Chapter3 Programming Projects
 * 16. Suppose a text file contains the following verse from the Bible:
 * Let us fix our eyes on Jesus, the author and perfecter of our faith, who for
 * the joy set before him endured the cross, scorning its shame, and sat down at
 * the right hand of the throne of God.
 * Write a program that takes one of the five vowels (a, e, i, o, and u) as
 * input from the user and checks each word of the text file to determine
 * whether or not it starts with that vowel. Then, it should also display those
 * words on the screen, one word per line.
 */
import java.util.Scanner;

public class Proj0316_startVowel {

    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        char ch, leadingChar;
        int strLgth, position = 0, prePos;
        String verse, verseLowCase;

        verse = " Let us fix our eyes on Jesus, the author and perfecter "
                + "of our faith, who for\n the joy set before him endured the "
                + "cross, scorning its shame, and sat down at\n the right hand "
                + "of the throne of God.";
        System.out.println(verse);
        
        System.out.println("Input a vowel:");
        ch = keyboard.next()
                .toLowerCase()
                .charAt(0);
        if ((ch != 'a') && (ch != 'e') && (ch != 'i') && (ch != 'o') && (ch != 'u')) {
            System.exit(0);
        }
        
        System.out.println("Word starts with this vowel:");
        strLgth = verse.length();
        verse += " "; // add trailling delimited
        verseLowCase = verse.toLowerCase();
        do {
            prePos = position;
            leadingChar = verseLowCase.substring(position).charAt(0);

            position = verse.indexOf(" ", position);
            if (ch == leadingChar) {
                System.out.println(verse.substring(prePos, position));
            }
            
            position++; // adjust to next location for the loop
        } while (position <= strLgth);
    }
}

/*
antw@Mac-mini chapter3 % java Proj0316_startVowel.java
 Let us fix our eyes on Jesus, the author and perfecter of our faith, who for
 the joy set before him endured the cross, scorning its shame, and sat down at
 the right hand of the throne of God.
Input a vowel:
a
Word starts with this vowel:
author
and
and
at

 */
