
/** 220514
 * Absolute Java
 * Chapter3 Programming Projects
 * 12. Redo or do for the first time Programming Project 2.13 from Chapter 2,
 * but this time use a loop to read the names from the file. Your program should
 * also handle an arbitrary number of entries in the file instead of handling
 * only three entries. To do this, your program must check to see if there is
 * still data left to read (i.e., it has reached the end of the file). The
 * appropriate methods to read from a file are described in Section 2.3.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Proj0312_bodyWeight {

    public static final int FIRST_5FEET = 110;
    public static final int POUND_PER_INCH = 5;

    public static void main(String args[]) {
        String name;
        int feet, inch, idealWeight, totalInch;
        boolean hasNextLine;

        Scanner fileIn = null;  // Initialize fileIn to empty
        try {
            // Attempt to Open the file
            fileIn = new Scanner(new FileInputStream("Proj0312_bodyWeight.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }

        hasNextLine = fileIn.hasNextLine();
        while (hasNextLine) {   //                      **** hasNextLine ****
            name = fileIn.nextLine();
            feet = fileIn.nextInt();
            inch = fileIn.nextInt();
            fileIn.nextLine();  // Read newline left from nextInt()
            totalInch = feet * 12 + inch;
            idealWeight = FIRST_5FEET + (totalInch - 5 * 12) * POUND_PER_INCH;
            System.out.printf("%s (%d'%d\") ideal body weight is %d pounds. %n",
                    name, feet, inch, idealWeight);

            hasNextLine = fileIn.hasNextLine();
        }

        fileIn.close(); //                                  **** .close() ****
    }
}

/* Sample dialogue
Tom Atto (6'3") ideal body weight is 185 pounds. 
Eaton Wright (5'5") ideal body weight is 135 pounds. 
Cary Oki (5'11") ideal body weight is 165 pounds. 
 */
