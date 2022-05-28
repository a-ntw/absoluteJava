
/** 220503
 * Absolute Java
 * Chapter2 Programming Projects
 * 5. Grade point average(GPA)in a 4-point scale is calculated by using the
 * following formula:
 * GPA = ( Percentage /100 ) x 4
 *
 *  Write a program that takes as input the percentage from a user. The program
 * should then output the user’s GPA on the screen. The format of the output
 * should be as follows, assuming the user’s percentage is 85:
 *  (85/100) * 4 = 3
 */
import java.util.Scanner;

public class Proj0205_gradePointAve {

    public static void main(String args[]) {

        Scanner keyboard = new Scanner(System.in);
        double percent;
        int gpa;

        System.out.print("Enter the percentage: ");
        percent = keyboard.nextInt();

        gpa = (int) (percent / 100 * 4);
        System.out.println("GPA: " + gpa);
    }
}

/* Sample Dialogue
antw@Mac-mini chapter2 % java Proj0205_gradePointAve.java
Enter the percentage: 85
GPA: 3
 */
