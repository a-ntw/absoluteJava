
/** 220503
 * Absolute Java
 * Chapter2 Programming Projects
 * 4. John travels a distance of 55 miles at an average speed of 15 miles per
 * hour. Write a program to calculate the total number of hours John takes to
 * cover this distance. The program should print the total time taken in hours
 * and minutes. Use the following formula for calculations.
 *
 *  Time = Distance / Speed
 */
public class Proj0204_travelTime {

    public static void main(String args[]) {

        int distance = 55;
        int speed = 15;
        
        int timeInHour = distance / speed;
        double remainderDist = distance % speed;
        double remainderMinutes = remainderDist / speed * 60;

        System.out.printf("Distance of %d miles at an speed %d miles per hour.%n",
                distance, speed);

        System.out.printf("Total time taken: %d hours and %.0f minutes.",
                timeInHour, remainderMinutes);
    }
}

/* Sample Dialogue
Distance of 55 miles at an speed 15 miles per hour.
Total time taken: 3 hours and 40 minutes.
 */
