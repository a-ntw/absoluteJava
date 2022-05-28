
/** 220506
 * Absolute Java
 * Chapter3 Programming Projects
 * 3. Weight is defined as the gravitational force acting on the mass of a body.
 * The weight of a body with a mass of 1kg on Earth can be calculated with the
 * formula given below. The weight is expressed in Newtons (N).
 *      Weight on earth = (1 kg) * (9.81 m/s2) = 9.81 N
 * The weight of the same body in N can be calculated with another formula:
 *      Weight on moon = ((1 kg) * (9.81 m/s2)) / 6 = 1.64 N
 * Write a program that takes as input the mass of a car in kilograms and then
 * prompts the user to choose to calculate the car’s weight in Newtons either on
 * Earth or on the Moon.
 * The program should allow the user to enter new values and
 * output the car’s weight on Earth or on the Moon till the user decides to exit.
 * Use the double data type to store the mass.
 */
import java.util.Scanner;

public class Proj0303_EarthOrMoon {

    public static final double WEIGHT_ON_EARTH = 9.81; // N
    public static final double WEIGHT_ON_MOON = 9.81 / 6; // 1.64 N

    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        double car;
        String cont, choice;

        boolean toContinue;
        do {
            System.out.println("Enter the mass of car in kg:");
            car = keyboard.nextInt();
            System.out.println("Choose on the Earth(E) or on the Moon(M). ");
            choice = keyboard.next();

            switch (choice) {
                case "e":
                case "E":
                    System.out.printf("Weight of car on Earth: %.0f kg. %n",
                            car * WEIGHT_ON_EARTH);
                    break;
                case "m":
                case "M":
                    System.out.printf("Weight of car on Moon:  %.0f kg. %n",
                            car * WEIGHT_ON_MOON);
                    break;
            }

            System.out.println("To continue: 'Y'?");
            cont = keyboard.next();
            toContinue = (cont.equalsIgnoreCase("Y"));

        } while (toContinue);
    }
}

/* Sample Dislogue
antw@Mac-mini chapter3 % java Proj0303_EarthOrMoon.java
Enter the mass of car in kg:
1300
Choose on the Earth(E) or on the Moon(M). 
e
Weight of car on Earth: 12753 kg. 
To continue: 'Y'?
y
Enter the mass of car in kg:
1300
Choose on the Earth(E) or on the Moon(M). 
m
Weight of car on Moon:  2126 kg. 
To continue: 'Y'?
n
 */
