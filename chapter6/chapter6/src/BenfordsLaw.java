
/* 220616 Absolute Java  Chapter6 Programming Projects. Proj0616 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Programming Project 3.15 asked you to explore Benford’s Law. An easier way to
 * write the program is to use an array to store the digit counts. That is,
 * {@code count[0]} might store the number of times 0 is the first digit (if
 * that is possible in your data set), {@code count[1]} might store the number
 * of times 1 is the first digit, and so forth. Redo Programming Project 3.15
 * using arrays.
 * <p>
 * Write a program that tests Benford’s Law. Collect a list of at least 100
 * numbers from some real-life data source and enter them into a text file. Your
 * program should use an array to store the digit counts. That is,
 * {@code count[0]} might store the number of times 0 is the first digit (if
 * that is possible in your data set), {@code count[1]} might store the number
 * of times 1 is the first digit, and so forth. For each digit, output the
 * percentage it appears as the first digit.
 */
public class BenfordsLaw {

    public static void main(String args[]) {
        Scanner fileIn = null;
        DecimalFormat percent = new DecimalFormat("0.##%");
        char selected;
        int index, data, count = 0;
        int[] d = new int[10];

        try {
            fileIn = new Scanner(
                    new FileInputStream("../../chapter3/Proj0315_benfordLaw.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }

        while (fileIn.hasNext()) {
            data = fileIn.nextInt();
            count++;
            selected = (data + "").charAt(0);
            //selected = Integer.toString(data).charAt(0);
            index = Integer.parseInt(Character.toString(selected));
            d[index] += 1;
        }
        fileIn.close();

        System.out.println("Leading digit:");

        for (int i = 0; i < d.length; i++) {
            System.out.println("'" + i + "' is "
                    + percent.format((float) d[i] / count));
        }
    }
}

/*
run:
Leading digit:
'0' is 0%
'1' is 95.77%
'2' is 4.23%
'3' is 0%
'4' is 0%
'5' is 0%
'6' is 0%
'7' is 0%
'8' is 0%
'9' is 0%
BUILD SUCCESSFUL (total time: 0 seconds)
 */
