
/* 220717 Absolute Java  Chapter7 Programming Projects. Proj0706 */
/**
 * Create a class called {@code Vehicle} that has the manufacturer’s name (type
 * {@code String}), number of cylinders in the engine (type {@code int}), and
 * owner (type {@code Person} given next). Then, create a class called
 * {@code Truck} that is derived from {@code Vehicle} and has the following
 * additional properties: the load capacity in tons (type {@code double} since
 * it may contain a fractional part) and towing capacity in pounds (type
 * {@code int}). Be sure your class has a reasonable complement of constructors,
 * accessor and mutator methods, and suitably defined {@code equals} and
 * {@code toString} methods. Write a program to test all your methods
 *
 * @see Truck.java
 * @see Person.java
 */
public class Vehicle {

    private String manufacturer;
    private int cylinders;
    private Person owner;

    public Vehicle() {
    }

    public Vehicle(String firstName, String lastName,
            String manufacturer, int cylinders) {
        this.manufacturer = manufacturer;
        this.cylinders = cylinders;
        this.owner = new Person(firstName, lastName); // ****
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getCylinders() {
        return cylinders;
    }

    public Person getOwner() {
        return owner;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (getClass() != other.getClass()) {
            return false;
        } else {
            Vehicle otherObj = (Vehicle) other;
            return manufacturer == otherObj.manufacturer
                    && cylinders == otherObj.cylinders
                    && owner.equals(otherObj.owner);
        }
    }

    public String toString() {
        return "Manufacturer: " + manufacturer + "\nCylinder: " + cylinders
                + "\nOwner: " + owner;
    }

    public static void main(String[] args) {
        Vehicle v = new Vehicle("Anne", "Tai", "Some Where Co.", 6);
        Vehicle veh = new Vehicle();
        veh.setManufacturer("Some Where Co.");
        veh.setCylinders(6);
        veh.setOwner(new Person("Anne", "Tai"));

        if (v.equals(veh)) {
            System.out.println("Is equal...");
        }

        System.out.println(v);
        System.out.println("for veh: Owner is " + veh.getOwner());
    }
}
/* Sample dialogue
run:
Is equal...
Manufacturer: Some Where Co.
Cylinder: 6
Owner: Anne Tai
for veh: Owner is Anne Tai
BUILD SUCCESSFUL (total time: 0 seconds)
 */
