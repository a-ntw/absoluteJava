
/* 220616 Absolute Java  Chapter6 Programming Projects. */
/**
 * main.
 *
 * @author ng
 */
public class main {

    // pg 436
    public static void showMatrix(int[][] a) {
        int row, column;
        for (int[] e : a) {
            for (int f : e)
                System.out.print(f + " ");
            System.out.println();
        }
    }

    /**
     * main.
     *
     * @param args args
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            // pg 398
            System.out.println(args[1] + " " + args[0]
                    + " " + args[1]);
        }
    }
}

/* Sample dialogue
antw@Mac-mini chapter6 % javac -d build/classes src/*.java
antw@Mac-mini chapter6 % cd build/classes
antw@Mac-mini classes % java main
antw@Mac-mini classes % java main testing one two thhree
one testing one
antw@Mac-mini classes % cd ../..
antw@Mac-mini chapter6 % pwd
/Users/antw/absoluteJ/chapter6/chapter6
 */
