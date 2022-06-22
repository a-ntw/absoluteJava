
/* 220621 Absolute Java  Chapter6 Programming Projects. Proj0601 */
import java.util.Scanner;

/**
 * You are running a courier agency. The weight of a parcel determines the
 * number of stamps that will be needed to send that parcel. For each kilogram,
 * a stamp of $2 is needed. Create a class to accept the weight of five parcels
 * in floating-point values. Also, the courier company charges an additional
 * rate depending on where the courier has to be delivered. The charges are $20
 * for delivery within the city of posting, and $40 for delivery anywhere else
 * in the country. Write a computer program to calculate and display the total
 * cost of each parcel depending on the weight and delivery location of the
 * parcel.
 */
public class CourierAgency {

    public static final int MAX_NUMBER_PARCELS = 5;
    private float[] parcel;
    private boolean[] withinCity;
    private int[] charges;

    public CourierAgency() {
        parcel = new float[MAX_NUMBER_PARCELS];
        withinCity = new boolean[MAX_NUMBER_PARCELS];
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter " + parcel.length + " couriers.");
        System.out.println("The weight of parcels and \n"
                + "'true' to deliver within the city, "
                + "'false' deliver outside the city.");
        for (int i = 0; i < MAX_NUMBER_PARCELS; i++) {
            System.out.print("Parcel " + (i + 1) + " weight and boolean: ");
            parcel[i] = keyboard.nextFloat();
            withinCity[i] = keyboard.nextBoolean(); //          **** keyboard ****

            fillCharges();
        }
    }

    private void fillCharges() {
        charges = new int[MAX_NUMBER_PARCELS];

        double cost;
        for (int i = 0; i < MAX_NUMBER_PARCELS; i++) {
            cost = Math.ceil(parcel[i]) * 2; // $2 per kg       **** Math ****
            cost += withinCity[i] ? 20 : 40; //                 **** ternary ****
            charges[i] = (int) cost;
        }
    }

    public void display() {
        for (int i = 0; i < MAX_NUMBER_PARCELS; i++) {
            System.out.println("Parcel weight " + parcel[i] + "kg "
                    + (withinCity[i] ? " within city " : " outside city ")
                    + "\tcost $" + charges[i]);
        }
    }

    public static void main(String[] args) {
        CourierAgency work = new CourierAgency();
        work.display();
    }
}

/* Sample dialogue
run:
Enter 5 couriers.
The weight of parcels and 
'true' to deliver within the city, 'false' deliver outside the city.
Parcel 1 weight and boolean: 1.1 true
Parcel 2 weight and boolean: 1.9 true
Parcel 3 weight and boolean: 1.1 false
Parcel 4 weight and boolean: 1.9 false
Parcel 5 weight and boolean: 1.5 false
Parcel weight 1.1kg  within city 	cost $24
Parcel weight 1.9kg  within city 	cost $24
Parcel weight 1.1kg  outside city 	cost $44
Parcel weight 1.9kg  outside city 	cost $44
Parcel weight 1.5kg  outside city 	cost $44
BUILD SUCCESSFUL (total time: 35 seconds)
 */
