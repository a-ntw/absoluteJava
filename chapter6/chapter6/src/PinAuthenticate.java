
/* 220616 Absolute Java  Chapter6 Programming Projects. Proj0614 */
import java.util.Scanner;

/**
 * Traditional password entry schemes are susceptible to “shoulder surfing” in
 * which an attacker watches an unsuspecting user enter his or her password or
 * PIN number and uses it later to gain access to the account. One way to combat
 * this problem is with a randomized challenge-response system. In these
 * systems, the user enters different information every time based on a secret
 * in response to a randomly generated challenge. Consider the following scheme
 * in which the password consists of a five-digit PIN number (00000 to 99999).
 * Each digit is assigned a random number that is 1, 2, or 3. The user enters
 * the random numbers that correspond to their PIN instead of their actual PIN
 * numbers.<p>
 * For example, consider an actual PIN number of 12345. To authenticate it, the
 * user would be presented with a screen such as the following: <blockquote>{@code
 *      PIN: 0 1 2 3 4 5 6 7 8 9
 *      NUM: 3 2 3 1 1 3 2 2 1 3 }</blockquote>
 * The user would enter 23113 instead of 12345. This does not divulge the
 * password even if an attacker intercepts the entry because 23113 could
 * correspond to other PIN numbers, such as 69440 or 70439. The next time the
 * user logs in, a different sequence of random numbers would be generated, such
 * as the following: <blockquote>{@code
 *      PIN: 0 1 2 3 4 5 6 7 8 9
 *      NUM: 1 1 2 3 1 2 2 3 3 3 }</blockquote>
 * Your program should simulate the authentication process. Store an actual PIN
 * number in your program. The program should use an array to assign random
 * numbers to the digits from 0 to 9. Output the random digits to the screen,
 * input the response from the user, and output whether or not the user’s
 * response correctly matches the PIN number.
 */
public class PinAuthenticate {

    private static final String PIN = "12345";
    public int[] assign = new int[10];
    public String keyIn;

    public static void main(String[] args) {
        PinAuthenticate a = new PinAuthenticate();
        a.assignRandomNum();
        a.display();
        a.userKeyboard();
        if (a.authenticate()) {
            System.out.println("Correct.");
        } else {
            System.out.println("Wrong password,");
        }
    }

    /**
     * assign 1,2 or 3 to the assign array
     */
    public void assignRandomNum() {
        for (int i = 0; i < 10; i++) {
            assign[i] = (int) (Math.random() * 3) + 1;
        }
    }

    public void display() {
        System.out.print("PIN: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        System.out.print("NUM: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + assign[i]);
        }
        System.out.println();
    }

    public void userKeyboard() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Key in the " + PIN.length() + " NUMs:");
        keyIn = keyboard.next();

        if (!userKeyInOK()) {
            System.exit(0);
        }
    }

    public boolean authenticate() {
        int lgth = PIN.length(), pinDigit, userDigit;
        char ch;

        for (int i = 0; i < lgth; i++) {
            ch = PIN.charAt(i);
            pinDigit = Integer.parseInt(ch + "");

            ch = keyIn.charAt(i);
            userDigit = Integer.parseInt(ch + "");

            if (!comapareAssignIndex(pinDigit, userDigit)) {
                return false;
            }
        }
        return true;
    }

    private boolean comapareAssignIndex(int actualPinDigit, int UserDigit) {

        // actualPin digit is position of assignNum
        int assignedNum = assign[actualPinDigit];

        return assignedNum == UserDigit;
    }

    private boolean userKeyInOK() {
        if (keyIn.length() == PIN.length()) {
            for (int i = 0; i < keyIn.length(); i++) {
                char ch = keyIn.charAt(i);
                if (Character.isAlphabetic(ch)) {
                    System.out.println("Password can only contain numeric");
                    return false;
                }
            }
            return true;
        }
        System.out.println("Password requite " + PIN.length() + " numeric digits");
        return false;
    }

}

/* Sample dialogue
run:
PIN:  0 1 2 3 4 5 6 7 8 9
NUM:  1 2 1 3 3 3 1 3 2 1
Key in the 5 NUMs:
21333
Correct.
BUILD SUCCESSFUL (total time: 8 seconds)
 */
