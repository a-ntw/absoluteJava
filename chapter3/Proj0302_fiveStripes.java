
/** 220506
 * Absolute Java
 * Chapter3 Programming Projects
 * 2. A designer is trying to create a new pattern of five stripes using three
 * colors. These colors and their codes are mentioned in the table below.
 *      Color   | Character Code
 *      Red     | R
 *      Green   | G
 *      Blue    | B
 * The designer has to keep in mind that no two adjacent stripes are of the same
 * color. For example, RRGBR is an invalid pattern, but RGBRB is valid.
 * Write a program that accepts a sequence of five colors as input from the
 * designer to form the pattern. At each selection the designer makes, the
 * program should check if the input is from among the available set of colors.
 * Also, the program should check that adjacent colors are not the same. At the
 * end, the program should display the final stripe pattern created.
 */
import java.util.Scanner;

public class Proj0302_fiveStripes {

    public static void main(String args[]) {

        Scanner keyboard = new Scanner(System.in);
        String stripes;
        int lgth;
        char c, previousC = ' ';

        System.out.println("Enter the 5 character codes:");
        stripes = keyboard.next();//"rgbrb";
        stripes = stripes.toUpperCase();

        if ((lgth = stripes.length()) != 5) {
            System.out.println("Error. Only accept five stripes.");
            System.exit(0);
        }

        for (int i = 0; i < lgth; i++) {
            c = stripes.charAt(i);
            if ((c != 'R') && (c != 'G') && (c != 'B')) {
                System.out.println("Error. The set of color must be R, G or B.");
                System.exit(0);
            }
            if (c == previousC) {
                System.out.println("Error. The adjacent colors must not the same.");
                System.exit(0);
            }
            previousC = c;
        }

        System.out.println("Final stripe pattern created: " + stripes);
    }
}

/* Sample Dialogue
antw@Mac-mini chapter3 % java Proj0302_fiveStripes.java
Enter the 5 character codes:
rgbyb
Error. The set of color must be R, G or B.
antw@Mac-mini chapter3 % java Proj0302_fiveStripes.java
Enter the 5 character codes:
rgb
Error. Only accept five stripes.
antw@Mac-mini chapter3 % java Proj0302_fiveStripes.java
Enter the 5 character codes:
rgbbr
Error. The adjacent colors must not the same.
antw@Mac-mini chapter3 % java Proj0302_fiveStripes.java
Enter the 5 character codes:
RGBGB
Final stripe pattern created: RGBGB
 */
