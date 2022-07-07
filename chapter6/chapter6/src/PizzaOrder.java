
/* 220703 Absolute Java  Chapter6 Programming Projects. Proj0615 */
/**
 * Programming Project 4.12 asked you to create a {@code PizzaOrder} class that
 * stores an order consisting of up to three pizzas. Modify the class to store
 * the pizzas using an array. This will allow the class to include an arbitrary
 * number of pizzas in the order instead of a maximum of three. The
 * {@code setNumPizzas} method can be used to create an array of the appropriate
 * size. The array structure allows you to eliminate the methods
 * {@code setPizza1}, {@code setPizza2}, and {@code setPizza3} and replace them
 * with a single method, {@code setPizza(int index, Pizza
 * newPizza)}. Include appropriate tests to determine if the new
 * {@code PizzaOrder} class is working correctly.
 */
public class PizzaOrder {

    private int numPizzas;
    private Pizza[] pizza;

    public PizzaOrder() {
        this.numPizzas = 0;
    }

    public void setNumPizzas(int numPizzas) {
        this.numPizzas = numPizzas;
        pizza = new Pizza[numPizzas];
    }

    public void setPizza(int index, Pizza newPizza) {
        pizza[index] = new Pizza(newPizza.getSize(),
                newPizza.getCheese(),
                newPizza.getPepperoni(),
                newPizza.getHam());
    }

    public double calcTotal() {
        if (!pizzaNotNull()) {
            System.out.print("Pizza is null!  ");
            System.out.println("Fatal Error");
            System.exit(0);
        }
        double cost = 0;
        for (int i = 0; i < this.numPizzas; i++) {
            cost += pizza[i].calcCost();
        }
        return cost;
    }

    private boolean pizzaNotNull() {
        for (Pizza e : this.pizza) {
            if (e == null) {
                return false;
            }
        }
        return true;
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
        order.setPizza(0, pizza1); // Set first pizza 
        order.setPizza(1, pizza2); // Set second pizza
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
