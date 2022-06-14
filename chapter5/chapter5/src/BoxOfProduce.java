
/* 220612 Absolute Java  Chapter5 Programming Projects.  10. */
 /* 220525 Absolute Java Chapter4 13. 
 * Your Community Supported Agriculture (CSA) farm delivers a box of fresh
 * fruits and vegetables to your house once a week. For this Programming
 * Project, define the class {@code BoxOfProduce} that contains exactly three
 * bundles of fruits or vegetables. You can represent the fruits or vegetables
 * as three instance variables of type `String`. Add appropriate constructor,
 * accessor, and mutator methods. Also write a {@code toString()} method that
 * returns as a {@code String} the complete contents of the box.
 * <p>
 * Next, write a main method that creates a {@code BoxOfProduce} with three
 * items randomly selected from this list:
 * <ul><li>Broccoli
 * <li>Tomato
 * <li>Kiwi
 * <li>Kale
 * <li>Tomatillo </ul>
 * This list should be stored in a text file that is read in by your program.
 * For now you can assume that the list contains exactly five types of fruits or
 * vegetables.
 * <p>
 * Do not worry if your program randomly selects duplicate produce for the three
 * items. Next, the {@code main} method should display the contents of the box
 * and allow the user to substitute any one of the five possible fruits or
 * vegetables for any of the fruits or vegetables selected for the box. After
 * the user is done with substitutions, output the final contents of the box to
 * be delivered. If you create additional methods to select the random items and
 * to select valid substitutions, then your main method will be simpler to
 * write.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Programming Project 4.13 from Chapter 4, Modify the main method with a loop
 * so that an arbitrary number of {@code BoxOfProduce} objects are created and
 * substitutions are allowed for each box. Add a menu so the user can decide
 * when to stop creating boxes.
 * <p>
 * You would like to throw in a free recipe flyer for salsa verde if the box
 * contains tomatillos. However, there are only five recipe flyers. Add a static
 * variable to the {@code BoxOfProduce} class that counts the number of recipe
 * flyers remaining and initialize it to 5. Also add an instance variable that
 * indicates whether or not the box contains a recipe flyer and modify the
 * {@code toString()} method to also output {@code “salsa verde recipe”} if the
 * box contains a recipe flyer. Finally, add logic inside the class so that if
 * the box contains at least one order of tomatillos then it automatically gets
 * a recipe flyer until all of the recipe flyers are gone. Note that a box
 * should only get one recipe flyer even if there are multiple orders of
 * tomatillos.
 * <p>
 * Test your class by creating boxes with tomatillos from your menu until all of
 * the flyers are gone.
 *
 * @serial Proj0510
 * @since 1.0
 */
public class BoxOfProduce {

    private static final String FILENAME
            //= "../../src/BoxOfProduce.txt"; // can only run on commandline
            = "/Users/antw/absoluteJ/chapter5/chapter5/src/BoxOfProduce.txt";
    private static final int FILEROWS = 5;

    private String fruitA;
    private String fruitB;
    private String fruitC;
    private static int Flyer = 5;

    /**
     * Constructor.
     */
    public BoxOfProduce() {
    }

    /**
     * Constructor.
     *
     * @param fruitA
     * @param fruitB
     * @param fruitC
     */
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

    /**
     * get fruitA.
     *
     * @return Return fruitA
     */
    public String getFruitA() {
        return fruitA;
    }

    /**
     * Set fruitA.
     *
     * @param fruitA
     */
    public void setFruitA(String fruitA) {
        if (!fruitOK(FILEROWS, fruitA)) {
            System.out.println("Error. fruitA can only select from the file.");
            return;
        }
        this.fruitA = fruitA;
    }

    /**
     * get fruitB.
     *
     * @return Return fruitB
     */
    public String getFruitB() {
        return fruitB;
    }

    /**
     * Set fruitB.
     *
     * @param fruitB
     */
    public void setFruitB(String fruitB) {
        if (!fruitOK(FILEROWS, fruitB)) {
            System.out.println("Error. fruitB can only select from the file.");
            return;
        }
        this.fruitB = fruitB;
    }

    /**
     * get fruitC.
     *
     * @return Return fruitC
     */
    public String getFruitC() {
        return fruitC;
    }

    /**
     * Set fruitC.
     *
     * @param fruitC
     */
    public void setFruitC(String fruitC) {
        if (!fruitOK(FILEROWS, fruitC)) {
            System.out.println("Error. fruitC can only select from the file.");
            return;
        }
        this.fruitC = fruitC;
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

    /**
     * To pick a random fruit from the file, BoxOfProduce.txt.
     *
     * @return random number between FILEROWS, ie 5.
     */
    public String randomFruit() {
        Random randomGenerator = new Random();
        int pick = randomGenerator.nextInt(FILEROWS) + 1;
        String random = this.fromFile(pick, "");

        return random;
    }

    /**
     * To substitute any one of the five possible fruits or vegetables for any
     * of the fruits or vegetables selected for the box.
     *
     * @param select either 1, 2 or 3
     * @param fruit
     */
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

    /**
     * Call to String. If there are flyer inside, return will add "salsa verde
     * recipe".
     *
     * @return Return String of "3 bundles of 1: fruitA, 2: fruitB, 3: fruitC."
     */
    public String toString() {
        String box = "3 bundles of 1:" + fruitA
                + ", 2:" + fruitB + ", 3:" + fruitC;
        if (flyerInclude()) {
            box = box + " and salsa verde recipe.";
        } else {
            box += ".";
        }

        return box;
    }

    /**
     * To print out selection menu
     */
    public void printMenu() {
        System.out.print("To substitute any one of the five possible fruits."
                + "\n\t0. skip"
                + "\n\t1. " + getFruitA()
                + "\n\t2. " + getFruitB()
                + "\n\t3. " + getFruitC()
                + "\n\t9. to end."
                + "\n\tSelection: ");
    }

    private boolean tomatilloInside() {
        return (getFruitA().equalsIgnoreCase("Tomatillo")
                || getFruitB().equalsIgnoreCase("Tomatillo")
                || getFruitC().equalsIgnoreCase("Tomatillo"));
    }

    /**
     *
     * @return Return true if there are Flyer and Tomatillo inside.
     */
    private boolean flyerInclude() {
        return (Flyer > 0) && tomatilloInside();
    }

    /**
     * To decrease no. of Flyer by 1, if there are Flyer and Tomatillo inside.
     */
    public void decreaseFlyerIfRequired() {
        if (flyerInclude()) {
            Flyer -= 1;
        }
    }

    /**
     * main
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int select;
        String fruit;
        BoxOfProduce box;
        boolean toContinue = true;

        do {
            box = new BoxOfProduce();
            box.setFruitA(box.randomFruit());
            box.setFruitB(box.randomFruit());
            box.setFruitC(box.randomFruit());
            System.out.println("BoxOfProduce randomly selected, which contains");
            System.out.println(box);

            box.printMenu();
            select = keyboard.nextInt();
            if (select >= 4) {
                toContinue = false;
            } else {
                if (select > 0) {

                    keyboard.nextLine();
                    System.out.print("Input fruit name: ");
                    fruit = keyboard.nextLine();
                    box.substitute(select, fruit);
                }
                System.out.println(box);
                box.decreaseFlyerIfRequired();
            }
            System.out.println("---");
        } while (toContinue);
    }
}
/* Sample dialogue
antw@Mac-mini chapter5 % javac -d build/classes src/*.java
antw@Mac-mini chapter5 % cd build/classes
antw@Mac-mini classes % java BoxOfProduce
BoxOfProduce randomly selected, which contains
3 bundles of 1:Tomato, 2:Tomatillo, 3:Tomatillo and salsa verde recipe.
To substitute any one of the five possible fruits.
	0. skip
	1. Tomato
	2. Tomatillo
	3. Tomatillo
	9. to end.
	Selection: 0
3 bundles of 1:Tomato, 2:Tomatillo, 3:Tomatillo and salsa verde recipe.
---
BoxOfProduce randomly selected, which contains
3 bundles of 1:Kiwi, 2:Broccoli, 3:Broccoli.
To substitute any one of the five possible fruits.
	0. skip
	1. Kiwi
	2. Broccoli
	3. Broccoli
	9. to end.
	Selection: 2
Input fruit name: KIWI
3 bundles of 1:Kiwi, 2:KIWI, 3:Broccoli.
---
BoxOfProduce randomly selected, which contains
3 bundles of 1:Kale, 2:Broccoli, 3:Tomato.
To substitute any one of the five possible fruits.
	0. skip
	1. Kale
	2. Broccoli
	3. Tomato
	9. to end.
	Selection: 9
---
 */
