
/* 220719 Absolute Java  Chapter7 Programming Projects. Proj0709 */
 /*  from Proj0618 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Programming Project 6.18 asked you to use an array of Strings to store the
 * fruits and vegetables shipped in a {@code BoxOfProduce} object for a CSA
 * farm. Modify your solution further by creating a {@code Produce} class. This
 * class should have an instance variable of type {@code String} for the name,
 * appropriate constructors, and a public {@code toString()} method. Then create
 * a {@code Fruit} and a {@code Vegetable} class that are derived from
 * {@code Produce}. These classes should have constructors that take the name as
 * a {@code String} and invoke the appropriate constructor from the base class
 * to set the name.
 *
 * Next, modify the text file of produce so it indicates whether each item is a
 * fruit or a vegetable. Here is one possible organisation, although you can use
 * others:
 * <li>Broccoli,Vegetable
 * <li>Tomato,Fruit
 * <li>Kiwi,Fruit
 * <li>Kale,Vegetable
 * <li>Tomatillo,Fruit
 *
 * Finally, modify the {@code BoxOfProduce} class so it creates an array of type
 * {@code Produce} instead of type {@code String}. The class should read the
 * produce from the text file and create instances of either {@code Fruit} or
 * {@code Vegetable}, with the appropriate name, in the array. After a box is
 * finished, loop through the contents of the array and output how many fruit
 * and how many vegetables are in the box. The rest of the program should behave
 * the same as the solution to Programming Project 6.18.
 *
 * @see Fruit.java
 * @see Vegetable.java
 */
public class BoxOfProduce {

    private static final String FILENAME
            //= "src/BoxOfProduce.txt"; // can run on Netbean
            = "../../src/BoxOfProduce.txt"; // can run on commandline
    private static final int FILEROWS = 5;
    private static final int MAX_SIZE = 10;
    private Produce[] prods = new Produce[MAX_SIZE];
    private int numberUsed = 3;

    public BoxOfProduce() {
    }

    public BoxOfProduce(Produce prodA, Produce prodB, Produce prodC) {
        if (produceOK(prodA) && produceOK(prodB)
                && produceOK(prodC)) {
            this.prods[0] = prodA;
            this.prods[1] = prodB;
            this.prods[2] = prodC;
        } else {
            System.out.println("Error. Can only select the fruit from the file.");
            System.exit(0);
        }
    }

    public int getNumberUsed() {
        return numberUsed;
    }

    // select 1,2 3...
    public Produce getProd(int select) {
        if (select > numberUsed) {
            System.out.println("Error");
            System.exit(0);
        }

        return prods[select - 1];
    }

    public void setProd(int select, Produce p) {
        if (!produceOK(p)) {
            System.out.println("Error. Product can only select from the file.");
            return;
        }
        this.prods[select - 1] = p;
    }

    public void setProdRandom() {
        for (int i = 0; i < numberUsed; i++) {
            Produce p = randomProd();
            this.prods[i] = p;
        }
    }

    private Produce randomProd() {
        Random randomGenerator = new Random();
        int pickrow = randomGenerator.nextInt(FILEROWS) + 1;
        Produce random = this.fromFile(pickrow, null);

        return random;
    }

    private boolean produceOK(Produce p) {
        if (p.equals(fromFile(0, p.getName()))) {
            return true;
        }

        return false;
    }

    public void substitute(int select, String prodName) {
        if (select <= numberUsed) {
            Produce prod = this.fromFile(0, prodName);
            setProd(select, prod);
        } else {
            System.out.println("Error. Can only pick 1, 2 or 3.");
        }
    }

    public void addProduce() {
        if (numberUsed >= MAX_SIZE) {
            System.out.println("Error, Max limit reached.");
            System.exit(0);
        }

        prods[numberUsed] = this.randomProd();
        numberUsed++;
    }

    private Scanner fileInput() {
        Scanner fileIn = null;
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

    /**
     * this method return Produce from <b>either</b> pick int rowIndex from the
     * file, or to check from String prodName.
     *
     * @param rowIndex use for randomProd(), need set prodName to null.
     * @param prodName use for substitute(), need set rowIndex = FILEROWS.
     * @return Return either Fruit object, or Vegetable object
     */
    private Produce fromFile(int rowIndex, String prodName) { // **** two uses ****
        Scanner fileIn = fileInput();
        String textLine;
        Produce rowProd = new Produce();
        int count = 0; // to index the row from file
        boolean hasNextline = true;

        if (rowIndex <= 0) {
            rowIndex = FILEROWS;
        }

        while (hasNextline && (count < rowIndex)) {
            textLine = fileIn.nextLine();

            rowProd = filerowToObj(textLine);
            // to find Product in file. prodName is null will be false
            if (rowProd.getName().equalsIgnoreCase(prodName)) { // **** null ****
                fileIn.close();
                return rowProd;
            }

            count++;
            hasNextline = fileIn.hasNextLine();
            //System.out.println("Text left to read? " + fileIn.hasNextLine());
        }

        fileIn.close();
        return rowProd;
    }

    private Produce filerowToObj(String textLine) {
        String delimiters = ", "; //Comma and blank space .. pg 278
        Produce f = new Produce();
        StringTokenizer factory = new StringTokenizer(textLine, delimiters);
        String token = factory.nextToken();
        String tokenForClass = factory.nextToken();

        if (tokenForClass.equalsIgnoreCase("Vegetable")) {
            f = new Vegetable(token);
        } else if (tokenForClass.equalsIgnoreCase("Fruit")) {
            f = new Fruit(token);
        } else {
            System.out.println("Error");
            System.exit(0);
        }

        return f;
    }

    public void displayTotalProd() {
        int f = 0, v = 0;
        for (int i = 0; i < this.numberUsed; i++) {
            if (prods[i].getClass().getName() == "Fruit") {
                f++;
            } else if (prods[i].getClass().getName() == "Vegetable") {
                v++;
            }
        }
        System.out.printf("There are %d nos of fruits, "
                + "& %d nos of vegetable.%n", f, v);
    }

    @Override
    public String toString() {
        String s = numberUsed + " bundles, consist of ";
        for (int i = 0; i < numberUsed; i++) {
            s += ((i + 1) + ":" + prods[i] + ", ");
        }
        s = s.substring(0, s.length() - 2); // remove the comma
        s += ".";
        return s;
    }

    public static void methodsTesting() {
        System.out.print("Methods testing: ");

        BoxOfProduce box = new BoxOfProduce();
        box.setProdRandom();
        //System.out.println(box);

        Produce a = new Fruit("Kiwi");
        Produce b = new Vegetable("broccoli");
        Produce c = new Fruit("TOMATO");
        box = new BoxOfProduce(a, b, c);
        box.addProduce();
        box.substitute(4, "KIWI");
        //System.out.println(box.getProd(1));
        if (box.getProd(1).toString().equals("Kiwi")) {
            System.out.print(" . ok ");
        } else {
            System.out.println("\nError from getFruit(1)...");
        }
        //System.out.println(box);
        String test
                = "4 bundles, consist of 1:Kiwi, 2:broccoli, 3:TOMATO, 4:Kiwi.";
        if (box.toString().equals(test)) {
            System.out.println(" .. ok ");
        } else {
            System.out.println("\nError from toString() ...");
        }
    }

    public static void main(String[] args) {
        BoxOfProduce.methodsTesting();

        Scanner keyboard = new Scanner(System.in);
        BoxOfProduce box = new BoxOfProduce();

        box.setProdRandom();
        System.out.println("Ramdonly selected");
        box.displayTotalProd();

        System.out.println("contains");
        outerLoop:
        while (true) {
            System.out.println(box);
            System.out.println("Select number to substitute any one of the "
                    + "five possible\n fruits or vegetables. "
                    + "`+` to add, or anykey to done.");
            if (!keyboard.hasNextInt()) { //           **** not  hasNextInt ****
                String t = keyboard.next();
                if (t.equalsIgnoreCase("+")) {
                    box.addProduce();
                    continue outerLoop; //          **** jump to outerloop ****
                } else {                // any keys to exit the loop 
                    System.exit(0);
                }
            }

            int select = keyboard.nextInt();
            if (select > box.getNumberUsed()) {
                System.exit(0);
            }
            keyboard.nextLine(); // removed the newline char

            System.out.println("Input fruit name:");
            String product = keyboard.nextLine();
            box.substitute(select, product);
        }
    }
}


/* BoxOfProduce.txt
Broccoli,Vegetable
Tomato,Fruit
Kiwi,Fruit
Kale,Vegetable
Tomatillo,Fruit
 */

 /* Sample dialogue
run:
Methods testing:  . ok Error from toString() ...
Ramdonly selected
There are 2 nos of fruits, & 1 nos of vegetable.
contains
3 bundles of 1:Tomatillo, 2:Broccoli, 3:Tomatillo.
Select number to substitute any one of the five possible
 fruits or vegetables. `+` to add, or anykey to done.
+
4 bundles of 1:Tomatillo, 2:Broccoli, 3:Tomatillo, 4:Kiwi.
Select number to substitute any one of the five possible
 fruits or vegetables. `+` to add or anykey to done.
1
Input fruit name:
kiwi
4 bundles of 1:Kiwi, 2:Broccoli, 3:Tomatillo, 4:Kiwi.
Select number to substitute any one of the five possible
 fruits or vegetables. `+` to add or anykey to done.
x
BUILD SUCCESSFUL (total time: 31 seconds)
 */
