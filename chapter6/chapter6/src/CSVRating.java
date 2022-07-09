
/* 220704 Absolute Java  Chapter6 Programming Projects. Proj0617 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Programming Project 4.14 asked you to read in a CSV file of product ratings.
 * The file was limited to exactly five products. Redo Programming Project 4.14,
 * except calculate the name of each product and how many products are in the
 * file based on the header line. Then read the CSV file and translate the data
 * into a 2D array that stores all of the ratings. Finally, output the average
 * rating for each product.
 */
public class CSVRating {

    private static final String FILENAME
            = "src/CSVRating.txt";
    //= "../../src/CSVRating.txt"; // can only run on commandline

    public static final int MAX_ROW = 50;
    public static final int MAX_COL = 10;
    private String[] label;
    private int numLabelUsed;
    private int[][] csvData;
    private int numRowUsed;

    public CSVRating(String filename) {
        Scanner fileIn = null;  // Initialize fileIn to empty
        try {
            // Attempt to Open the file
            fileIn = new Scanner(
                    new FileInputStream(filename));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }
        readAllFmFile(fileIn);
        fileIn.close(); // close file
    }

    public CSVRating() {
        Scanner fileIn = null;  // Initialize fileIn to empty
        fileIn = fileInput(fileIn);
        readAllFmFile(fileIn);
        fileIn.close(); // close file
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

    public void readAllFmFile(Scanner fileIn) {
        String textLine;
        boolean hasNextline;
        int numUsed = 0;
        // read the label data to array
        if (hasNextline = fileIn.hasNextLine()) {
            textLine = fileIn.nextLine(); // label line: A,B,C,D,E
            numUsed = setLabelFmFile(textLine);
            hasNextline = fileIn.hasNextLine(); // boolean to cont
        }

        // set new csv array with column lgth = numLabelUsed
        csvData = new int[MAX_ROW][numUsed];
        numRowUsed = 0;
        while (hasNextline) {
            textLine = fileIn.nextLine();
            setCsvdataFmFile(textLine);
            numRowUsed++;
            hasNextline = fileIn.hasNextLine(); // boolean to cont
        }
        this.numLabelUsed = numUsed;
    }

    private int setLabelFmFile(String inputLine) {
        label = new String[MAX_COL];
        int numLabelUsed = 0;
        String delimiters = ", "; //Comma and blank space .. pg 278
        StringTokenizer factory = new StringTokenizer(inputLine, delimiters);

        while (factory.hasMoreTokens()) {
            label[numLabelUsed] = factory.nextToken();
            numLabelUsed += 1; // next letter
        }
        return numLabelUsed;
    }

    private void setCsvdataFmFile(String inputLine) {
        String delimiters = ", "; //Comma and blank space .. pg 278
        StringTokenizer factory = new StringTokenizer(inputLine, delimiters);

        int index = 0, token;
        while (factory.hasMoreTokens()) {
            token = Integer.parseInt(factory.nextToken());
            rateOk(token);
            csvData[numRowUsed][index] = token;
            index += 1; // next letter
        }
    }

    public void printAverage() {
        int prodLgth = numLabelUsed;
        int[][] aveData = new int[prodLgth][2]; // data and count

        for (int i = 0; i < numRowUsed; i++) {
            for (int p = 0; p < prodLgth; p++) {
                if (csvData[i][p] != 0) {
                    aveData[p][0] += csvData[i][p];
                    aveData[p][1]++;
                }
            }
        }
        System.out.println("Average rating for each product.");
        System.out.print("Rate ");
        int a;
        for (int i = 0; i < prodLgth; i++) {
            a = Math.round((float) aveData[i][0] / aveData[i][1]);
            System.out.print(label[i] + ": " + a + ", ");
        }
        System.out.println();
    }

    private boolean rateOk(int r) {
        if ((r <= 5) && (r >= 0)) {
            return true;
        } else {
            System.out.println("Error at row: " + (numRowUsed + 1));
            System.exit(0);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("class CSVRating");
        CSVRating c = new CSVRating("src/CSVRating.txt");
        c.printAverage();
    }

}
/* Sample dialogue
run:
Average rating for each product.
Rate Alpha: 2, Bravo: 1, Charlie: 4, Delta: 1, Echo: 2, 
BUILD SUCCESSFUL (total time: 0 seconds)

 */
 /*
antw@Mac-mini absoluteJ % cat chapter6/chapter6/src/CSVRating.txt
Alpha,Bravo,Charlie,Delta,Echo
3,0,5,1,2
1,1,4,2,1
0,0,5,1,3
1,1,1,1,1
 */
