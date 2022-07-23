package Proj0511;

import Finance.Money;
import MyMath.Rational;

/**
 * Proj0511; For this Programming Project, put your {@code Money} class into a
 * package named {@code Finance}, and put your {@code Rational} class into a
 * package named {@code MyMath}. Your main method should be in a separate
 * package of your choice. Your test code for both classes should be in the main
 * method.
 *
 * <br>Ref: 220613 Absolute Java Chapter5 Programming Projects
 *
 * @see Finance
 * @see MyMath
 * @see main()
 *
 */
public class main {

    /**
     * <b>Sample dialogue</b><pre>
     * antw@Mac-mini chapter5 % pwd
     * /Users/antw/absoluteJ/chapter5/chapter5
     * antw@Mac-mini chapter5 %
     * antw@Mac-mini chapter5 % javaC -d build/classes src/Finance/Money.java
     * antw@Mac-mini chapter5 % javaC -d build/classes src/MyMath/Rational.java
     * antw@Mac-mini chapter5 % java -cp build/classes src/Proj0511/main.java
     * {@code <<<< package Finance.Money >>>}
     * ...
     * antw@Mac-mini chapter5 % javaC -d build/classes -cp build/classes src/Proj0511/main.java
     * antw@Mac-mini chapter5 % cd build/classes
     * antw@Mac-mini classes % java Proj0511/main
     * {@code <<< package Finance.Money >>>}
     * m1: 12 dollars & 85 cents  m2: 12 dollars & 35 cents
     * m1 + m2: 25 dollars & 20 cents
     * m1: 12 dollars & 85 cents  m2: 12 dollars & 35 cents
     *
     * {@code <<< package MyMath.Rational >>>}
     * n1: -64/2  n2: 1/2 n4: -1/2  n5: 3/4
     * divide(n4, n5)   : -2/3
     * antw@Mac-mini classes % cd ../..
     * antw@Mac-mini chapter5 % pwd
     * /Users/antw/absoluteJ/chapter5/chapter5
     * antw@Mac-mini chapter5 % </pre>
     * <p>
     * <b>JavaDoc</b><pre>
     * <blockquote>
     * javadoc -d [DESTINATION_FOLDER] -sourcepath [SOURCE_FOLDER] -subpackages [PACKAGE1]:[PACKAGE2]
     * </blockquote>
     * antw@Mac-mini chapter5 % pwd
     * /Users/antw/absoluteJ/chapter5
     * antw@Mac-mini chapter5 % javadoc -d Proj0511Doc -sourcepath
     *      ~/absoluteJ/chapter5/chapter5/src -subpackages Proj0511:Finance:MyMath
     * </pre>
     */
    public static void main(String[] args) {
        System.out.println("<<< package Finance.Money >>>");
        Money m1 = new Money(12, 85), m2 = new Money(12);
        m2.setCents(35);
        System.out.println("m1: " + m1 + "  m2: " + m2);

        System.out.println("m1 + m2: " + Money.add(m1, m2));
        System.out.println("m1: " + m1 + "  m2: " + m2);

        System.out.println("\n<<< package MyMath.Rational >>>");
        Rational n1 = new Rational(64, -2), n2 = new Rational(2, 4), n3,
                n4 = new Rational(1, -2), n5 = new Rational(3, 4), n6;
        n2 = Rational.LowestTerm(n2);
        System.out.println("n1: " + n1 + "  n2: " + n2 + " n4: " + n4
                + "  n5: " + n5);

        System.out.println("divide(n4, n5)   : " + Rational.divide(n4, n5));
    }
}
