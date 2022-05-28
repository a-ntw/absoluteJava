
/** 220507
 * Absolute Java
 * Chapter3 Programming Projects
 * 5. You have just purchased a stereo system that cost $1,000 on the following
 * credit plan: no down payment, an interest rate of 18% per year (and hence
 * 1.5% per month), and monthly payments of $50. The monthly payment of $50 is
 * used to pay the interest, and whatever is left is used to pay part of the
 * remaining debt. Hence, the first month you pay 1.5% of $1,000 in interest.
 * That is $15 in interest. So, the remaining $35 is deducted from your debt,
 * which leaves you with a debt of $965.00. The next month, you pay interest of
 * 1.5% of $965.00, which is $14.48. Hence, you can deduct $35.52 (which is
 * $50 – $14.48) from the amount you owe.
 * Write a program that tells you how many months it will take you to pay off
 * the loan, as well as the total amount of interest paid over the life of the
 * loan. Use a loop to calculate the amount of interest and the size of the debt
 * after each month. (Your final program need not output the monthly amount of
 * interest paid and remaining debt, but you may want to write a preliminary
 * version of the program that does output these values.) Use a variable to
 * count the number of loop iterations and hence, the number of months until the
 * debt is zero. You may want to use other variables as well. The last payment
 * may be less than $50 if the debt is small, but do not forget the interest. If
 * you owe $50, your monthly payment of $50 will not pay off your debt, although
 * it will come close. One month’s interest on $50 is only 75 cents.
 */
public class Proj0305_monthlyPayment {

    public static void main(String args[]) {

        int sno, mthPay = 50;
        double loanAmt = 1000;
        double interest, mthRate = 1.5;
        System.out.printf("Loan amount ($): %.2f %n", loanAmt);
        System.out.println("Monthly Interest (%): " + mthRate);
        System.out.println("Monthly payment: ($): " + mthPay);

        //System.out.printf("%-5s %15s %15s %n", "No.", "Interest", "Remaining");
        sno = 0;
        while (loanAmt > mthPay) {
            interest = loanAmt * mthRate / 100;
            loanAmt = loanAmt + interest - mthPay;
            sno++;
            //System.out.printf("%-5d %15.2f %15.2f %n", sno, interest, loanAmt);
        }

        interest = loanAmt * mthRate / 100;
        System.out.printf("Last payment : $%.2f, and Interest: $%.2f %n",
                loanAmt, interest);
        System.out.printf("Final payment: $%.2f %n", loanAmt + interest);
        System.out.println("Total months to pay off the loan: " + (sno + 1));
    }
}

/* Sample Dialogue
Loan amount ($): 1000.00 
Monthly Interest (%): 1.5
Monthly payment: ($): 50
Last payment : $47.12, and Interest: $0.71 
Final payment: $47.83 
Total months to pay off the loan: 24
 */
