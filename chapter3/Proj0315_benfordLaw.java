
/** 220515
 * Absolute Java
 * Chapter3 Programming Projects
 * 15. This problem is based on a “Nifty Assignment” by Steve Wolfman
 * (http://nifty.stanford.edu/2006/wolfman-pretid). Consider lists of numbers
 * from real-life data sources—for example, a list containing the number of
 * students enrolled in different course sections, the number of comments posted
 * for different Facebook status updates, the number of books in different
 * library holdings, the number of votes per precinct, etc. It might seem like
 * the leading digit of each number in the list could be 1–9 with an equally
 * likely probability. However, Benford’s Law states that the leading digit is 1
 * about 30% of the time and drops with larger digits. The leading digit is 9
 * only about 5% of the time.
 * Write a program that tests Benford’s Law. Collect a list of at least 100
 * numbers from some real-life data source and enter them into a text file. Your
 * program should loop through the list of numbers and count how many times 1 is
 * the first digit, 2 is the first digit, etc. For each digit, output the
 * percentage it appears as the first digit.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Proj0315_benfordLaw {

    public static void main(String args[]) {
        char selected;
        int d1 = 0, d2 = 0, d3 = 0, d4 = 0, d5 = 0, d6 = 0, d7 = 0, d8 = 0, d9 = 0;
        int data, count = 0;
        Scanner fileIn = null;
        DecimalFormat percent = new DecimalFormat("0.##%");

        try {
            fileIn = new Scanner(
                    new FileInputStream("Proj0315_benfordLaw.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }

        while (fileIn.hasNext()) {
            data = fileIn.nextInt();
            count++;
            selected = Integer.toString(data).charAt(0);
            switch (selected) {
                case '1': d1++; break;
                case '2': d2++; break;
                case '3': d3++; break;
                case '4': d4++; break;                            
                case '5': d5++; break;                             
                case '6': d6++; break;                              
                case '7': d7++; break;                             
                case '8': d8++; break;
                case '9': d9++; break;
            }
        }
        fileIn.close();

        System.out.println("Leading digit:");
        System.out.println("'1' is " + percent.format((float) d1 / count));
        System.out.println("'2' is " + percent.format((float) d2 / count));
        System.out.println("'3' is " + percent.format((float) d3 / count));
        System.out.println("'4' is " + percent.format((float) d4 / count));
        System.out.println("'5' is " + percent.format((float) d5 / count));
        System.out.println("'6' is " + percent.format((float) d6 / count));
        System.out.println("'7' is " + percent.format((float) d7 / count));
        System.out.println("'8' is " + percent.format((float) d8 / count));
        System.out.println("'9' is " + percent.format((float) d9 / count));
    }
}
/* Sample dialogue
Leading digit:
'1' is 95.77%
'2' is 4.23%
'3' is 0%
'4' is 0%
'5' is 0%
'6' is 0%
'7' is 0%
'8' is 0%
'9' is 0%
 */

 /*
Proj0315_benfordLaw.txt
https://en.wikipedia.org/wiki/List_of_tallest_buildings
in ft
 */
