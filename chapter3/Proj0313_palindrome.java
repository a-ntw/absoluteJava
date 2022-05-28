
/** 220403
 * Absolute Java
 * Chapter3 Programming Projects
 * 13. The file words.txt on the book’s website contains 87,314 words from the
 * English language. Write a program that reads through this file and finds the
 * longest word that is a palindrome.
 */
/**
 * Pseudocode.
 * Read and check text file
 * checkWord:
 * Do-while get the next word
 *  get length of words, must be > wordLength, to get the longest word
 *  DO-while to compare front and back char
 *      break if not the same
 *      if palindrome, length of word will be this word, and save word
 *  Replace if this length of new palindrome is longer.
 * back to checkWord:
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author antw
 */
public class Proj0313_palindrome {

    public static void main(String args[]) {

        String word, palindromeToPrint = " ", palindrome = "a";
        int wordLgth, wordCount = 0, palindromeWordLgth = 3;
        Scanner fileIn = null;

        try {
            fileIn = new Scanner(
                    new FileInputStream("Proj0313_palindrome.txt"));
            //new FileInputStream("../source/texts/whittier.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }

        //System.out.println("Text left to read? " + fileIn.hasNextLine());
        checkWord:
        while (fileIn.hasNext()) {
            word = fileIn.next().toLowerCase();
            wordLgth = word.length();
            wordCount++;

            if (wordLgth > palindromeWordLgth) {
                // remove punctualtion mark
                char c = word.charAt(wordLgth - 1);
                if (c < 'a') {
                    word = word.substring(0, wordLgth - 1);
                    wordLgth = word.length();
                }

                // check palindrome via comparing char
                int i = 0;
                while (i < wordLgth / 2) {
                    if (word.charAt(i) == word.charAt(wordLgth - (i + 1))) {
                        if ((wordLgth / 2 - i) <= 1) {
                            // copy if longest palindrome 
                            if (palindrome.length() < wordLgth) {
                                palindrome = word;
                                palindromeWordLgth = palindrome.length();
                                palindromeToPrint = word + " ";
                            } else if (palindrome.length() == wordLgth) {
                                palindromeToPrint += word + " ";
                            }
                        }
                    } else {
                        break;
                    }

                    i++;
                }
            }
        }

        fileIn.close();

        System.out.println("Total words count: " + wordCount);
        System.out.println("Longest palindrome word(s): " + palindromeToPrint);
    }
}

/* Sample Dialogue
Total words count: 12
Longest palindrome word(s): deified reviver racecar 
*/

/* Proj0313_palindrome.txt
deified, civic, radar, level, rotor, kayak, reviver, racecar, madam, and refer.
*/
