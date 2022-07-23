
/**
 * Disp0801 The Base Class Sale;<br>
 * Class for a simple sale of one item with no tax, discount, or other
 * adjustments.<br>
 * Class invariant: The price is always nonnegative; the name is a nonempty
 * string.
 * <br>Ref: 220723 Absolute Java Chapter8 Programming Projects. 
 *
 * @see DiscountSale
 * @see main(String[] args) Sample dialogue
 */
public class Sale {

    private String name; //A nonempty string
    private double price; //nonnegative

    public Sale() {
        name = "No name yet";
        price = 0;
    }

    /**
     * Precondition: theName is a nonempty string; thePrice is nonnegative.
     */
    public Sale(String theName, double thePrice) {
        setName(theName);
        setPrice(thePrice);
    }

    public Sale(Sale originalObject) {
        if (originalObject == null) {
            System.out.println("Error: null Sale object.");
            System.exit(0);
        }
        //else
        name = originalObject.name;
        price = originalObject.price;
    }

    public static void announcement() {
        System.out.println("This is the Sale class.");
    }

    public double getPrice() {
        return price;
    }

    /**
     * Precondition: newPrice is nonnegative.
     */
    public void setPrice(double newPrice) {
        if (newPrice >= 0) {
            price = newPrice;
        } else {
            System.out.println("Error: Negative price.");
            System.exit(0);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        if (newName != null && newName != "") {
            name = newName;
        } else {
            System.out.println("Error: Improper name value.");
            System.exit(0);
        }
    }

    public String toString() {
        return (name + " Price and total cost = $" + price);
    }

    public double bill() {
        return price;
    }

    /**
     * Returns true if the names are the same and object is equal to the bill
     * for otherSale; Also returns false if otherObject is null.
     */
    public boolean equalDeals(Sale otherSale) {
        if (otherSale == null) {
            return false;
        } else {
            return (name.equals(otherSale.name)
                    && bill() == otherSale.bill());
            //When invoked, these methods will use the definition of
            //the method bill that is appropriate for each of the objects.
        }
    }

    public boolean lessThan(Sale otherSale) {
        if (otherSale == null) {
            System.out.println("Error: null Sale object.");
            System.exit(0);
        }
        //else
        return (bill() < otherSale.bill());
        //When invoked, these methods will use the definition of
        //the method bill that is appropriate for each of the objects.
    }

    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        } else if (getClass() != otherObject.getClass()) {
            return false;
        } else {
            Sale otherSale = (Sale) otherObject;
            return (name.equals(otherSale.name)
                    && (price == otherSale.price));
        }
    }

    /**
     * display 8.3 Late Binding Demonstration.
     *
     * <b>Sample dialogue</b>
     * <pre>
     * run:
     * floor mat Price and total cost = $10.0
     * floor mat Price = $11.0 Discount = 10.0%
     * Total cost = $9.9
     * Discounted item is cheaper.
     * cup holder Price and total cost = $9.9
     * cup holder Price = $11.0 Discount = 10.0%
     * Total cost = $9.9
     * Deals are equal.
     * </pre>
     */
    public static void main(String[] args) {

        Sale simple = new Sale("floor mat", 10.00); //One item at $10.00.
        DiscountSale discount = new DiscountSale("floor mat", 11.00,
                10); //One item at $11.00 with a 10% discount.
        System.out.println(simple);
        System.out.println(discount);

        if (discount.lessThan(simple)) {
            //The method lessThan uses different definitions 
            // for discount.bill() and simple.bill().
            System.out.println("Discounted item is cheaper.");
        } else {
            System.out.println("Discounted item is not cheaper.");
        }

        Sale regularPrice = new Sale("cup holder", 9.90); //One item at $9.90.
        DiscountSale specialPrice = new DiscountSale("cup holder",
                11.00, 10); //One item at $11.00 with a 10% discount.
        System.out.println(regularPrice);
        System.out.println(specialPrice);

        // The method equalDeals uses different definitions for 
        // specialPrice.bill() and regularPrice. bill().
        if (specialPrice.equalDeals(regularPrice)) {
            System.out.println("Deals are equal.");
        } else {
            System.out.println("Deals are not equal.");
            //The equalDeals method says that two items are equal provided they 
            //have the same name and the same bill (same total cost). It does 
            //not matter how the bill (the total cost) is calculated.
        }
    }
}
