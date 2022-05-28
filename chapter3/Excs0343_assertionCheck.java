
/** 220403
 * Absolute Java
 * chapter3
 * .
 * 43. Write an assertion check that checks to see that the value of the
 * variable time is less than or equal to the value of the variable limit.
 * Both variables are of type int.
 */

/**
 *
 * @author antw
 */
public class Excs0343_assertionCheck {

    public static void main(String args[]) {

        int limit = 9;

        int time = 0;
        System.out.println("\nlimit: " + limit + "\ttime: " + time);
        System.out.println("time <= limit is " + (time <= limit));
        assert (time <= limit);

        time = 10;
        System.out.println("\nlimit: " + limit + "\ttime: " + time);
        System.out.println("time <= limit is " + (time <= limit));
        assert (time <= limit);
    }
}

/* Sample Dialogue
antw@Mac-mini chapter3 % java -enableassertions Excs0343_assertionCheck.java

limit: 9	time: 0
time <= limit is true

limit: 9	time: 10
time <= limit is false
Exception in thread "main" java.lang.AssertionError
	at Excs0343_assertionCheck.main(Excs0343_assertionCheck.java:28)
antw@Mac-mini chapter3 % 
*/
