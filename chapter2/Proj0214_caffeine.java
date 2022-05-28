
/** 220505
 * Absolute Java
 * Chapter2 Programming Projects
 * 14. From Programming Project 10 in Chapter 1, scientists estimate that
 * roughly 10 grams of caffeine consumed at one time is a lethal overdose. Write
 * two programs to compute how many drinks it takes to kill a person.
 * The first program should input the name of the drink and the number of
 * milligrams of caffeine in the drink. It should then output the drink name and
 * the number of drinks it takes to kill a person. For example, if the user
 * enters “coffee” and “160”, then the program should output “It will take
 * approximately 62.5 drinks of coffee to kill a person from caffeine.”
 * The second program should perform the same calculation as the first program,
 * but read the name of the drink and the number of milligrams of caffeine in
 * the drink from a file named drink.txt and output the answer to the console.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Proj0214_caffeine {

    public static final int OVERDOSE = 10; // grams of caffeine

    public static void main(String args[]) {
        String drinkName;
        int caffeine;
        double cups;
        Scanner fileIn, keyboard = new Scanner(System.in);

        // Input from console
        System.out.println("Input the name of the drink:");
        drinkName = keyboard.nextLine();
        System.out.println("Input the milligrams of caffeine in the drink:");
        caffeine = keyboard.nextInt();

        cups = OVERDOSE / (caffeine * 0.001);
        System.out.printf("It will take approximately %.1f drinks of %s to "
                + "kill a person from caffeine. %n%n", cups, drinkName);

        System.out.println("From the file");

        // Input from the file
        fileIn = null;  // Initialize fileIn to empty
        try {
            // Attempt to Open the file
            fileIn = new Scanner(new FileInputStream("Proj0214_caffeine.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }

        // read from file
        System.out.println("Text left to read? " + fileIn.hasNextLine());
        drinkName = fileIn.nextLine();
        caffeine = fileIn.nextInt();
        fileIn.nextLine();  // Read newline left from nextInt()
        System.out.println("Text left to read? " + fileIn.hasNextLine());
        fileIn.close(); //                              **** .close() ****

        System.out.println("The name of the drink: " + drinkName);
        System.out.println("The milligrams of caffeine in the drink: " + caffeine);
        cups = OVERDOSE / (caffeine * 0.001);
        System.out.printf("It will take approximately %.1f drinks of %s to "
                + "kill a person from caffeine. %n", cups, drinkName);
    }
}

/* Sample Dialogue
antw@Mac-mini chapter2 % java Proj0214_caffeine.java
Input the name of the drink:
coffee
Input the milligrams of caffeine in the drink:
160
It will take approximately 62.5 drinks of coffee to kill a person from caffeine. 

From the file
Text left to read? true
Text left to read? false
The name of the drink: green tea
The milligrams of caffeine in the drink: 35
It will take approximately 285.7 drinks of green tea to kill a person from caffeine. 
antw@Mac-mini chapter2 % 
antw@Mac-mini chapter2 % cat Proj0214_caffeine.txt
green tea
35
 */

 /* google
coffee has between 95 and 200 milligrams of caffeine. black tea has between 14 
and 70 milligrams of caffeine. green tea has between 24 and 45 milligrams of 
caffeine. white tea has between 6 and 60 milligrams of caffeine.
 */
