
/** 220515
 * Absolute Java
 * Chapter3 Programming Projects
 * 14. The file words.txt on the book’s website contains 87,314 words from the
 * English language. Write a program that reads through this file and finds the
 * word that has the most consecutive vowels. For example, the word "bedouin"
 * has three consecutive vowels.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Proj0314_consecutiveVowels {

    public static void main(String args[]) {

        Scanner fileIn = null;
        int lgthWord, i;
        int consecutiveV, consecutiveMost = 0;
        String word, consecutiveWord = "";
        char ch;

        try {
            fileIn = new Scanner(
                    new FileInputStream("../source/dictionaries/large"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }

        while (fileIn.hasNext()) {
            word = fileIn.next();
            word = word.toLowerCase();
            lgthWord = word.length();

            consecutiveV = 0;
            i = 0;
            while (i < lgthWord) {
                ch = word.charAt(i);
                if ((ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o')
                        || (ch == 'u')) {
                    consecutiveV++;
                    if (consecutiveV > consecutiveMost) {
                        consecutiveMost = consecutiveV;
                        consecutiveWord = word;
                    }
                } else {
                    consecutiveV = 0;
                }

                i++;
            }
        }

        fileIn.close();

        System.out.printf("The word \"%s\" has %d consecutive vowels: ",
                consecutiveWord, consecutiveMost);
    }
}

/* Sample dialogue
The word "queueing" has 5 consecutive vowels: 
 */
