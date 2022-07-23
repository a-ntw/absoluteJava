
/**
 * Disp0802 The Derived Class DiscountSale.
 * <br>Ref: 220723 Absolute Java Chapter8 Programming Projects. 
 *
 * @see Sale
 */
public class DiscountSale extends Sale {

    private double discount; //A percent of the price. Cannot be negative.

    public DiscountSale() {
        super(); // The meaning would be unchanged if this line were omitted.
        discount = 0;
    }

    /**
     * Precondition: theName is a nonempty string; thePrice is nonnegative;
     * theDiscount is expressed as a percent of the price and is nonnegative.
     */
    public DiscountSale(String theName,
            double thePrice, double theDiscount) {
        super(theName, thePrice);
        setDiscount(theDiscount);
    }

    public DiscountSale(DiscountSale originalObject) {
        super(originalObject);
        discount = originalObject.discount;
    }

    public static void announcement() {
        System.out.println("This is the DiscountSale class.");
    }

    public double bill() {
        double fraction = discount / 100;
        return (1 - fraction) * getPrice();
    }

    public double getDiscount() {
        return discount;
    }

    /**
     * Precondition: Discount is nonnegative.
     */
    public void setDiscount(double newDiscount) {

        if (newDiscount >= 0) {
            discount = newDiscount;
        } else {
            System.out.println("Error: Negative discount.");
            System.exit(0);
        }
    }

    public String toString() {
        return (getName() + " Price = $" + getPrice()
                + " Discount = " + discount + "%\n"
                + " Total cost = $" + bill());
    }

    public boolean equals(Object otherObject) {
        //The rest of the definition of equals is located in Self-Test Exercise 4.
        return false;
    }
}
