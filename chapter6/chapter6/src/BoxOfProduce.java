
/* 220704 Absolute Java  Chapter6 Programming Projects. Proj0618 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Programming Project 4.13 asked you to create a {@code BoxOfProduce} class
 * representing a box of produce to deliver from a CSA farm. The box contained
 * exactly three items. Modify the class so it uses an array of type
 * {@code String} to represent the items in the box. You can still start with
 * three random items to place in the box, but your menu should be modified to
 * allow the user to add additional items and still substitute one item for
 * another. You will likely need to modify the constructor of the
 * {@code BoxOfProduce} class and also add new methods.
 */
public class BoxOfProduce {

    private static final String FILENAME
            = "../../chapter4/chapter4/src/BoxOfProduce.txt";
    //= "/Users/antw/AbsoluteJava/chapter4/chapter4/src/BoxOfProduce.txt";
    private static final int FILEROWS = 5;
    private static final int MAX_SIZE = 10;
    private String[] fruit = new String[MAX_SIZE];
    private int numberUsed = 3;

    public BoxOfProduce() {
    }

    public BoxOfProduce(String fruitA, String fruitB, String fruitC) {
        if (fruitOK(FILEROWS, fruitA) && fruitOK(FILEROWS, fruitB)
                && fruitOK(FILEROWS, fruitC)) {
            this.fruit[0] = fruitA;
            this.fruit[1] = fruitB;
            this.fruit[2] = fruitC;
        } else {
            System.out.println("Error. Can only select the fruit from the file.");
            System.exit(0);
        }
    }

    public void setFruitRandom() {
        for (int i = 0; i < numberUsed; i++) {
            String fruit = randomFruit();
            this.fruit[i] = fruit;
        }
    }

    public int getNumberUsed() {
        return numberUsed;
    }

    public String getFruit(int select) {
        if (select > numberUsed) {
            System.out.println("Error");
            System.exit(0);
        }

        return fruit[select];
    }

    public void setFruit(int select, String fruit) {
        if (!fruitOK(FILEROWS, fruit)) {
            System.out.println("Error. fruit can only select from the file.");
            return;
        }
        this.fruit[select - 1] = fruit;
    }

    @Override
    public String toString() { //                           **** return s ****
        String s = numberUsed + " bundles of ";
        for (int i = 0; i < numberUsed; i++) {
            s += ((i + 1) + ":" + fruit[i] + ", ");
        }
        s += " add(+).";
        return s;
    }

    // proj0413
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
        if (select <= numberUsed) {
            setFruit(select, fruit);
        } else {
            System.out.println("Error. Can only pick 1, 2 or 3.");
        }

    }

    private boolean fruitOK(int FILEROWS, String fruit) {
        if (fruit.equals(fromFile(FILEROWS, fruit))) {
            return true;
        }

        return false;
    }

    public void addFruit() {
        fruit[numberUsed] = this.randomFruit();
        numberUsed++;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        BoxOfProduce box = new BoxOfProduce();

        box.setFruitRandom();
        System.out.println("BoxOfProduce ramdonly selected, which contains");

        outerLoop:
        while (true) {
            System.out.println(box);
            System.out.println("Select number to substitute any one of the "
                    + "five possible\n fruits or vegetables. "
                    + "`+` to add or anykey to done.");
            if (!keyboard.hasNextInt()) {
                String t = keyboard.next();
                if (t.equalsIgnoreCase("+")) {
                    box.addFruit();
                    continue outerLoop; //              **** while loop ****
                } else {
                    System.exit(0);
                }
            }

            int select = keyboard.nextInt();
            if (select > box.getNumberUsed()) {
                System.exit(0);
            }
            keyboard.nextLine();
            System.out.println("Input fruit name:");
            String fruit = keyboard.nextLine();
            box.substitute(select, fruit);
        }
    }
}

/* Sample dialogue
run:
BoxOfProduce ramdonly selected, which contains
3 bundles of 1:Kale, 2:Kale, 3:Tomato,  add(+).
Select number to substitute any one of the five possible
 fruits or vegetables. `+` to add or anykey to done.
+
4 bundles of 1:Kale, 2:Kale, 3:Tomato, 4:Tomatillo,  add(+).
Select number to substitute any one of the five possible
 fruits or vegetables. `+` to add or anykey to done.
4
Input fruit name:
KIWI
4 bundles of 1:Kale, 2:Kale, 3:Tomato, 4:KIWI,  add(+).
Select number to substitute any one of the five possible
 fruits or vegetables. `+` to add or anykey to done.
x
BUILD SUCCESSFUL (total time: 15 seconds)
 */
