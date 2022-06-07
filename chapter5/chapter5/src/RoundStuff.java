
/**
 * Display 5.1
 * Class with static methods for circles and spheres.
 */
import java.util.Scanner;

public class RoundStuff {

    public static final double PI = 3.14159;

    /**
     * Return the area of a circle of the given radius.
     */
    public static double area(double radius) {
        return (PI * radius * radius);
    }

    /**
     * Return the volume of a sphere of the given radius.
     */
    public static double volume(double radius) {
        return ((4.0 / 3.0) * PI * radius * radius * radius);
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter radius:");
        double radius = keyboard.nextDouble();

        System.out.println("A circle of radius "
                + radius + " inches");
        System.out.println("has an area of "
                + RoundStuff.area(radius) + " square inches.");
        System.out.println("A sphere of radius"
                + radius + " inches");
        System.out.println("has an volume of "
                + RoundStuff.volume(radius) + " cubic inches.");
    }
}

/* Sample dialogue
antw@Mac-mini absoluteJava % java chapter5/chapter5/src/RoundStuff.java
Enter radius:
2
A circle of radius 2.0 inches
has an area of 12.56636 square inches.
A sphere of radius2.0 inches
has an volume of 33.51029333333333 cubic inches.
antw@Mac-mini absoluteJava % 
*/
