
/* 220717 Absolute Java  Chapter7 Programming Projects. Proj0706 */
/**
 *
 * @see Vehicle.java
 */
public class Truck extends Vehicle {

    private double loadCapacity;
    private int towCapacity;

    public Truck() {
    }

    public Truck(String manufacturer, int cylinders, Person owner,
            double loadCapacity, int towCapacity) {
        super.setManufacturer(manufacturer);
        super.setCylinders(cylinders);
        super.setOwner(owner);
        this.loadCapacity = loadCapacity;
        this.towCapacity = towCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public void setTowCapacity(int towCapacity) {
        this.towCapacity = towCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public int getTowCapacity() {
        return towCapacity;
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (getClass() != other.getClass()) {
            return false;
        } else {
            Truck otherObj = (Truck) other;
            return super.equals(other) && loadCapacity == otherObj.loadCapacity
                    && towCapacity == otherObj.towCapacity;
        }
    }

    public String toString() {
        return super.toString() + "\nTruck capacity: " + loadCapacity
                + " kg; tow capacity: " + towCapacity + " kg";
    }

    public static void main(String[] args) {
        Truck mytruck = new Truck("Some Where Co.", 6,
                new Person("Anne", "Tai"), 1000, 3000);
        Truck t = new Truck();
        t.setManufacturer("Some Where Co.");
        t.setCylinders(6);
        t.setOwner(new Person("Anne", "Tai"));
        t.setLoadCapacity(1000);
        t.setTowCapacity(3000);

        System.out.println(t.getManufacturer() + ", " + t.getCylinders() + " cyl."
                + "\nCapacity: " + t.getLoadCapacity()
                + ", Tow capacity" + t.getTowCapacity());

        if (t.equals(mytruck)) {
            System.out.println(t.getOwner() + " is equal "
                    + mytruck.getOwner().getFirstName());
        }

        System.out.println("* * * * *\n" + mytruck);
    }
}

/* Sample dialogue
run:
Some Where Co., 6 cyl.
Capacity: 1000.0, Tow capacity3000
Anne Tai is equal Anne
* * * * *
Manufacturer: Some Where Co.
Cylinder: 6
Owner: Anne Tai
Truck capacity: 1000.0 kg; tow capacity: 3000 kg
BUILD SUCCESSFUL (total time: 0 seconds)
 */
