
/** 220605
 * Chapter5 Programming Projects
 * for Team.java
 * 6.
 * Part One: Define a class for rational numbers. A rational number is a number that
 * can be represented as the quotient of two integers. For example,  1/2, 3/4, 64/2,
 * and so forth are all rational numbers. (By 1/2 and so forth, we mean the everyday
 * meaning of the fraction, not the integer division this expression would produce in
 * a Java program.) Represent rational numbers as two values of type int, one for
 * the numerator and one for the denominator. Your class should have two instance
 * variables of type `int`. Call the class `Rational`. Include a constructor with two
 * arguments that can be used to set the instance variables of an object to any values.
 * Also include a constructor that has only a single parameter of type `int`; call this
 * single parameter `wholeNumber` and define the constructor so that the object will
 * be initialized to the rational number `wholeNumber/1`. Also include a no-argument
 * constructor that initializes an object to 0 (that is, to 0/1). Note that the numerator,
 * the denominator, or both may contain a minus sign. Define methods for addition,
 * subtraction, multiplication, and division of objects of your class `Rational`. These
 * methods should be static methods that each have two parameters of type `Rational`
 * and return a value of type `Rational`. For example, `Rational.add(r1, r2)` will
 * return the result of adding the two rational numbers (two objects of the class
 * `Rational`, `r1` and `r2`).Define accessor and mutator methods as well as the methods
 * `equals` and `toString`. You should include a method to normalize the sign of the
 * rational number so that the denominator is positive and the numerator is either
 * positive or negative. For example, after normalization, 4/-8 would be represented
 * the same as -4/8. Also write a test program to test your class.
 * Hints: Two rational numbers a/b and c/d are equal if a*d equals c*b .
 * Part Two: Add a second version of the methods for addition, subtraction, multi-
 * plication, and division. These methods should have the same names as the static
 * version but should use a calling object and a single argument. For example, this
 * version of the add method (for addition) has a calling object and one argument. So
 * `r1.add(r2`) returns the result of adding the rationals r1 and r2. Note that your
 * class should have all these methods; for example, there should be two methods
 * named `add`.
 * Alternate Part Two: Add a second version of the methods for addition, subtraction,
 * multiplication, and division. These methods should have the same names as the
 * static version but should use a calling object and a single argument. The methods
 * should be `void` methods. The result is given as the changed value of the calling
 * object. For example, this version of the add method (for addition) has a calling
 * object and one argument. Therefore,
 * `r1.add(r2)`;
 * changes the values of the instance variables of `r1` so they represent the result of
 * adding `r2` to the original version of `r1`. Note that your class should have all these
 * methods; for example, there should be two methods named `add`.
 * (If you want to do both Part Two and Alternate Part Two, they must be two
 * classes. You cannot include the methods from both Part Two and Alternate Part
 * Two in a single class. Do you know why?)
 */
public class Rational {

    private int num; // numerator
    private int den; // denominator

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDen() {
        return den;
    }

    public void setDen(int den) {
        this.den = den;

        if (this.notANumber()) {
            System.out.println("Fatal Error");
            System.exit(0);
        }
    }

    public void setRational(int num, int den) {
        this.num = num;
        this.den = den;

        if (this.notANumber()) {
            System.out.println("Fatal Error");
            System.exit(0);
        }

        this.normalize();
    }

    public Rational(int num, int den) {
        this.num = num;
        this.den = den;

        if (this.notANumber()) {
            System.out.println("Fatal Error");
            System.exit(0);
        }

        this.normalize();
    }

    /**
     * @param wholeNumber
     */
    public Rational(int wholeNumber) {
        this.num = wholeNumber;
        this.den = 1;
    }

    public Rational() {
        this.num = 0;
        this.den = 1;
    }

    public static Rational add(Rational r1, Rational r2) {
        Rational rt = new Rational();
        rt.num = r1.num * r2.den + r2.num * r1.den;
        rt.den = r1.den * r2.den;
        rt = LowestTerm(rt);
        return rt;
    }

    public Rational add(Rational r2) {
        Rational rt = new Rational();
        rt.num = this.num * r2.den + r2.num * this.den;
        rt.den = this.den * r2.den;
        rt = LowestTerm(rt);
        return rt;
    }

    public static Rational minus(Rational r1, Rational r2) {
        Rational rt = new Rational();
        rt.num = r1.num * r2.den - r2.num * r1.den;
        rt.den = r1.den * r2.den;
        rt = LowestTerm(rt);
        return rt;
    }

    public Rational minus(Rational r2) {
        Rational rt = new Rational();
        rt.num = this.num * r2.den - r2.num * this.den;
        rt.den = this.den * r2.den;
        rt = LowestTerm(rt);
        return rt;
    }

    public static Rational multiply(Rational r1, Rational r2) {
        Rational rt = new Rational();
        rt.num = r1.num * r2.num;
        rt.den = r1.den * r2.den;
        rt = LowestTerm(rt);
        return rt;
    }

    public Rational multiply(Rational r2) {
        Rational rt = new Rational();
        rt.num = this.num * r2.num;
        rt.den = this.den * r2.den;
        rt = LowestTerm(rt);
        return rt;
    }

    // static method for division
    public static Rational divide(Rational r1, Rational r2) {
        Rational rt = new Rational();
        rt.num = r1.num * r2.den;
        rt.den = r1.den * r2.num;
        rt = LowestTerm(rt);
        return rt;
    }

    // calling object method for division
    public Rational divide(Rational r2) {
        Rational rt = new Rational();
        rt.num = this.num * r2.den;
        rt.den = this.den * r2.num;
        rt = LowestTerm(rt);
        return rt;
    }

    // void method for division
    public void divideThisBy(Rational r2) {
        this.num = this.num * r2.den;
        this.den = this.den * r2.num;
        LowestTerm(this);
    }

    public boolean equals(Rational other) {
        return (this.num * other.den == other.num * this.den);
    }

    public String toString() {
        return num + "/" + den;
    }

    // to normalize the sign of the rational number so that the denominator is 
    // positive and the numerator is either positive or negative.
    private void normalize() {
        if ((this.num < 0) && (this.den < 0)) {
            this.num = 0 - num;
            this.den = 0 - den;
        } else if ((this.num > 0) && (this.den < 0)) {
            this.num = 0 - num;
            this.den = 0 - den;
        }
    }

    public static Rational LowestTerm(Rational t) {
        int i = 2;
        while (i <= Math.abs(t.num)) {
            while ((t.num % i == 0) && (t.den % i == 0)) {
                t.num /= i;
                t.den /= i;
            }
            i++;
        }
        return t;
    }

    private boolean notANumber() {
        return this.den == 0;
    }

    public static void main(String[] args) {
        Rational n1 = new Rational(64, -2), n2 = new Rational(2, 4), n3,
                n4 = new Rational(1, -2), n5 = new Rational(3, 4), n6;
        n2 = Rational.LowestTerm(n2);
        System.out.println("n1: " + n1 + "  n2: " + n2 + " n4: " + n4
                + "  n5: " + n5);

        System.out.println("add(n1,n2)  : " + add(n1, n2));
        System.out.println("n1.add(n2)  : " + n1.add(n2));

        System.out.println("minus(n1,n2): " + minus(n1, n2));
        System.out.println("n1.minus(n2): " + n1.minus(n2));

        System.out.println("multiply(n4, n5): " + multiply(n4, n5));
        System.out.println("n4.multiply(n5) : " + n4.multiply(n5));

        System.out.println("divide(n4, n5   : " + divide(n4, n5));
        System.out.println("n4.divide(n5)   : " + (n6 = n4.divide(n5)));
        n4.divideThisBy(n5);
        System.out.println("n4.divideThisBy(n5): " + n4);

        n3 = new Rational();
        n3.setRational(-4, 6);
        System.out.println(n6 + " equal " + n3 + " : " + n6.equals(n3));

    }
}

/* Sample dialogue
run:
n1: -64/2  n2: 1/2 n4: -1/2  n5: 3/4
add(n1,n2)  : -63/2
n1.add(n2)  : -63/2
minus(n1,n2): -65/2
n1.minus(n2): -65/2
multiply(n4, n5): -3/8
n4.multiply(n5) : -3/8
divide(n4, n5   : -2/3
n4.divide(n5)   : -2/3
n4.divideThisBy(n5): -2/3
-2/3 equal -4/6 : true
BUILD SUCCESSFUL (total time: 0 seconds)
*/
