
/** 220512
 * Absolute Java
 * Chapter3 Programming Projects
 * 7. An Armstrong number is an n-digit number that equals the sum of the nth
 * power of its digits. For example 153 is a three-digit number where the sum of
 * the cubes of the individual digits (13 + 53 + 33) equals the number itself
 * (153).
 * Write a program that takes as input the start and end numbers of an Armstrong
 * number range to be printed. Your program should prompt for new start and end
 * numbers until the user decides that she or he is through. Use variables of
 * the type integer to store the start and end numbers of the range.
 */
import java.util.Scanner;

public class Proj0307_armstrong {
    
    public static final int POWER = 3;

    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        int lgth, digit;
        long startNum, endNum, sum;
        String strNum;
        boolean toContinue = true;

        System.out.println("To print the range of Armstrong numbers in power 3.");
        
        while (toContinue) {
            System.out.println("Input the start number:");
            startNum = keyboard.nextLong();
            System.out.println("Input the end number: ");
            endNum = keyboard.nextLong();
            System.out.println("Armstrong numbers:");

            do {
                //keyboard.next(); // pause for debug
                strNum = String.valueOf(startNum);
                lgth = strNum.length();
                sum = 0;
                for (int i = 0; i < lgth; i++) {
                    digit = Integer.parseInt(strNum.substring(i, i + 1));
                    sum += Math.pow(digit,POWER); //        **** Math.pow ****
                }

                if (startNum == sum) {
                    System.out.println(sum); // Armstrong
                }
                startNum++;
            } while (startNum <= endNum);
            
            System.out.println("To continue: 'Y'?");
            toContinue = (keyboard.next().equalsIgnoreCase("Y"));
        }
    }
}

/* Sample Dialogue
antw@Mac-mini chapter3 % java Proj0307_armstrong.java 
To print the range of Armstrong numbers in power 3.
Input the start number:
0
Input the end number: 
500
Armstrong numbers:
0
1
153
370
371
407
To continue: 'Y'?
n
 */
