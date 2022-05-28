
/** 220526
 * Absolute Java
 * Chapter4
 * 14. A comma-separated values (CSV) file is a simple text format used to store
 * a list of records. A comma is used as a delimiter to separate the fields for
 * each record. This format is commonly used to transfer data between a
 * spreadsheet or database. In this Programming Project, consider a store that
 * sells five products abbreviated as A, B, C, D, and E. Customers can rate each
 * product from 1–5, where 1 is poor and 5 is excellent. The ratings are stored
 * in a CSV file where each row contains the customer’s rating for each product.
 * Here is a sample file with three customer ratings:
 *      A,B,C,D,E
 *      3,0,5,1,2
 *      1,1,4,2,1
 *      0,0,5,1,3
 * In this file format, the first line gives the products. The digit 0 indicates
 * that a customer did not rate a product. In this case, the first customer
 * rated A as 3, C as 5, D as 1, and E as 2. Product B was not rated. The third
 * customer rated C as 5, D as 1, and E as 3. The third customer did not rate A
 * or B.
 * Create a text file in this format with sample ratings. Then, write a program
 * that reads in this text file and extracts each rating using the
 * `StringTokenizer` class. Finally, the program should output the average
 * rating for each product. Customers that did not rate a product should not be
 * considered when computing the average rating for that product. Your program
 * can assume there will always be exactly five products but it should work with
 * an arbitrary number of customer ratings.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CSVRating {

    private static final String FILENAME
            //= "../../src/CSVRating.txt"; // can only run on commandline
            = "/Users/antw/2022AbsoluteJava/chapter4/chapter4/src/CSVRating.txt";

    private int rateA;
    private int rateB;
    private int rateC;
    private int rateD;
    private int rateE;

    public CSVRating() {
    }

    public CSVRating(int rateA, int rateB, int rateC, int rateD, int rateE) {
        this.setRateA(rateA);
        this.setRateB(rateB);
        this.setRateC(rateC);
        this.setRateD(rateD);
        this.setRateE(rateE);
    }

    public void setCSVRating(CSVRating aCSVRating) {    // **** copy obj ****
        if (aCSVRating == null) { // Not a real
            System.out.println("Fatal Error.");
            System.exit(0);
        }
        rateA = aCSVRating.rateA;
        rateB = aCSVRating.rateB;
        rateC = aCSVRating.rateC;
        rateD = aCSVRating.rateD;
        rateE = aCSVRating.rateE;
    }

    public int getRateA() {
        return rateA;
    }

    public int getRateB() {
        return rateB;
    }

    public int getRateC() {
        return rateC;
    }

    public int getRateD() {
        return rateD;
    }

    public int getRateE() {
        return rateE;
    }

    public void setRateA(int rateA) {
        if (rateOk(rateA)) {
            this.rateA = rateA;
        } else {
            System.out.println("Fatal Error.");
            System.exit(0);
        }
    }

    public void setRateB(int rateB) {
        if (rateOk(rateB)) {
            this.rateB = rateB;
        } else {
            System.out.println("Fatal Error.");
            System.exit(0);
        }
    }

    public void setRateC(int rateC) {
        if (rateOk(rateC)) {
            this.rateC = rateC;
        } else {
            System.out.println("Fatal Error.");
            System.exit(0);
        }
    }

    public void setRateD(int rateD) {
        if (rateOk(rateD)) {
            this.rateD = rateD;
        } else {
            System.out.println("Fatal Error.");
            System.exit(0);
        }
    }

    public void setRateE(int rateE) {
        if (rateOk(rateE)) {
            this.rateE = rateE;
        } else {
            System.out.println("Fatal Error.");
            System.exit(0);
        }
    }

    @Override
    public String toString() {
        return "Rate A: " + rateA
                + ", B: " + rateB
                + ", C: " + rateC
                + ", D: " + rateD
                + ", E: " + rateE;
    }

    private boolean rateOk(int r) {
        return ((r <= 5) && (r >= 0));
    }

    public void setObjFmToken(String inputLine) {
        String delimiters = ", "; //Comma and blank space .. pg 278
        StringTokenizer factory = new StringTokenizer(inputLine, delimiters);

        char count = 'A';
        int token;
        while (factory.hasMoreTokens()) {
            token = Integer.parseInt(factory.nextToken());

            switch (count) {
                case 'A' ->
                    this.setRateA(token);
                case 'B' ->
                    this.setRateB(token);
                case 'C' ->
                    this.setRateC(token);
                case 'D' ->
                    this.setRateD(token);
                case 'E' ->
                    this.setRateE(token);
                default -> {
                    System.out.println(" Error");
                    System.exit(0);
                }
            }
            count += 1; // next letter
        }
    }

    public void setQtyTotal(CSVRating total, CSVRating qty) {
        if (this.rateA != 0) {
            total.rateA = total.rateA + this.rateA;
            qty.rateA = qty.rateA + 1;
        }
        if (this.rateB != 0) {
            total.rateB = total.rateB + this.rateB;
            qty.rateB = qty.rateB + 1;
        }
        if (this.rateC != 0) {
            total.rateC = total.rateC + this.rateC;
            qty.rateC = qty.rateC + 1;
        }
        if (this.rateD != 0) {
            total.rateD = total.rateD + this.rateD;
            qty.rateD = qty.rateD + 1;
        }
        if (this.rateE != 0) {
            total.rateE = total.rateE + this.rateE;
            qty.rateE = qty.rateE + 1;
        }
    }

    public void aveQtyTotal(CSVRating total, CSVRating qty) {
        this.rateA = Math.round((float) total.rateA / qty.rateA);
        this.rateB = Math.round((float) total.rateB / qty.rateB);
        this.rateC = Math.round((float) total.rateC / qty.rateC);
        this.rateD = Math.round((float) total.rateD / qty.rateD);
        this.rateE = Math.round((float) total.rateE / qty.rateE);
    }

    public Scanner fileInput(Scanner fileIn) {
        try {
            // Attempt to Open the file
            fileIn = new Scanner(
                    new FileInputStream(FILENAME));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }
        return fileIn;
    }

    public static void main(String[] args) {
        System.out.println("class CSVRating");

        CSVRating c = new CSVRating(),
                total = new CSVRating(),
                qty = new CSVRating();

        String textLine;
        boolean hasNextline;

        Scanner fileIn = null;  // Initialize fileIn to empty
        fileIn = c.fileInput(fileIn);

        if (hasNextline = fileIn.hasNextLine()) {
            textLine = fileIn.nextLine(); // skip the first label line
            //System.out.println("\t" + textLine);
        }

        while (hasNextline) {
            textLine = fileIn.nextLine();
            //System.out.println("\t" + textLine);

            c.setObjFmToken(textLine);
            c.setQtyTotal(total, qty);

            hasNextline = fileIn.hasNextLine(); // boolean to cont
        }
        fileIn.close(); // close file

        c.aveQtyTotal(total, qty);
        System.out.println("Average rating for each product.\n" + c);
    }

}
/* Sample dialogue
run:
class CSVRating
Average rating for each product.
Rate A: 2, B: 1, C: 4, D: 1, E: 2
BUILD SUCCESSFUL (total time: 0 seconds)
 */
 /*
antw@Mac-mini 2022AbsoluteJava % cat chapter4/chapter4/src/CommaSeparated.txt
A,B,C,D,E
3,0,5,1,2
1,1,4,2,1
0,0,5,1,3
1,1,1,1,1
 */
