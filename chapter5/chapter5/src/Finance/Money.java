/* 220613  Absolute Java  Chapter5 Programming Projects  11. */
 /* 220603  Absolute Java  Chapter5 Programming Projects  5. */
package Finance;

/**
 * Part One: Define a class named {@code Money} whose objects represent amounts
 * of US money. The class should have two instance variables of type
 * {@code int} for the dollars and cents in the amount of money. Include a
 * constructor with two parameters of type {@code int} for the dollars and
 * cents, one with one constructor of type {@code int} for an amount of dollars
 * with zero cents and a no-argument constructor. Include the methods
 * {@code add} and {@code minus} for addition and subtraction of amounts of
 * money. These methods should be static methods, should each have two
 * parameters of type {@code Money}, and return a value of type {@code Money}.
 * Include a reasonable set of accessor and mutator methods as well as the
 * methods {@code equals} and {@code toString}. Write a test program for your
 * class.
 * <p>
 * Part Two: Add a second version of the methods for addition and subtraction.
 * These methods should have the same names as the static version but should use
 * a calling object and a single argument. For example, this version of the add
 * method (for addition) has a calling object and one argument. So
 * {@code m1.add(m2)} returns the result of adding the Money objects {@code m1}
 * and {@code m2}. Note that your class should have all these methods; for
 * example, there should be two methods named {@code add}.
 * <p>
 * Alternate Part Two: Add a second version of the methods for addition and
 * subtraction. These methods should have the same names as the static version
 * but should use a calling object and a single argument. The methods should be
 * {@code void} methods. The result should be given as the changed value of the
 * calling object. For example, this version of the add method (for addition)
 * has a calling object and one argument. Therefore,
 * <blockquote>{@code m1.add(m2);}</blockquote>
 * changes the values of the instance variables of {@code m1} so they represent
 * the result of adding {@code m2} to the original version of {@code m1}. Note
 * that your class should have all these methods; for example, there should be
 * two methods named {@code add}.
 * <p>
 * (If you want to do both Part Two and Alternate Part Two, they must be two
 * classes. You cannot include the methods from both Part Two and Alternate Part
 * Two in a single class. Do you know why?)
 *
 * <p>//@see ../Proj0511/main.java
 */
public class Money {

    private int dollars;
    private int cents;

    /**
     * Constructor for the dollars and cents.
     * @param dollars dollars
     * @param cents cents
     */
    public Money(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }

    /**
     * Constructor for the dollars and 0 cents.
     * @param dollars dollars
     */
    public Money(int dollars) {
        this.dollars = dollars;
        this.cents = 0;
    }

    /**
     * Constructor initial.
     */
    public Money() {
    }

    /**
     * static method {@code add} for addition of amounts of  money.
     * @param a object a
     * @param b object b
     * @return Return new object
     */
    public static Money add(Money a, Money b) {
        Money r = new Money();
        r.dollars = a.dollars + b.dollars;
        r.cents = a.cents + b.cents;
        if (r.cents >= 100) {
            r.cents -= 100;
            r.dollars += 1;
        }

        return r;
    }

    /**
     * calling object method {@code add} for addition of amounts of  money.
     * @param b object b
     * @return return new object
     */
    public Money add(Money b) {
        Money r = new Money();
        r.dollars = this.dollars + b.dollars;
        r.cents = this.cents + b.cents;
        if (r.cents >= 100) {
            r.cents -= 100;
            r.dollars += 1;
        }

        return r;
    }

    /**
     * Static method {@code minus} for subtraction of amounts of  money.
     * @param a object a
     * @param b object b
     * @return Return new object
     */
    public static Money minus(Money a, Money b) {
        if ((a.dollars + (float) a.cents / 100) < (b.dollars + (float) b.cents / 100)) {
            System.out.println("Fatal Error.");
            System.exit(0);
        }
        Money r = new Money();
        r.dollars = a.dollars - b.dollars;
        r.cents = a.cents - b.cents;
        return r;
    }

    /**
     * calling object method {@code minus} for subtraction of amounts of  money.
     * @param b object b
     * @return Return new object
     */    
    // calling obj method
    public Money minus(Money b) {
        if ((this.dollars + (float) this.cents / 100) < (b.dollars + (float) b.cents / 100)) {
            System.out.println("Fatal Error.");
            System.exit(0);
        }
        Money r = new Money();
        r.dollars = this.dollars - b.dollars;
        r.cents = this.cents - b.cents;
        if (r.cents < 0) {
            r.dollars -= 1;
            r.cents += 100;
        }

        return r;
    }

    /**
     * Void method {@code minus} for subtraction of amounts of  money.
     * @param b object b
     */
    public void minusThisBy(Money b) {
        this.dollars -= b.dollars;
        this.cents -= b.cents;
    }

    /**
     * Test if current is equal to the others.
     * @param others others object
     * @return Return true if both are the same.
     */
    public boolean equal(Money others) {
        return (this.dollars == others.dollars)
                && (this.cents == others.cents);
    }

    /**
     * Print console of String of object.
     * @return String with {} dollars and {} cents
     */
    @Override
    public String toString() {
        return dollars + " dollars & " + cents + " cents";
    }

    /**
     * Set or change the value of {@code dollars}.
     * @param dollars dollars
     */
    public void setDollars(int dollars) {
        this.dollars = dollars;
    }

    /**
     * Set or change the value of {@code cents}.
     * @param cents  cents
     */
    public void setCents(int cents) {
        this.cents = cents;
    }

    /**
     * Call the value of {@code dollars}.
     * @return Return the value
     */
    public int getDollars() {
        return dollars;
    }

    /**
     * Call the value of {@code cents}.
     * @return Return the value of {@code cents}.
     */
    public int getCents() {
        return cents;
    }

    /**
     * main.
     * @param args  args
     */
    public static void main(String[] args) {
        Money m1 = new Money(12, 85), m2 = new Money(12);
        m2.setCents(35);
        System.out.println("m1: " + m1 + "  m2: " + m2);

        System.out.println("m1 + m2: " + add(m1, m2));
        System.out.println("m1 - m2: " + minus(m1, m2));
        System.out.println("m1 + m2: " + m1.add(m2));
        System.out.println("m1 - m2: " + m1.minus(m2));

        System.out.println("m1 is $12.85: " + m1.equal(new Money(12, 85)));
        m1.minusThisBy(m2);
        System.out.println("m1: " + m1 + "  m2: " + m2);
    }
}

/* Sample dislogue
run:
m1: 12 dollars & 85 cents  m2: 12 dollars & 35 cents
m1 + m2: 25 dollars & 20 cents
m1 - m2: 0 dollars & 50 cents
m1 + m2: 25 dollars & 20 cents
m1 - m2: 0 dollars & 50 cents
m1 is $12.85: true
m1: 0 dollars & 50 cents  m2: 12 dollars & 35 cents
BUILD SUCCESSFUL (total time: 0 seconds)
 */
