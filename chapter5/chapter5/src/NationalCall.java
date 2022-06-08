
/** 220607
 * Absolute Java
 * Chapter5 Programming Projects
 * . extend to InternationalCall.java
 * 7. Create a class to represent the phone billing system. For this purpose, you need to
 * define two classes namely, `NationalCall` and `InternationalCall`.
 * Define the `NationalCall` with the following attributes. You can include your own
 * attributes also, if required.
 *  a. Source phone number
 *  b. Destination phone number
 *  c. Total duration of current call in seconds
 *  d. Total duration of all call
 *  e. Current call price
 *  f. Total price of all calls
 * Include a constructor that constructs a `NationalCall` object from the parameters for:
 *  a. Source phone number
 *  b. Destination phone number
 *  c. Total duration of current call in seconds
 * The `InternationalCall` class is defined with the following additional attributes
 * apart from the attributes of `NationalCall` class.
 *  a. Source phone number Country code
 *  b. Destination phone number Country code
 * The following table shows call rates as per the call durations.
 *  Call Duration               National Call Rates     International Call Rates
 *  less or equal First minute                              0.20 $      0.60 $
 *  more thanFirst Minute and less or equal second minute   0.15 $      0.40 $
 *  more than second minute                                 0.10 $      0.20 $
 *
 * Also, define a method as `DiscountCall` that will calculate the discount provided
 * to the customer depending upon the duration of the call. The discount rates are
 * different for national and international calls. The table below shows some of the
 * sample values for the discount offer.
 *                                                National Call    International Call
 *                                              Discounted on Call  Discounted Number
 *  Total duration if all calls                             Price    of Call Units
 *  less or equal First minute                              0.20 $      0.60 $
 *  more thanFirst Minute and less or equal second minute   0.15 $      0.40 $
 *  more than second minute                                 0.10 $      0.20 $
 *
 * Write a suitable constructor that will initialize all data members and construct the
 * objects for the class.
 * Write a suitable method to display the details of `NationalCall` and `Interna-
 * tionalCall` class. Define the main method class to test and implement the code.
 */
import java.text.DecimalFormat;

public class NationalCall {

    DecimalFormat cents = new DecimalFormat("$0.00");

    private static final double RATE_1ST_MINUTE = 0.20; // per minute
    private static final double RATE_2ND_MINUTE = 0.15;
    private static final double RATE_3RD_MINUTE = 0.10;
    private static final double DISCOUNT_2ND_MINUTE = 0.05; // 5%
    private static final double DISCOUNT_3RD_MINUTE = 0.07; // 7%

    private String sourceNum; // Source phone number
    private String destineNum; // Destination phone number
    private int currentDuration; // Total duration of current call in seconds
    private int totalDurations = 0; // Total duration of all call
    private double callPrice; // Current call price
    private double allPrice = 0; // Total price of all calls

    public void setDestineNum(String destineNum) {
        this.destineNum = destineNum;
    }

    public void setCurrentDuration(int currentDuration) {
        this.currentDuration = currentDuration;
        this.callPrice = callPrice();
    }

    public NationalCall(String sourceNum, String destineNum) {
        this.sourceNum = sourceNum;
        this.destineNum = destineNum;
        this.currentDuration = 0;
        this.callPrice = 0;
    }

    public NationalCall(String sourceNum, String destineNum, int currentDuration) {
        this.sourceNum = sourceNum;
        this.destineNum = destineNum;
        this.currentDuration = currentDuration;
        this.callPrice = callPrice();
    }

    private double callPrice() {
        if (currentDuration <= 60) {
            return currentDuration * RATE_1ST_MINUTE / 60;
        } else if (currentDuration <= 120) {
            return currentDuration * RATE_2ND_MINUTE / 60;
        } else {
            return currentDuration * RATE_3RD_MINUTE / 60;
        }
    }

    private void discountPrice() {
        if (currentDuration <= 60) {
            this.callPrice = callPrice;
        } else if (currentDuration <= 120) {
            this.callPrice = callPrice - callPrice * DISCOUNT_2ND_MINUTE;
        } else {
            this.callPrice = callPrice - callPrice * DISCOUNT_3RD_MINUTE;
        }
    }

    private void setTotal() {
        this.totalDurations += this.currentDuration;
        this.allPrice += this.callPrice;
    }

    public void tabulatePrice() {
        this.discountPrice();
        this.setTotal();
    }

    @Override
    public String toString() {
        return sourceNum + " to " + destineNum + "\t" + currentDuration
                + "\t" + cents.format(allPrice);
    }

    public void displayDetail() {
        System.out.println("Source phone number: " + sourceNum + "\n"
                + "Destination phone number: " + destineNum + "\n"
                + "Total duration of current call in seconds: " + currentDuration + "\n"
                + "Total duration of all call: " + totalDurations + "\n"
                + "Current call price: " + cents.format(callPrice) + "\n"
                + "Total price of all calls: " + cents.format(allPrice));
    }

    public static void PrintHeader() {
        System.out.println("Billing for National Call/ International Call");
        System.out.printf("%-15s %-15s %10s %10s %n", "SourceNum", "DestineNum",
                "Duration", "Price");
    }

    public void printCurrent() {
        System.out.printf("%-15s %-15s %10d %10.2f %n", sourceNum, destineNum,
                currentDuration, callPrice);
    }

    public void printTotal() {
        System.out.printf("%-15s %-15s %10d %10.2f %n%n", "Total", "",
                totalDurations, allPrice);
    }

    public static void main(String[] args) {
        InternationalCall.main(args);
    }
}
