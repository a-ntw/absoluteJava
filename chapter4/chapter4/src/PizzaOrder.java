
/** 220524
 * Absolute Java
 * Chapter4
 * 12. This programming project extends Programming Project4.11. Create a
 * `PizzaOrder` class that allows up to three pizzas to be saved in an order.
 * Each pizza saved should be a Pizza object as described in Programming Project
 * 4.11. In addition to appropriate instance variables and constructors, add the
 * following methods:
 *  • public void `setNumPizzas(int numPizzas)`—sets the number of pizzas in the
 * order. numPizzas must be between 1 and 3.
 *  • public void `setPizza1(Pizza pizza1)`—sets the first pizza in the order.
 *  • public void `setPizza2(Pizza pizza2)`—sets the second pizza in the order.
 *  • public void `setPizza3(Pizza pizza3)`—sets the third pizza in the order.
 *  • public double `calcTotal()`—returns the total cost of the order.
 * Write a main method to test the class. The `setPizza2` and `setPizza3` methods
 * will be used only if there are two or three pizzas in the order, respectively.
 * Sample code illustrating the methods is shown below. Note that first three
 * lines are incomplete. You must complete them as part of the Programming Project.
 * `Pizza pizza1 = // Code to create a large pizza, 1 cheese, 1 ham `
 * `Pizza pizza2 = // Code to create a medium pizza, 2 cheese, 2 pepperoni `
 * `PizzaOrder order = // Code to create an order `
 * `order.setNumPizzas(2); // 2 pizzas in the order `
 * `order.setPizza1(pizza1); // Set first pizza `
 * `order.setPizza2(pizza2); // Set second pizza`
 * `double total = order.calcTotal(); // Should be 18+20 = 38`
 */
public class PizzaOrder {

    private int numPizzas;
    private Pizza pizza1;
    private Pizza pizza2;
    private Pizza pizza3;

    public PizzaOrder() {
        this.numPizzas = 0;
        this.pizza1 = null;
        this.pizza2 = null;
        this.pizza3 = null;
    }

    public void setNumPizzas(int numPizzas) {
        this.numPizzas = numPizzas;
    }

    public void setPizza1(Pizza pizza1) {
        this.pizza1 = pizza1;
    }

    public void setPizza2(Pizza pizza2) {
        if (this.numPizzas > 1) {
            this.pizza2 = pizza2;
        }
    }

    public void setPizza3(Pizza pizza3) {
        if (this.numPizzas > 2) {
            this.pizza3 = pizza3;
        }
    }

    public double calcTotal() {
        if (!pizzaNotNull()) {
            System.out.print("Pizza is null!  ");
            System.out.println("Fatal Error");
            System.exit(0);
        }
        double cost = 0;

        switch (this.numPizzas) {
            default:
                System.out.println("Fatal Error");
                System.exit(0);
                return 0; // Needed to keep the compiler happy
            case 3:
                cost += pizza3.calcCost();
            case 2:
                cost += pizza2.calcCost();
            case 1:
                cost += pizza1.calcCost();
            //break;
        }

        return cost;
    }

    private boolean pizzaNotNull() {
        switch (this.numPizzas) {
            case 1:
                return (pizza1 != null);
            case 2:
                return ((pizza1 != null) && (pizza2 != null));
            case 3:
                return ((pizza1 != null) && (pizza2 != null) && (pizza3 != null));
            default:
                break;
        }
        return false;
    }

    public static void main(String[] args) {

        // Code to create a large pizza, 1 cheese, 1 ham 
        Pizza pizza1 = new Pizza("large", 1, 0, 1);
        System.out.println("pizza1 cost: " + pizza1.getDescription());

        // Code to create a medium pizza, 2 cheese, 2 pepperoni 
        Pizza pizza2 = new Pizza("medium", 2, 2, 0);
        System.out.println("pizza2 cost: " + pizza2.getDescription());

        PizzaOrder order = new PizzaOrder(); // Code to create an order 

        order.setNumPizzas(2); // 2 pizzas in the order 
        order.setPizza1(pizza1); // Set first pizza 
        order.setPizza2(pizza2); // Set second pizza
        double total = order.calcTotal(); // Should be 18+20 = 38
        System.out.println("Total: " + total);
    }
}

/*
run:
pizza1 cost: Pizza 	large size, 
	1 cheese toppin, 0 pepperoni topping, 1 ham topping, 
	cost $18.00 .
pizza2 cost: Pizza 	medium size, 
	2 cheese toppin, 2 pepperoni topping, 0 ham topping, 
	cost $20.00 .
Total: 38.0
BUILD SUCCESSFUL (total time: 0 seconds)
*/