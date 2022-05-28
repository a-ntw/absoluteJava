
/** 220501
 * Absolute Java
 * Chapter1 Programming Projects
 * 8. The following program will compile and run, but it uses poor programming
 * style. Modify the program so that it uses the spelling conventions, constant
 * naming conventions, and formatting style recommended in this book.
 * public class vehicleAvgSpeed {
 * public static void main(String[] args)
 * {
 * double TIME;
 * System.out.println("This program calculates vehicle average speed given a time and distance traveled.");
 * TIME = 20.5;
 * AVERAGE_SPEED = distance / TIME;
 * System.out.println("Car average speed is " + AVERAGE_SPEED
 * + " miles per hour.");
 * }
 * public static final double distance = 180;
 * }
 */
public class Proj0108_programmingStyle {

    public static final double DISTANCE = 180;

    public static void main(String[] args) {
        double time, average_speed;
        time = 20.5;
        average_speed = DISTANCE / time;

        System.out.println("This program calculates vehicle average speed "
                + "given a time and distance traveled.");

        System.out.println("Car average speed is " + average_speed
                + " miles per hour.");
    }
}

/* Sample Dialogue
This program calculates vehicle average speed given a time and distance traveled.
Car average speed is 8.78048780487805 miles per hour.
 */
