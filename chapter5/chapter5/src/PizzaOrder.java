
/** 220608
 * Absolute Java
 * Chapter5 Programming Projects
 * for Pizza.java
 * 8. Programming Project 4.12 asked you to create a `PizzaOrder` class that stores an
 * order consisting of up to three pizzas. Extend this class with the following methods
 * and constructor:
 * • `public int getNumPizzas()` —returns the number of pizzas in the order.
 * • `public Pizza getPizza1()` —returns the first pizza in the order or `null` if
 *  `pizza1` is not set.
 * • `public Pizza getPizza2()` —returns the second pizza in the order or `null`
 *  if `pizza2` is not set.
 * • `public Pizza getPizza3()`—returns the third pizza in the order or `null` if
 *  `pizza3` is not set.
 * • A copy constructor that takes another `PizzaOrder` object and makes an
 *  independent copy of its pizzas. This might be useful if using an old order as a
 *  starting point for a new order.
 * Write a main method to test the new methods. Changing the pizzas in the new
 * order should not change the pizzas in the original order. For example,
 * ```
 *  Pizza pizza1 = // Code to create a large pizza, 1 cheese, 1 ham
 *  Pizza pizza2 = // Code to create a medium pizza, 2 cheese,
 *                  // 2 pepperoni
 *  PizzaOrder order1 = // Code to create an order
 *  order1.setNumPizzas(2); // 2 pizzas in the order
 *  order1.setPizza1(pizza1); // Set first pizza
 *  order1.setPizza2(pizza2); // Set second pizza
 *  double total = order1.calcTotal(); // Should be 18+20 = 38
 *  PizzaOrder order2 = new PizzaOrder(order1); // Use copy
 *                      // constructor
 *  order2.getPizza1().setNumCheeseToppings(3); // Change toppings
 *  double total = order2.calcTotal(); // Should be 22 + 20 = 42
 *  double origTotal = order1.calcTotal(); // Should still be 38
 * ```
 * Note that the first three lines of code are incomplete. You must complete them as
 * part of the Programming Project.
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

    // Proj0508
    public int getNumPizzas() {
        return numPizzas;
    }

    public Pizza getPizza1() {
        if (pizza1 != null) {
            return pizza1;
        }
        return null;
    }

    public Pizza getPizza2() {
        if (pizza2 != null) {
            return pizza2;
        }
        return null;
    }

    public Pizza getPizza3() {
        if (pizza3 != null) {
            return pizza3;
        }
        return null;
    }

    public PizzaOrder(PizzaOrder obj) {
        if (obj == null) {
            System.out.println("Fatal Error.");
            System.exit(0);
        }
        this.numPizzas = obj.numPizzas;

        if (obj.pizza1 != null) {
            this.pizza1 = new Pizza(obj.pizza1);
        }
        if (obj.pizza2 != null) {
            this.pizza2 = new Pizza(obj.pizza2);
        }
        if (obj.pizza3 != null) {
            this.pizza3 = new Pizza(obj.pizza3);
        }
    }

    public static void main(String[] args) {
        double total, origTotal;

        // Code to create a large pizza, 1 cheese, 1 ham 
        Pizza pizza1 = new Pizza("large", 1, 0, 1);
        // Code to create a medium pizza, 2 cheese, 2 pepperoni 
        Pizza pizza2 = new Pizza("medium", 2, 2, 0);

        PizzaOrder order1 = new PizzaOrder(); // Code to create an order 
        order1.setNumPizzas(2); // 2 pizzas in the order 
        order1.setPizza1(pizza1); // Set first pizza 
        order1.setPizza2(pizza2); // Set second pizza
        total = order1.calcTotal(); // Should be 18+20 = 38
        
        System.out.println("Order1 pizza1: " + order1.getPizza1());
        System.out.println("Order1 pizza2: " + order1.getPizza2());
        System.out.println("Order1 pizza3: " + order1.getPizza3());
        System.out.println("Order1 Total: " + total);

        PizzaOrder order2 = new PizzaOrder(order1);
        order2.getPizza1().setNumCheeseToppings(3);  // Change toppings
        total = order2.calcTotal();// Should be 22 + 20 = 42
        origTotal = order1.calcTotal(); // Should still be 38

        System.out.println("Order2 pizza1: " + order2.getPizza1());
        System.out.println("Order2 pizza2: " + order2.getPizza2());
        System.out.println("Order2 Total: " + total);
        System.out.println("Order1 OrigTotal: " + origTotal);
    }
}

/* Sample dialogue
run:
Order1 pizza1: large pizza, 1 cheese, 0 pepperoni, 1 ham,  cost $18.00 .
Order1 pizza2: medium pizza, 2 cheese, 2 pepperoni, 0 ham,  cost $20.00 .
Order1 pizza3: null
Order1 Total: 38.0
Order2 pizza1: large pizza, 3 cheese, 0 pepperoni, 1 ham,  cost $22.00 .
Order2 pizza2: medium pizza, 2 cheese, 2 pepperoni, 0 ham,  cost $20.00 .
Order2 Total: 42.0
Order1 OrigTotal: 38.0
BUILD SUCCESSFUL (total time: 0 seconds)
 */
