
/** 220504
 * Absolute Java
 * Chapter2 Programming Projects
 * 11. Write a program that calculates the total grade for three classroom
 * exercises as a percentage. Use the DecimalFormat class to output the value
 * as a percent. The scores should be summarized in a table. Input the
 * assignment information in this order: name of assignment (may include
 * spaces), points earned (integer), and total points possible (integer). The
 * percentage is the sum of the total points earned divided by the total points
 * possible.
 */
import java.text.DecimalFormat;                 // **** DecimalFormat ****
import java.util.Scanner;

public class Proj0211_totalGrades {

    public static void main(String args[]) {

        DecimalFormat percent = new DecimalFormat("0.00%"); // auto convert to %
        Scanner keyboard = new Scanner(System.in);
        String ex1Name, ex2Name, ex3Name;
        int ex1Score, ex2Score, ex3Score;
        int ex1Point, ex2Point, ex3Point;
        int totalScore, totalPoint;

        System.out.println("Name of exercise 1:");
        ex1Name = keyboard.nextLine();
        System.out.println("Score received for exercise 1:");
        ex1Score = keyboard.nextInt();
        System.out.println("Total points possible for exercise 1:");
        ex1Point = keyboard.nextInt();
        keyboard.nextLine(); //Reads a line and discards it. 

        System.out.println("Name of exercise 2:");
        ex2Name = keyboard.nextLine();
        System.out.println("Score received for exercise 2:");
        ex2Score = keyboard.nextInt();
        System.out.println("Total points possible for exercise 2:");
        ex2Point = keyboard.nextInt();
        keyboard.nextLine(); //Reads a line and discards it.

        System.out.println("Name of exercise 3:");
        ex3Name = keyboard.nextLine();
        System.out.println("Score received for exercise 3:");
        ex3Score = keyboard.nextInt();
        System.out.println("Total points possible for exercise 3:");
        ex3Point = keyboard.nextInt();

        System.out.printf("%-20s %-10s %-10s %n", "Exercise", "Score", "Total Possible");
        System.out.printf("%-20s %-10d %-10d %n", ex1Name, ex1Score, ex1Point);
        System.out.printf("%-20s %-10d %-10d %n", ex2Name, ex2Score, ex2Point);
        System.out.printf("%-20s %-10d %-10d %n", ex3Name, ex3Score, ex3Point);

        totalScore = ex1Score + ex2Score + ex3Score;
        totalPoint = ex1Point + ex2Point + ex3Point;
        System.out.printf("%-20s %-10d %-10d %n", "Total", totalScore, totalPoint);

        System.out.printf("Your total is %d out of %d, or ", totalScore, totalPoint);
        System.out.println(percent.format((float) totalScore / totalPoint) + ".");
    }
}

/* Sample Dialogue
antw@Mac-mini chapter2 % java Proj0211_totalGrades.java
Name of exercise 1:
Group Project
Score received for exercise 1:
10
Total points possible for exercise 1:
10
Name of exercise 2:
HomeWork
Score received for exercise 2:
7
Total points possible for exercise 2:
12
Name of exercise 3:
Presentation
Score received for exercise 3:
5
Total points possible for exercise 3:
8
Exercise             Score      Total Possible 
Group Project        10         10         
HomeWork             7          12         
Presentation         5          8          
Total                22         30         
Your total is 22 out of 30, or 73.33%.
 */
