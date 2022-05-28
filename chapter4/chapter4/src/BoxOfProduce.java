
/** 220525
 * Absolute Java
 * Chapter4
 * 13. Your Community Supported Agriculture (CSA) farm delivers a box of fresh
 * fruits and vegetables to your house once a week. For this Programming
 * Project, define the class `BoxOfProduce` that contains exactly three bundles
 * of fruits or vegetables. You can represent the fruits or vegetables as three
 * instance variables of type `String`. Add appropriate constructor, accessor,
 * and mutator methods. Also write a `toString()` method that returns as a
 * String the complete contents of the box.
 * Next, write a main method that creates a `BoxOfProduce` with three items
 * randomly selected from this list:
 *  Broccoli
 *  Tomato
 *  Kiwi
 *  Kale
 *  Tomatillo
 * This list should be stored in a text file that is read in by your program.
 * For now you can assume that the list contains exactly five types of fruits or
 * vegetables.
 * Do not worry if your program randomly selects duplicate produce for the three
 * items. Next, the main method should display the contents of the box and allow
 * the user to substitute any one of the five possible fruits or vegetables for
 * any of the fruits or vegetables selected for the box. After the user is done
 * with substitutions, output the final contents of the box to be delivered. If
 * you create additional methods to select the random items and to select valid
 * substitutions, then your main method will be simpler to write.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class BoxOfProduce {

    private static final String FILENAME
            //= "../../src/BoxOfProduce.txt"; // can only run on commandline
            = "/Users/antw/2022AbsoluteJava/chapter4/chapter4/src/BoxOfProduce.txt";
    private static final int FILEROWS = 5;

    private String fruitA;
    private String fruitB;
    private String fruitC;

    public BoxOfProduce() {
    }

    public BoxOfProduce(String fruitA, String fruitB, String fruitC) {
        if (fruitOK(FILEROWS, fruitA) && fruitOK(FILEROWS, fruitB)
                && fruitOK(FILEROWS, fruitC)) {
            this.fruitA = fruitA;
            this.fruitB = fruitB;
            this.fruitC = fruitC;
        } else {
            System.out.println("Error. Can only select the fruit from the file.");
            System.exit(0);
        }
    }

    public String getFruitA() {
        return fruitA;
    }

    public void setFruitA(String fruitA) {
        if (!fruitOK(FILEROWS, fruitA)) {
            System.out.println("Error. fruitA can only select from the file.");
            return;
        }
        this.fruitA = fruitA;
    }

    public String getFruitB() {
        return fruitB;
    }

    public void setFruitB(String fruitB) {
        if (!fruitOK(FILEROWS, fruitB)) {
            System.out.println("Error. fruitB can only select from the file.");
            return;
        }
        this.fruitB = fruitB;
    }

    public String getFruitC() {
        return fruitC;
    }

    public void setFruitC(String fruitC) {
        if (!fruitOK(FILEROWS, fruitC)) {
            System.out.println("Error. fruitC can only select from the file.");
            return;
        }
        this.fruitC = fruitC;
    }

    @Override
    public String toString() {
        return "BoxOfProduce contains 3 bundles of 1:" + fruitA
                + ", 2:" + fruitB + ", & 3:" + fruitC + '.';
    }

    private String fromFile(int FILEROWS, String fruit) {
        Scanner fileIn = null;  // Initialize fileIn to empty
        try {
            // Attempt to Open the file
            fileIn = new Scanner(
                    new FileInputStream(FILENAME));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }

        String textLine = "";
        int count = 0;
        boolean hasNextline = true;

        while (hasNextline && (count < FILEROWS)) {
            textLine = fileIn.nextLine();
            count++;
            hasNextline = fileIn.hasNextLine();
            //System.out.println("Text left to read? " + fileIn.hasNextLine());

            // for fruitOK(), found fruit in file
            if (fruit.equalsIgnoreCase(textLine)) {
                fileIn.close();
                return fruit;
            }

            if (!hasNextline && (count < FILEROWS)) {
                System.out.println("Error, above data rows limit");
                textLine = "";
            }
        }

        fileIn.close();
        return textLine;
    }

    public String randomFruit() {
        Random randomGenerator = new Random();
        int pick = randomGenerator.nextInt(FILEROWS) + 1;
        String random = this.fromFile(pick, "");

        return random;
    }

    public void substitute(int select, String fruit) {
        switch (select) {
            case 1:
                this.setFruitA(fruit);
                break;
            case 2:
                this.setFruitB(fruit);
                break;
            case 3:
                this.setFruitC(fruit);
                break;
            default:
                System.out.println("Error. Can only pick 1, 2 or 3.");
        }
    }

    private boolean fruitOK(int FILEROWS, String fruit) {
        if (fruit.equals(fromFile(FILEROWS, fruit))) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int select;
        String fruit;
        BoxOfProduce box;

        box = new BoxOfProduce();
        box.setFruitA(box.randomFruit());
        box.setFruitB(box.randomFruit());
        box.setFruitC(box.randomFruit());
        System.out.println(box);

        System.out.println("May select 1, 2 or 3 to substitute \n"
                + "\tany one of the five possible fruits or vegetables.");
        select = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Input fruit name:");
        fruit = keyboard.nextLine();
        box.substitute(select, fruit);
        System.out.println(box);
    }
}
/* Sample dialogue
antw@Mac-mini classes % cd ../..
antw@Mac-mini chapter4 % javac -d build/classes src/*.java
antw@Mac-mini chapter4 % cd build/classes                 
antw@Mac-mini classes % java main                        
BoxOfProduce contains 3 bundles of 1:Kale, 2:Kale, & 3:Tomatillo.
May select 1, 2 or 3 to substitute 
	any one of the five possible fruits or vegetables.
1
Input fruit name:
KIWI
BoxOfProduce contains 3 bundles of 1:KIWI, 2:Kale, & 3:Tomatillo.
antw@Mac-mini classes % 
 */
 /*
antw@Mac-mini 2022AbsoluteJava % cat chapter4/chapter4/src/BoxOfProduce.txt
Broccoli
Tomato
Kiwi
Kale
Tomatillo
 */
