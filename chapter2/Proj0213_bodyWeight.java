
/** 220504
 * Absolute Java
 * Chapter2 Programming Projects
 * 13. (This is an extension of an exercise from Chapter 1.) A simple rule to
 * estimate your ideal body weight is to allow 110 pounds for the first 5 feet
 * of height and 5 pounds for each additional inch. Create the following text in
 * a text file. It contains the names and heights in feet and inches of Tom Atto
 * (6’3”), Eaton Wright (5’5”), and Cary Oki (5’11”):
 *
 * Write a program that reads the data in the file and outputs the full name and
 * ideal body weight for each person.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Proj0213_bodyWeight {

    public static final int FIRST_5FEET = 110;
    public static final int POUND_PER_INCH = 5;

    public static void main(String args[]) {

        String name1, name2, name3;
        int feet1, feet2, feet3, inch1, inch2, inch3;
        int idealWeight1, idealWeight2, idealWeight3, totalInch;

        Scanner fileIn = null;  // Initialize fileIn to empty
        try {
            // Attempt to Open the file
            fileIn = new Scanner(new FileInputStream("Proj0213_bodyWeight.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }

        // read from file
        System.out.println("Text left to read? " + fileIn.hasNextLine());
        name1 = fileIn.nextLine();
        feet1 = fileIn.nextInt();
        inch1 = fileIn.nextInt();
        fileIn.nextLine();  // Read newline left from nextInt()
        name2 = fileIn.nextLine();
        feet2 = fileIn.nextInt();
        inch2 = fileIn.nextInt();
        fileIn.nextLine();  // Read newline left from nextInt()
        name3 = fileIn.nextLine();
        feet3 = fileIn.nextInt();
        inch3 = fileIn.nextInt();
        fileIn.nextLine();  // Read newline left from nextInt()
        System.out.println("Text left to read? " + fileIn.hasNextLine());
        fileIn.close(); //                              **** .close() ****

        totalInch = feet1 * 12 + inch1;
        idealWeight1 = FIRST_5FEET + (totalInch - 5 * 12) * POUND_PER_INCH;
        totalInch = feet2 * 12 + inch2;
        idealWeight2 = FIRST_5FEET + (totalInch - 5 * 12) * POUND_PER_INCH;
        totalInch = feet3 * 12 + inch3;
        idealWeight3 = FIRST_5FEET + (totalInch - 5 * 12) * POUND_PER_INCH;

        System.out.printf("%s (%d'%d\") ideal body weight is %d pounds. %n",
                name1, feet1, inch1, idealWeight1);
        System.out.printf("%s (%d'%d\") ideal body weight is %d pounds. %n",
                name2, feet2, inch2, idealWeight2);
        System.out.printf("%s (%d'%d\") ideal body weight is %d pounds. %n",
                name3, feet3, inch3, idealWeight3);
    }
}

/* Sample Dialogue
Text left to read? true
Text left to read? false
Tom Atto (6'3") ideal body weight is 185 pounds. 
Eaton Wright (5'5") ideal body weight is 135 pounds. 
Cary Oki (5'11") ideal body weight is 165 pounds. 
 */
 /*
antw@Mac-mini chapter2 % cat Proj0213_bodyWeight.txt
Tom Atto
6
3
Eaton Wright
5
5
Cary Oki
5
11
 */
