
/** 220601
 * Absolute Java
 * Chapter5 Programming Projects
 * 3. Create a class to  represent a container. The class Container should have
 * the following properties.
 *  a. Maximum capacity of the container in liters.
 *  b. Quantity of liquid at any given time in liters.
 * The following operations can be performed on the containers:
 *  a. Completely fill a container.
 *  b. Completely empty a container.
 *  c. Transfer liquid from one container to another.
 * Define the class named `Container` that implements the properties and
 * operations defined above. Create a constructor of the Container class that
 * allows the user to specify the maximum capacity of the container in liters.
 * Initially, assume that all the containers are empty.
 * Also, implement the following methods in the Container class.
 *  a. Quantity to return the current quantity of liquid at any given time in
 *  liters.
 *  b. Leftover to return the quantity of liquid that can be filled in the
 *  current container before it is full.
 *  c. Full to fill the current container fully.
 *  d. Empty to make the container completely empty.
 *  e. Transfer to transfer a certain amount of liquid from one container to
 *  another.
 *  f. displayQuantity to display the current quantity in
 *  liters/ milliliters/ kiloliters.
 * Note: While transferring liquid from one container to another, check the
 * maximum capacity of the container.
 */
public class Container {

    private double max;
    private double qty;

    public void setMax(double max) {
        this.max = max;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    private void setQtyFilled() {
        this.qty = max;
    }

    private void setQtyEmpty() {
        this.qty = 0;
    }

    private void transferQty(Container o, double q) {
        if (((o.max - o.qty) >= q) && (this.qty > q)) {
            o.qty += q;
            this.qty -= q;
        } else {
            System.out.println("Error");
            System.exit(0);
        }
    }

    public Container(int max) {
        this.max = max;
        this.qty = 0;
    }

    public static double Quantity(Container c) {
        return c.qty;
    }

    public static double Leftover(Container c) {
        return c.max - c.qty;
    }

    public static void Full(Container c) {
        c.setQtyFilled();
    }

    public static void Empty(Container c) {
        c.setQtyEmpty();
    }

    public static void Transfer(Container c, Container o, double q) {

        if (Quantity(c) < q) {
            System.out.println("Container " + c.max + " is not enough for the qty.");
            System.exit(0);
        }

        if (Leftover(o) >= q) {
            c.transferQty(o, q);
        } else {
            System.out.println("Target leftover not enough to fill required qty.");
        }

    }

    public void displayQuantity() {
        if (this.qty / 1000 > 1) {
            System.out.printf("%.2f kiloliters %n", this.qty / 1000);
        } else if (this.qty < 1) {
            System.out.printf("%.2f milliliters %n", this.qty * 1000);
        } else {
            System.out.printf("%.2f liters %n", this.qty);
        }
    }

    public static void main(String[] args) {
        Container tank = new Container(1010);
        Full(tank);
        System.out.print("Tank ");
        tank.displayQuantity();

        Container bin = new Container(80);
        System.out.println("Bin Quantity: ");
        Transfer(tank, bin, 0.123);
        bin.displayQuantity();
        System.out.println("Leftover: " + Leftover(bin));

        Transfer(tank, bin, 80);

        Empty(bin);
        bin.displayQuantity();
        Transfer(tank, bin, 80);
        bin.displayQuantity();

        System.out.println("Tank Quantity: " + Quantity(tank));
    }

}

/* Sample dialogue
run:
Tank 1.01 kiloliters 
Bin Quantity: 
123.00 milliliters 
Leftover: 79.877
Target leftover not enough to fill required qty.
0.00 milliliters 
80.00 liters 
Tank Quantity: 929.877
BUILD SUCCESSFUL (total time: 0 seconds)
 */
