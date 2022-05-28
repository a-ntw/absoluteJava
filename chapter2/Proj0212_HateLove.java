
/** 220327
 * Absolute Java
 * Chapter2 Programming Projects
 * 12. Create a text file that contains the text "I hate programming!" Write a
 * program that reads in this line of text from the file and then the text with
 * the first occurrence of "hate" changed to "love". In this case, the program
 * would output "I love programming!" Your program should work with any line of
 * text that contains the word "hate", not just the example given in this
 * problem. If the word "hate" occurs more than once in the line, your program
 * should replace only the first occurrence of "hate".
 */
import java.io.FileInputStream;                 // **** FileInputStream ****
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Proj0212_HateLove {

    public static void main(String args[]) {
        Scanner fileIn = null;  // Initialize fileIn to empty
        try {
            // Attempt to Open the file
            fileIn = new Scanner(
                    new FileInputStream("Proj0212_HateLove.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }

        // read from file
        String textLine;
        System.out.println("Text left to read? "
                + fileIn.hasNextLine());
        textLine = fileIn.nextLine();
        System.out.println("This line read from file: ");
        System.out.println(textLine);
        System.out.println("Text left to read? "
                + fileIn.hasNextLine());
        fileIn.close();

        // convert hate to love
        //System.out.println("The line of text to be changed is:");
        //System.out.println(textLine);
        int position = textLine.indexOf("hate");
        String ending = textLine.substring(position + "hate".length());
        String newSentence = textLine.substring(0, position) + "love" + ending;
        System.out.println("I have rephased that line to read:");
        System.out.println(newSentence);

    }
}

/* Sample Dialogue
antw@Mac-mini chapter2 % java Proj0212_HateLove.java
Text left to read? true
This line read from file: 
I hate programming!
Text left to read? false
I have rephased that line to read:
I love programming!
*/
