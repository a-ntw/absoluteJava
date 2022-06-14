
/** 220608
 * Absolute Java
 * Chapter5 Programming Projects
 * 7. refer to NationalCall.java
 */
import java.text.DecimalFormat;

public class InternationalCall {

    DecimalFormat cents = new DecimalFormat("$0.00");

    private static final double RATE_1ST_MINUTE = 0.60; // per minute
    private static final double RATE_2ND_MINUTE = 0.40;
    private static final double RATE_3RD_MINUTE = 0.20;
    private static final double DISCOUNT_2ND_MINUTE = 0.08; // 8%
    private static final double DISCOUNT_3RD_MINUTE = 0.10; // 10%

    private String srcCountryCode; // Source phone number Country code
    private String sourceNum; // Source phone number
    private String desCountryCode; // Destination phone number Country code
    private String destineNum; // Destination phone number
    private int currentDuration; // Total duration of current call in seconds
    private int totalDurations; // Total duration of all call
    private double callPrice; // Current call price
    private double allPrice; // Total price of all calls

    public void setDestineCodeNNum(String desCountryCode, String destineNum) {
        this.desCountryCode = desCountryCode;
        this.destineNum = destineNum;
    }

    public void setCurrentDuration(int currentDuration) {
        this.currentDuration = currentDuration;
        this.callPrice = callPrice();
    }

    public InternationalCall(String srcCountryCode, String sourceNum,
            String desCountryCode, String destineNum) {
        this.srcCountryCode = srcCountryCode;
        this.sourceNum = sourceNum;
        this.desCountryCode = desCountryCode;
        this.destineNum = destineNum;
        this.currentDuration = 0;
        this.callPrice = 0;
    }

    public InternationalCall(String srcCountryCode, String sourceNum,
            String desCountryCode, String destineNum, int currentDuration) {
        this.srcCountryCode = srcCountryCode;
        this.sourceNum = sourceNum;
        this.desCountryCode = desCountryCode;
        this.destineNum = destineNum;
        this.currentDuration = currentDuration;
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
        return this.srcCountryCode + " " + sourceNum + " to "
                + this.desCountryCode + " " + destineNum + "\t" + currentDuration
                + "\t" + cents.format(allPrice);
    }

    public void displayDetail() {
        System.out.println("Source phone number: " + srcCountryCode + " " + sourceNum + "\n"
                + "Destination phone number: " + desCountryCode + " " + destineNum + "\n"
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
        System.out.printf("%-15s %-15s %10d %10.2f %n",(srcCountryCode + " " + sourceNum), (desCountryCode + " "
                + destineNum), currentDuration, callPrice);
    }

    public void printTotal() {
        System.out.printf("%-15s %-15s %10d %10.2f %n%n", "Total", "",
                totalDurations, allPrice);
    }
    
    public static void main(String[] args) {
        
        NationalCall a = new NationalCall("6543210", "6543211", 60);
        NationalCall.PrintHeader();
        a.tabulatePrice(); a.printCurrent();

        a.setCurrentDuration(120);
        a.tabulatePrice(); a.printCurrent();

        a.setCurrentDuration(180); a.setDestineNum("6512311");
        a.tabulatePrice(); a.printCurrent(); a.printTotal();
        
        InternationalCall b = new InternationalCall("+65", "6543210", "001 12",
                 "12345");
        InternationalCall.PrintHeader();
        b.setCurrentDuration(60);
        b.tabulatePrice(); b.printCurrent(); 
        b.setCurrentDuration(120);
        b.tabulatePrice(); b.printCurrent();
        b.setCurrentDuration(180); b.setDestineCodeNNum("123","54321");
        b.tabulatePrice(); b.printCurrent(); 
        b.printTotal();
        
        b.displayDetail();
    }
}

/* Sample dialogue
run:
Billing for National Call/ International Call
SourceNum       DestineNum        Duration      Price 
6543210         6543211                 60       0.20 
6543210         6543211                120       0.29 
6543210         6512311                180       0.28 
Total                                  360       0.76 

Billing for National Call/ International Call
SourceNum       DestineNum        Duration      Price 
+65 6543210     001 12 12345            60       0.60 
+65 6543210     001 12 12345           120       0.74 
+65 6543210     123 54321              180       0.54 
Total                                  360       1.88 

Source phone number: +65 6543210
Destination phone number: 123 54321
Total duration of current call in seconds: 180
Total duration of all call: 360
Current call price: $0.54
Total price of all calls: $1.88
BUILD SUCCESSFUL (total time: 0 seconds)
*/