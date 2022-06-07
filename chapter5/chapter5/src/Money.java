
/** 220603
 * Absolute Java
 * Chapter5 Programming Projects
 * 5. Part One: Define a class named `Money` whose objects represent amounts of
 * U.S. money. The class should have two instance variables of type `int` for the
 * dollars and cents in the amount of money. Include a constructor with two
 * parameters of type `int` for the dollars and cents, one with one constructor of
 * type `int` for an amount of dollars with zero cents and a no-argument
 * constructor. Include the methods `add` and `minus` for addition and subtraction
 * of amounts of money. These methods should be static methods, should each have
 * two parameters of type `Money`, and return a value of type `Money`. Include a
 * reasonable set of accessor and mutator methods as well as the methods `equals`
 * and `toString`. Write a test program for your class.
 * Part Two: Add a second version of the methods for addition and subtraction.
 * These methods should have the same names as the static version but should use
 * a calling object and a single argument. For example, this version of the add
 * method (for addition) has a calling object and one argument. So `m1.add(m2)`
 * returns the result of adding the Money objects `m1` and `m2`. Note that your
 * class should have all these methods; for example, there should be two methods
 * named `add`.
 * Alternate Part Two: Add a second version of the methods for addition and
 * subtraction. These methods should have the same names as the static version
 * but should use a calling object and a single argument. The methods should be
 * `void` methods. The result should be given as the changed value of the
 * calling object. For example, this version of the add method (for addition)
 * has a calling object and one argument. Therefore,
 *  `m1.add(m2);`
 * changes the values of the instance variables of `m1` so they represent the
 * result of adding `m2` to the original version of `m1`. Note that your class
 * should have all these methods; for example, there should be two methods named
 * `add`.
 * (If you want to do both Part Two and Alternate Part Two, they must be two
 * classes. You cannot include the methods from both Part Two and Alternate Part
 * Two in a single class. Do you know why?)
 *
 */
public class Money {

    private int dollars;
    private int cents;

    public Money(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }

    public Money(int dollars) {
        this.dollars = dollars;
        this.cents = 0;
    }

    public Money() {
    }

    public static Money add(Money a, Money b) {
        Money r = new Money();
        r.dollars = a.dollars + b.dollars;
        r.cents = a.cents + b.cents;
        if (r.cents >= 100 ) {
            r.cents -= 100;
            r.dollars += 1;
        }
        
        return r;
    }

    public Money add(Money b) {
        Money r = new Money();
        r.dollars = this.dollars + b.dollars;
        r.cents = this.cents + b.cents;
        if (r.cents >= 100 ) {
            r.cents -= 100;
            r.dollars += 1;
        }
        
        return r;
    }

    // static method
    public static Money minus(Money a, Money b) {
        if ((a.dollars + (float)a.cents/100) < (b.dollars + (float)b.cents/100)) {
            System.out.println("Fatal Error.");
            System.exit(0);
        }
        Money r = new Money();
        r.dollars = a.dollars - b.dollars;
        r.cents = a.cents - b.cents;
        return r;
    }

    // calling obj method
    public Money minus(Money b) {
        if ((this.dollars + (float)this.cents/100) < (b.dollars + (float)b.cents/100)) {
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

    // void method
    public void minusThisBy(Money b) {
        this.dollars -= b.dollars;
        this.cents -= b.cents;
    }

    public boolean equal(Money others) {
        return (this.dollars == others.dollars)
                && (this.cents == others.cents);
    }

    @Override
    public String toString() {
        return dollars + " dollars & " + cents + " cents";
    }

    public void setDollars(int dollars) {
        this.dollars = dollars;
    }

    public void setCents(int cents) {
        this.cents = cents;
    }

    public int getDollars() {
        return dollars;
    }

    public int getCents() {
        return cents;
    }

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
