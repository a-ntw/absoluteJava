
/* 220710 Absolute Java  Chapter7 Programming Projects. Disp0703 */
/** The Derived Class <b>HourlyEmployee</b>
 * Class Invariant: All objects have a name string, hire date, nonnegative wage
 * rate, and nonnegative number of hours worked. A name string of "No name"
 * indicates no real name specified yet. A hire date of January 1, 1000
 * indicates no real hire date specified yet.
 */
public class HourlyEmployee extends Employee {

    private double wageRate;
    private double hours; //for the month

    public HourlyEmployee() {
        super(); // If this line is omitted, Java will still invoke the 
        //          no-argument constructor for the base class.
        wageRate = 0;
        hours = 0;
    }

    /**
     * Precondition: Neither theName nor theDate is null; theWageRate and
     * theHours are nonnegative.
     */
    public HourlyEmployee(String theName, Date theDate,
            double theWageRate, double theHours) {
        super(theName, theDate);
        if ((theWageRate >= 0) && (theHours >= 0)) {
            wageRate = theWageRate;
            hours = theHours;
        } else {
            System.out.println(
                    "Fatal Error: creating an illegal hourly employee");
            System.exit(0);
        }
    }

    public HourlyEmployee(HourlyEmployee originalObject) {
        super(originalObject); // An object of the class is also an instance of 
        //                          the class Employee.
        wageRate = originalObject.wageRate;
        hours = originalObject.hours;
    }

    public double getRate() {
        return wageRate;
    }

    public double getHours() {
        return hours;
    }

    /**
     * Returns the pay for the month.
     */
    public double getPay() {
        return wageRate * hours;
    }

    /**
     * Precondition: hoursWorked is nonnegative.
     */
    public void setHours(double hoursWorked) {
        if (hoursWorked >= 0) {
            hours = hoursWorked;
        } else {
            System.out.println("Fatal Error: Negative hours worked.");
            System.exit(0);
        }
    }

    /**
     * Precondition: newWageRate is nonnegative.
     */
    public void setRate(double newWageRate) {
        if (newWageRate >= 0) {
            wageRate = newWageRate;
        } else {
            System.out.println("Fatal Error: Negative wage rate.");
            System.exit(0);
        }
    }

    // The method toString is overridden so it is different in the derived class 
    // HourlyEmployee than it is in the base class Employee.
    public String toString() {
        return (getName() + " " + getHireDate().toString()
                + "\n$" + wageRate + " per hour for " + hours + " hours");
    }

    public boolean equals(HourlyEmployee other) {
        return (getName().equals(other.getName())
                && getHireDate().equals(other.getHireDate())
                && wageRate == other.wageRate
                && hours == other.hours);
    }

    /**
     * Inheritance Demonstration
     */
    public static void main(String[] args) {
        HourlyEmployee joe = new HourlyEmployee("Joe Worker",
                new Date("January", 1, 2015),
                50.50, 160);

        System.out.println("joe's longer name is "
                + joe.getName());

        System.out.println("Changing joe's name to Josephine.");
        joe.setName("Josephine");

        System.out.println("joe's record is as follows:");
        System.out.println(joe);
    }
}

/* Sample dialogue
run:
joe's longer name is Joe Worker
Changing joe's name to Josephine.
joe's record is as follows:
Josephine January 1, 2015
$50.5 per hour for 160.0 hours
BUILD SUCCESSFUL (total time: 0 seconds)
*/
