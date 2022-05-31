
/** 220530
 * Absolute Java
 * Chapter5 Programming Projects
 * 2. Define a class called Fraction. This class is used to represent a ratio of
 * two integers. Include mutator methods that allow the user to set the
 * numerator and the denominator. Also include a method that displays the
 * fraction on the screen as a ratio (e.g., 5/9). This method does not need to
 * reduce the fraction to lowest terms.
 * Include an additional method, equals, that takes as input another Fraction
 * and returns true if the two fractions are identical and false if they are
 * not. This method should treat the fractions reduced to lowest terms; that is,
 * if one fraction is 20/60 and the other is 1/3, then the method should return
 * true.
 * Embed your class in a test program that allows the user to create a fraction.
 * Then the program should loop repeatedly until the user decides to quit.
 * Inside the body of the loop, the program should allow the user to enter a
 * target fraction into an anonymous object and learn whether the fractions are
 * identical.
 */
import java.util.Scanner;
import java.util.StringTokenizer;

public class Fraction {

    private int num; // numerator
    private int den; //denominator

    public Fraction(int num, int den) {
        this.num = num;
        this.den = den;
    }

    public void setNumerator(int numerator) {
        this.num = numerator;
    }

    public void setDenominator(int denominator) {
        this.den = denominator;
    }

    @Override
    public String toString() {
        return num + "/" + den;
    }

    //treat the fractions reduced to lowest terms
    public boolean equals(Fraction other) {
        // get ratio of both sides numerators against ratio of denomrators
        return ((float) other.den / this.den == (float) other.num / this.num);
    }

    public static String keyboardInput() {
        System.out.println("Enter a fraction (eg 1/3):");
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextLine();
    }

    public static Fraction fractionToInt(String inputLine) {
        String delimiters = "/, ";
        StringTokenizer factory = new StringTokenizer(inputLine, delimiters);

        int token, n = 1, d = 1;
        if (factory.hasMoreTokens()) {
            token = Integer.parseInt(factory.nextToken());
            n = token;
        }
        if (factory.hasMoreTokens()) {
            token = Integer.parseInt(factory.nextToken());
            d = token;
        }
        return new Fraction(n, d);
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String cont;
        boolean toContinue;
        do {

            System.out.print("Object: ");
            Fraction f = fractionToInt(keyboardInput());

            System.out.print("Target: ");
            Fraction g = fractionToInt(keyboardInput());

            if (f.equals(g)) {
                System.out.println(f + " is equal to " + g);
            } else {
                System.out.println(f + " is NOT equal to " + g);
            }

            System.out.println("To continue: 'Y'?");
            cont = keyboard.next();
            toContinue = cont.equalsIgnoreCase("Y");
        } while (toContinue);

    }

}
/* Sample dialogue
antw@Mac-mini chapter5 % cd chapter5
antw@Mac-mini chapter5 % javac -d build/classes src/*.java
antw@Mac-mini chapter5 % cd build/classes
antw@Mac-mini classes % java main
Object: Enter a fraction (eg 1/3):
20/60
Target: Enter a fraction (eg 1/3):
1/3
20/60 is equal to 1/3
To continue: 'Y'?
n
antw@Mac-mini classes % 
 */
