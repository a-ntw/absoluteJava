
/** 220608
 * for PizzaOrder.java
 */
/** 220524
 * Absolute Java
 * Chapter4
 * 11. Create a class named `Pizza` that stores information about a single pizza.
 * It should contain the following:
 *  • Private instance variables to store the size of the pizza (either small,
 * medium, or large), the number of cheese toppings, the number of pepperoni
 * toppings, and the number of ham toppings.
 *  • Constructor(s) that set all of the instance variables.
 *  • Public methods to get and set the instance variables.
 *  • A public method named `calcCost( )` that returns a `double` that is the cost
 * of the pizza.
 *
 *      Pizza cost is determined by:
 *      Small: $10 + $2 per topping
 *      Medium: $12 + $2 per topping
 *      Large: $14 + $2 per topping
 *  • A public method named `getDescription( )` that returns a String containing
 * the pizza size, quantity of each topping, and the pizza cost as calculated
 * `bycalcCost()`.
 * Write test code to create several pizzas and output their descriptions. For
 * example, a large pizza with one cheese, one pepperoni and two ham toppings
 * should cost a total of $22.
 */
import java.text.DecimalFormat;

public class Pizza {

    private String size; // either small, medium, or large
    private int numCheeseToppings;
    private int numPepperoniToppings;
    private int numHamToppings;
    DecimalFormat costf = new DecimalFormat("$0.00");

    private boolean sizeOK(String size) {
        return (size.equalsIgnoreCase("Small")
                || size.equalsIgnoreCase("Medium")
                || size.equalsIgnoreCase("Large"));
    }

    public Pizza(String size, int cheese, int pepperoni, int ham) {
        if (sizeOK(size)) {
            this.size = size;
        }
        this.numCheeseToppings = cheese;
        this.numPepperoniToppings = pepperoni;
        this.numHamToppings = ham;
    }

    public Pizza() {
        this.size = "Small";
        this.numCheeseToppings = 0;
        this.numPepperoniToppings = 0;
        this.numHamToppings = 0;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        sizeOK(size);
        this.size = size;
    }

    public int getNumCheeseToppings() {
        return numCheeseToppings;
    }

    public void setNumCheeseToppings(int cheese) {
        this.numCheeseToppings = cheese;
    }

    public int getNumPepperoniToppings() {
        return numPepperoniToppings;
    }

    public void setNumPepperoniToppings(int pepperoni) {
        this.numPepperoniToppings = pepperoni;
    }

    public int getNumHamToppings() {
        return numHamToppings;
    }

    public void setNumHamToppings(int ham) {
        this.numHamToppings = ham;
    }

    public double calcCost() {
        int cost, sizeCost = 0;
        if (this.size.equalsIgnoreCase("Small")) {
            sizeCost = 10;
        } else if (this.size.equalsIgnoreCase("Medium")) {
            sizeCost = 12;
        } else if (this.size.equalsIgnoreCase("Large")) {
            sizeCost = 14;
        }

        cost = sizeCost + 2 * (numCheeseToppings + numPepperoniToppings + numHamToppings);
        return cost;
    }

    public String getDescription() {
        return size + " pizza, "
                + numCheeseToppings + " cheese, "
                + numPepperoniToppings + " pepperoni, "
                + numHamToppings + " ham,  cost "
                + costf.format(calcCost()) + " .";
    }

    // Proj0508
    @Override
    public String toString() {
        return getDescription();
    }

    public Pizza(Pizza obj) {
        if (obj == null) {
            System.out.println("Fatal Error.");
            System.exit(0);
        }
        this.size = obj.size;
        this.numCheeseToppings = obj.numCheeseToppings;
        this.numPepperoniToppings = obj.numPepperoniToppings;
        this.numHamToppings = obj.numHamToppings;
    }

    public static void main(String[] args) {
        Pizza p1, p2;

        p1 = new Pizza("Large", 1, 1, 2);
        System.out.println(p1.getDescription());

        p2 = new Pizza();
        p2.setNumCheeseToppings(2);
        p2.setNumPepperoniToppings(2);
        System.out.printf("%s %d %d %d %.2f%n", p2.getSize(), p2.getNumCheeseToppings(),
                p2.getNumPepperoniToppings(), p2.getNumHamToppings(), p2.calcCost());

        p2.setNumHamToppings(2);
        p2.setSize("medium");
        System.out.println(p2.getDescription());
    }
}

/* Sample dialogue
run:
Large pizza, 1 cheese, 1 pepperoni, 2 ham,  cost $22.00 .
Small 2 2 0 18.00
medium pizza, 2 cheese, 2 pepperoni, 2 ham,  cost $24.00 .
BUILD SUCCESSFUL (total time: 0 seconds)
 */
