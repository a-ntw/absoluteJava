
/** 220526
 * Absolute Java
 * Chapter4
 * 15. The goal of this Programming Project is to extend Programming Project 14
 * to find the customer from the CSV file who made ratings that are most similar
 * to ratings input from the keyboard. First, do Programming Project 14. Then
 * modify your solution so that it asks the user to input ratings for the first
 * four products before the program reads from the file.
 * The program should then predict whether or not the user will like the final
 * product by outputting the rating made by the most similar customer. Use the
 * formula | Au – Ac| + | Bu – Bc| + | Cu – Cc| + | Du – Dc| to compute the
 * similarity, where Au is the rating for product A made by the user at the
 * keyboard and Ac is the rating for product A made by a customer from the file.
 * A lower total indicates greater similarity. For example, if the user inputs 1
 * for product A, 1 for product B, 3 for product C, and 2 for product D, then
 * with the values from Programming Project 14, the similarity to the customer
 * in the first row is |1 – 3| + |1 – 0| + |3 – 5| + |2 – 1| = 6, while the
 * similarity to the customer in the second row is |1 – 1| + |1 – 1| + |3 – 4| +
 * |2 – 2| = 1. The customer in the second row has the greatest similarity, so
 * the program would output that the prediction for product E is 1, which is the
 * second customer’s rating for product E.
 */
import java.util.Scanner;

public class MostSimilar {

    private CSVRating rateIn;

    public MostSimilar() {
        rateIn = new CSVRating();
    }

    public CSVRating getRateIn() {
        return rateIn;
    }

    public void setRateIn(CSVRating rateIn) {
        this.rateIn = rateIn;
    }

    @Override
    public String toString() {
        return "rateIn:  " + rateIn;
    }

    public void keyboardInput() {
        System.out.println("Enter 4 ratings with comma or space apart.");
        Scanner keyboard = new Scanner(System.in);
        this.rateIn.setObjFmToken(keyboard.nextLine());
    }

    public int absDiff(CSVRating c) {
        return (Math.abs(this.rateIn.getRateA() - c.getRateA())
                + Math.abs(this.rateIn.getRateB() - c.getRateB())
                + Math.abs(this.rateIn.getRateC() - c.getRateC())
                + Math.abs(this.rateIn.getRateD() - c.getRateD()
                ));
    }

    public int diffTextNInput(String textLine, MostSimilar k) {
        this.rateIn.setObjFmToken(textLine);
        int cal = this.absDiff(k.getRateIn());

        return cal;
    }

    public static void main(String[] args) {
        System.out.println("class MostSimilar");
        MostSimilar k = new MostSimilar(); // keyboard input rating
        MostSimilar m = new MostSimilar(); // customer rating from file
        MostSimilar s = new MostSimilar(); // most similar rating found

        int rowCount, cal, min = 21; // assume above maximun diff
        String textLine;
        boolean hasNextline;
        Scanner fileIn = null;  // Initialize fileIn to empty

        k.keyboardInput();

        // Determine the min diff 
        rowCount = 0;
        fileIn = m.getRateIn().fileInput(fileIn);

        if (hasNextline = fileIn.hasNextLine()) {
            textLine = fileIn.nextLine();
            System.out.println("Row\t" + textLine);
        }

        while (hasNextline) {
            rowCount++;
            textLine = fileIn.nextLine();
            System.out.print(rowCount + "\t" + textLine);

            System.out.println(" >> " + (cal = m.diffTextNInput(textLine, k)));
            if (cal < min) {
                s.getRateIn().setCSVRating(m.getRateIn());
                min = cal;
            }
            hasNextline = fileIn.hasNextLine(); // boolean to cont
        }

        System.out.println("Greatest similarity at row:");

        // print all the output with the same min 
        rowCount = 0;
        fileIn = m.getRateIn().fileInput(fileIn);

        if (hasNextline = fileIn.hasNextLine()) {
            fileIn.nextLine(); // skip the first label line
        }

        while (hasNextline) {
            rowCount++;
            textLine = fileIn.nextLine();
            if (m.diffTextNInput(textLine, k) == min) {
                System.out.println(rowCount + "\t" + textLine);
            }
            hasNextline = fileIn.hasNextLine(); // boolean to cont
        }

        fileIn.close(); // close file
    }
}

/* Sample dialogue
antw@Mac-mini classes % cd ../..                         
antw@Mac-mini chapter4 % javac -d build/classes src/*.java                                                                                       antw@Mac-mini chapter4 % cd build/classes                 
antw@Mac-mini classes % java main                        
class MostSimilar
Enter 4 ratings with comma or space apart.
1,  1 3,1
Row	A,B,C,D,E
1	3,0,5,1,2 >> 5
2	1,1,4,2,1 >> 2
3	0,0,5,1,3 >> 4
4	1,1,1,1,1 >> 2
Greatest similarity at row:
2	1,1,4,2,1
4	1,1,1,1,1
antw@Mac-mini classes % 
 */
