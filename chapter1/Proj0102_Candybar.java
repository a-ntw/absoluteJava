
/** 20220326
 * Absolute Java
 * Chapter1 Programming Projects
 * 2. The video game machines at your local arcade output coupons according to
 * how well you play the game. You can redeem 10 coupons for a candy bar or
 * 3 coupons for a gumball. You prefer candy bars to gumballs.
 * Write a program that defines a variable initially assigned to the number
 * of coupons you win.
 * Next, the program should output how many candy bars and gumballs you can
 * get if you spend all of your coupons on candy bars first, and any remaining
 * coupons on gumballs.
 */
public class Proj0102_Candybar {

    public static final int CANDY_COUPONS = 10;
    public static final int GUMBALL_COUPONS = 10;

    public static void main(String args[]) {
        int couponsYouWon = 21;
        System.out.println("No of coupons you won is " + couponsYouWon);
        System.out.println("No of candy bar you can is "
                + couponsYouWon / CANDY_COUPONS);
        System.out.println("and remaining for gumballs is "
                + couponsYouWon % GUMBALL_COUPONS);
    }
}

/* Sample Dialogue
No of coupons you won is 21
No of candy bar you can is 2
and remaining for gumballs is 1
 */
