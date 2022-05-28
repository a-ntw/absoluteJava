
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
    private int cheese;
    private int pepperoni;
    private int ham;
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
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.ham = ham;
    }

    public Pizza() {
        this.size = "Small";
        this.cheese = 0;
        this.pepperoni = 0;
        this.ham = 0;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        sizeOK(size);
        this.size = size;
    }

    public int getCheese() {
        return cheese;
    }

    public void setCheese(int cheese) {
        this.cheese = cheese;
    }

    public int getPepperoni() {
        return pepperoni;
    }

    public void setPepperoni(int pepperoni) {
        this.pepperoni = pepperoni;
    }

    public int getHam() {
        return ham;
    }

    public void setHam(int ham) {
        this.ham = ham;
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

        cost = sizeCost + 2 * (cheese + pepperoni + ham);
        return cost;
    }

    public String getDescription() {
        return "Pizza \t" + size + " size, \n\t"
                + cheese + " cheese toppin, "
                + pepperoni + " pepperoni topping, "
                + ham + " ham topping, \n\tcost "
                + costf.format(calcCost()) + " .";
    }

    public static void main(String[] args) {
        Pizza p1, p2;

        p1 = new Pizza("Large", 1, 1, 2);
        System.out.println(p1.getDescription());

        p2 = new Pizza();
        p2.setCheese(2);
        p2.setPepperoni(2);
        System.out.printf("%s %d %d %d %.2f%n", p2.getSize(), p2.getCheese(),
                p2.getPepperoni(), p2.getHam(), p2.calcCost());

        p2.setHam(2);
        p2.setSize("medium");
        System.out.println(p2.getDescription());
    }
}

/* Sample dialogue
run:
Pizza 	Large size, 
	1 cheese toppin, 1 pepperoni topping, 2 ham topping, 
	cost $22.00 .
Small 2 2 0 18.00
Pizza 	medium size, 
	2 cheese toppin, 2 pepperoni topping, 2 ham topping, 
	cost $24.00 .
BUILD SUCCESSFUL (total time: 0 seconds)
 */
