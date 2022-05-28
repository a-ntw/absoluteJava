
/** 220513
 * Absolute Java
 * Chapter3 Programming Projects
 * 8. In a certain code language, numerals are each represented by a symbol or a
 * letter. They are as follows
 * Numeral      0   1   2   3   4   5   6   7   8   9
 * Symbol code  *   B   E   A   @   F   K   %   R   M
 * Numerals are to be coded as per the codes in the table and the following
 * conditions:
 *  a. If the first and the last digits are odd, both are to be coded as ‘X’.
 *  b. If the first and the last digits are even, both are to be coded as ‘$’.
 *  c. If the last digit is ‘0’, it is to be coded as ‘#’.
 * For example, 487692 is coded as $R%KM$
 * Write a program that takes as input a sequence of numbers and displays the
 * corresponding code to represent it.
 */
import java.util.Scanner;

public class Proj0308_certainCode {

    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        String strNum, strAppend = "", choice;
        int lgth, digitFirst, digitLast;

        System.out.println("Input a sequence of numbers:");
        strNum = keyboard.next();

        lgth = strNum.length();
        if (lgth < 2) {
            System.out.println("Input minimum 2 digits.");
            System.exit(0);
        }

        digitFirst = Integer.parseInt(strNum.substring(0, 1));

        if (digitFirst % 2 < 1) {
            strAppend += "$";
        } else {
            strAppend += "X";
        }

        for (int i = 1; i < lgth - 1; i++) {
            choice = strNum.substring(i, i + 1);
            switch (choice) {
                case "0":
                    strAppend += "*";
                    break;
                case "1":
                    strAppend += "B";
                    break;
                case "2":
                    strAppend += "E";
                    break;
                case "3":
                    strAppend += "A";
                    break;
                case "4":
                    strAppend += "@";
                    break;
                case "5":
                    strAppend += "F";
                    break;
                case "6":
                    strAppend += "K";
                    break;
                case "7":
                    strAppend += "%";
                    break;
                case "8":
                    strAppend += "R";
                    break;
                case "9":
                    strAppend += "M";
            }
        }

        digitLast = Integer.parseInt(strNum.substring(lgth - 1));
        if (digitLast % 2 < 1) {
            strAppend += "$";
        } else {
            strAppend += "X";
        }

        System.out.println("The corresponding code: " + strAppend);
    }
}

/* Sample dialogue
antw@Mac-mini chapter3 % java Proj0308_certainCode.java
Input a sequence of numbers:
487692
The corresponding code: $R%KM$
 */
