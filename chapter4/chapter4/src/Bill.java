
/** 220408
 * Absolute Java
 * Chapter4
 * Display 4.6 A Formal Parameter Used as a Local Variable
 */
import java.util.Scanner;

public class Bill {

    public static final double RATE = 150.00;   // Dollars per quarter hour

    private int hours;
    private int minutes;
    private double fee;

    public void inputTimeWorked() {
        System.out.println("Enter number of full hours worked");
        System.out.println("followed by number of minutes:");
        Scanner keyboard = new Scanner(System.in);
        hours = keyboard.nextInt();
        minutes = keyboard.nextInt();
    }

    private double computeFee(int hoursWorked, int minutesWorked) {
        minutesWorked = hoursWorked * 60 + minutesWorked;
        int quarterHours = minutesWorked / 15;
        // Any remaining fraction of a quarter hour is not charged for
        return quarterHours * RATE;
    }

    public void updateFee() {
        fee = computeFee(hours, minutes);
    }

    public void outputBill() {
        System.out.println("Time worked: ");
        System.out.println(hours + " hours and " + minutes + " minutes");
        System.out.println("Rate: $" + RATE + " per quarter hour.");
        System.out.println("Amount due: $" + fee);
    }

    // from BillingDialog.java
    public static void main(String args[]) {
        System.out.println("Welcome to the law office of");
        System.out.println("Dewey, Cheatham and Howe.");
        Bill yourBill = new Bill();
        yourBill.inputTimeWorked();
        yourBill.updateFee();
        yourBill.outputBill();
        System.out.println("We have placed a lien on your house");
        System.out.println("It has been our pleasure to serve you.");
    }
}

/* Sample Dialogue
antw@Mac-mini chapter4 % java Disp0406_Bill.java
Welcome to the law office of
Dewey, Cheatham and Howe.
Enter number of full hours worked
followed by number of minutes:
3 48
Time worked: 
3 hours and 48 minutes
Rate: $150.0 per quarter hour.
Amount due: $2250.0
We have placed a lien on your house
It has been our pleasure to serve you.
 */
