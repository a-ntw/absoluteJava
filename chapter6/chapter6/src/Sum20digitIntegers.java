
/* 220627 Absolute Java  Chapter6 Programming Projects. Proj0607 */
import java.util.Scanner;

/**
 * An array can be used to store large integers one digit at a time.
 *
 * For example, the integer 1234 could be stored in the array a by setting a[0]
 * to 1, a[1] to 2, a[2] to 3, and a[3] to 4. However, for this exercise you
 * might find it more useful to store the digits backward; that is, place 4 in
 * a[0], 3 in a[1], 2 in a[2], and 1 in a[3]. In this exercise, write a program
 * that reads in 2 positive integers that are 20 or fewer digits in length and
 * then outputs the sum of the 2 numbers. Your program will read the digits as
 * values of type {@code char} so that the number 1234 is read as the four
 * characters '1', '2', '3', and '4'. After they are read into the program, the
 * characters are changed to values of type {@code int}. The digits should be
 * read into a partially filled array; you might find it useful to reverse the
 * order of the elements in the array after the array is filled with data from
 * the keyboard.
 *
 * Your program should perform the addition by implementing the usual
 * paper-and-pencil addition algorithm. The result of the addition should be
 * stored in an array of size 20, and the result should then be written to the
 * screen. If the result of the addition is an integer with more than the
 * maximum number of digits (that is, more than 20 digits), then your program
 * should issue a message saying that it has encountered “integer overflow.” You
 * should be able to change the maximum length of the integers by changing only
 * one named constant. Include a loop that allows the user to continue to do
 * more additions until the user says the program should end.
 */
public class Sum20digitIntegers {

    public static final int MAX_NUM = 20;

    /**
     * main.
     *
     * @param args args
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int[] array1, //        large int[] array, Primary
                array2; //      large int[] array, secondary
        int num1Used = 0, //    numberUsed, position for primary array
                num2Used = 0; //numberUsed position for second array

        boolean toContinue;
        do {
            System.out.println("Enter String of 20 or fewer digits for first Array.");
            String d1 = keyboard.next();
            System.out.println("Enter String of 20 or fewer digits for Second Array.");
            String d2 = keyboard.next();

            array1 = new int[MAX_NUM];
            array2 = new int[MAX_NUM];
            num1Used = toDigit(d1, array1);
            num2Used = toDigit(d2, array2);
            num1Used = add2LargeInt(array1, num1Used, array2, num2Used);

            System.out.println("Sum of both arrays");
            mirrorDisplay(array1, num1Used);

            System.out.println("To continue: 'Y'?"); // **** toContinue loop ****
            String cont = keyboard.next();
            toContinue = (cont.equalsIgnoreCase("Y"));
        } while (toContinue);
    }

    /**
     *
     * @param arr1 int[] array, primary
     * @param used1 numberUsed position for primary array
     * @param arr2 int[] array, second
     * @param used2 numberUsed for second array
     * @return Return numberUsed the position of largeMain.
     */
    public static int add2LargeInt(int[] arr1, int used1, int[] arr2, int used2) {

        int digitsSum = arr1[0] + arr2[0]; // added%10
        int carrier = 0, //                 carry over //added/10;
                numUsed = 0; //             new position of PFA
        for (int i = 0; (i < used1) || (i < used2); i++) {
            digitsSum = carrier + arr1[i] + arr2[i];
            carrier = digitsSum / 10; //    next carrier
            arr1[i] = digitsSum % 10;
            numUsed++;
        }
        if (carrier > 0) {
            if (numUsed >= MAX_NUM) {
                System.out.println("Error. Integer overflow");
                System.exit(0);
            }
            arr1[numUsed] = carrier;
            numUsed++;
        }
        return numUsed;
    }

    /**
     * Convert the String to single digit in largetInt PFA
     *
     * @param ch String consist of digit from 0 to 9
     * @param arr array contain the value of digit
     * @return numberUsed, ie position of partial filled array of largeInt
     */
    public static int toDigit(String ch, int[] arr) {
        if (ch.length() > MAX_NUM) {
            System.out.println("Error, above maximum allowable digit.");
            System.exit(0);
        }
        int digit, numUsed = 0;
        for (int i = ch.length() - 1; i >= 0; i--) {
            digit = Character.digit(ch.charAt(i), 10); // **** Character.digit ****
            if (digit < 0) {
                System.out.println("Error. Char need to be digit");
                System.exit(0);
            }
            numUsed = addToPFA(digit, arr, numUsed);
        }
        return numUsed;
    }

    private static int addToPFA(int digit, int[] largeInt, int numberUsed) {
        largeInt[numberUsed] = digit;
        numberUsed++;
        return numberUsed;
    }

    /**
     * screen out the digits from large index to small
     *
     * @param array PFA array of digit
     * @param numUsed position of array
     */
    public static void mirrorDisplay(int[] array, int numUsed) {
        for (int i = numUsed - 1; i >= 0; i--) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
    }
}

/* Sample dialogue
run:
Enter String of 20 or fewer digits for first Array.
12345678901234567890
Enter String of 20 or fewer digits for Second Array.
12345678901234567890
Sum of both arrays
 2 4 6 9 1 3 5 7 8 0 2 4 6 9 1 3 5 7 8 0
To continue: 'Y'?
y
Enter String of 20 or fewer digits for first Array.
1
Enter String of 20 or fewer digits for Second Array.
1234
Sum of both arrays
 1 2 3 5
To continue: 'Y'?
n
BUILD SUCCESSFUL (total time: 17 seconds)
 */
