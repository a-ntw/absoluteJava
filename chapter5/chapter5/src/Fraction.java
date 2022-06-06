
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

public class Fraction {

    private int num; // numerator
    private int den; // denominator

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

    public static Fraction LowestTerm(Fraction t) {
        if (!t.fractionOk()) {
            System.out.println("Fatal Error");
            System.exit(0);
        }
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

    public boolean fractionOk() {
        return (this.num < this.den);
    }

    public boolean equals(Fraction other) {

        return (this.num * other.den == other.num * this.den);
    }

    public static Fraction keyboardInput() {
        Scanner keyboard = new Scanner(System.in);
        Fraction obj = new Fraction();

        System.out.println("Enter the numerator:");
        obj.setNumerator(keyboard.nextInt());
        System.out.println("Enter the denominator:");
        obj.setDenominator(keyboard.nextInt());
        System.out.println("You enter fraction: " + obj);

        return obj;
    }

    public static void main(String[] args) {
        Fraction a = new Fraction();
        a.setNumerator(40);
        a.setDenominator(60);
        System.out.print(a + " = ");
        System.out.println(LowestTerm(a));

        Scanner keyboard = new Scanner(System.in);
        String cont;
        boolean toContinue;

        System.out.println("To create a fraction");
        Fraction obj = keyboardInput();

        do {
            System.out.println("The target fraction:");
            if (obj.equals(keyboardInput())) {
                System.out.println(" is identical to " + obj);
            } else {
                System.out.println(" is NOT identical to " + obj);
            }

            System.out.println("To continue: 'Y'?");
            cont = keyboard.next();
            toContinue = cont.equalsIgnoreCase("Y");
        } while (toContinue);
    }
}

/* Sample dialogue
antw@Mac-mini absoluteJava % java chapter5/chapter5/src/Fraction.java
40/60 = 2/3
To create a fraction
Enter the numerator:
1
Enter the denominator:
3
You enter fraction: 1/3
The target fraction:
Enter the numerator:
20
Enter the denominator:
61
You enter fraction: 20/61
1/3 is NOT identical to 20/61
To continue: 'Y'?
y
The target fraction:
Enter the numerator:
20
Enter the denominator:
60
You enter fraction: 20/60
1/3 is identical to 20/60
To continue: 'Y'?
n
 */
