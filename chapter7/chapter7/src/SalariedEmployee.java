
/* 220710 Absolute Java  Chapter7 Programming Projects. Disp0705 */
/** The Derived Class <b>SalariedEmployee</b>
 * Class Invariant: All objects have a name string, hire date, and nonnegative
 * salary. A name string of "No name" indicates no real name specified yet. A
 * hire date of January 1, 1000 indicates no real hire date specified yet.
 */
public class SalariedEmployee extends Employee {

    private double salary; //annual

    public SalariedEmployee() {
        super(); // if this line is omitted, Java will still invoke the 
        //          no-argument constructor for the base class.
        salary = 0;
    }

    /**
     * Precondition: Neither theName nor theDate is null; theSalary is
     * nonnegative.
     */
    public SalariedEmployee(String theName, Date theDate, double theSalary) {
        super(theName, theDate);
        if (theSalary >= 0) {
            salary = theSalary;
        } else {
            System.out.println("Fatal Error: Negative salary.");
            System.exit(0);
        }
    }

    public SalariedEmployee(SalariedEmployee originalObject) {
        super(originalObject); // An object of the class SalariedEmployee is 
        //                          also an object of the class Employee.
        salary = originalObject.salary;
    }

    public double getSalary() {
        return salary;
    }

    /**
     * Returns the pay for the month.
     */
    public double getPay() {
        return salary / 12;
    }

    /**
     * Precondition: newSalary is nonnegative.
     */
    public void setSalary(double newSalary) {
        if (newSalary >= 0) {
            salary = newSalary;
        } else {
            System.out.println("Fatal Error: Negative salary.");
            System.exit(0);
        }
    }

    @Override
    public String toString() {
        return (getName() + " " + getHireDate().toString()
                + "\n$" + salary + " per year");
    }

    public boolean equals(SalariedEmployee other) {
        return (getName().equals(other.getName())
                && getHireDate().equals(other.getHireDate())
                && salary == other.salary);
    }
//}
//public class main {

    public static void main(String[] args) {

        //  Display 7.6 An Object Belongs to Multiple Classes
        SalariedEmployee joe = new SalariedEmployee("Josephine",
                new Date("January", 1, 2015), 100000);
        HourlyEmployee sam = new HourlyEmployee("Sam",
                new Date("February", 1, 2015), 50.50, 40);

        System.out.println("joe's longer name is " + joe.getName());
        System.out.println("showEmployee(joe) invoked:");
        showEmployee(joe); // A SalariedEmployee is an Employee.

        System.out.println("showEmployee(sam) invoked:");
        showEmployee(sam); // An HourlyEmployee is an Employee.

    }

    public static void showEmployee(Employee employeeObject) {
        System.out.println(employeeObject.getName());
        System.out.println(employeeObject.getHireDate());
    }
}

/* Sample dialogue
antw@Mac-mini chapter7 % javac -d build/classes src/*.java
antw@Mac-mini chapter7 % cd build/classes
antw@Mac-mini classes % java main
Absolute Java  Chapter7 Programming Projects.
joe's longer name is Josephine
showEmployee(joe) invoked:
Josephine
January 1, 2015
showEmployee(sam) invoked:
Sam
February 1, 2015
antw@Mac-mini classes %  
 */
