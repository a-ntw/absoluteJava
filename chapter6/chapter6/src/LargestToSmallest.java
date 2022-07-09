
/* 220626 Absolute Java  Chapter6 Programming Projects. Proj0606 */
import java.util.Scanner;

/**
 * Write a program that reads numbers from the keyboard into an array of type
 * null {@code int[]. You may assume that there will be 50 or fewer entries in the array.
 * Your program allows any number of numbers to be entered, up to 50. The output
 * is to be a two-column list. The first column is a list of the distinct array
 * elements; the second column is the count of the number of occurrences of each
 * element. The list should be sorted on entries in the first column, largest to
 * smallest.
 */
public class LargestToSmallest {

    public static final int MAX_NUMBER_ENTRIES = 50;

    public static void main(String[] args) {
        int[] num = new int[MAX_NUMBER_ENTRIES];
        int numberUsed = fillArray(num);
        int[][] twoColumns = new int[numberUsed][2];
        int twoColumnsUsed = largeToSmallOccurrences(twoColumns, num, numberUsed);
        display(twoColumns, twoColumnsUsed);
    }

    public static int fillArray(int[] num) {
        System.out.println("Enter up to " + num.length + " int numbers,(space between)");
        System.out.println("Mark the end of the list with a NON integer.");
        Scanner keyboard = new Scanner(System.in);

        int next, index = 0;
        if (!keyboard.hasNextInt()) { //                  **** .hasNextInt() ****
            System.out.println("Error, need first Int number.");
            System.exit(0);
        }
        while (keyboard.hasNextInt() && (index < num.length)) {
            next = keyboard.nextInt();
            num[index] = next;
            index++;
        }
        return index; // numberUsed
    }

    public static void display(int[][] twoColumns, int twoColumnsUsed) {
        System.out.printf("%3s   %s%n", "N", "Count");
        for (int i = 0; i <= twoColumnsUsed; i++) {
            System.out.printf("%3d   %-2d%n", twoColumns[i][0], twoColumns[i][1]);
        }
    }

    public static int largeToSmallOccurrences(
            int[][] twoColumns, int[] num, int numberUsed) {

        selectionSort(num, numberUsed);

        int x = 0;
        int maxAindex = numberUsed - 1;
        twoColumns[x][0] = num[maxAindex];
        twoColumns[x][1] = 1;

        for (int i = maxAindex - 1; i >= 0; i--) {
            if (num[i] != num[i + 1]) {
                x++;
                twoColumns[x][0] = num[i];
            }
            twoColumns[x][1]++;
        }
        return x;// twoColumnsUsed 
    }

    private static void selectionSort(int[] a, int numberUsed) {
        int index, indexOfNextSmallest;
        for (index = 0; index < numberUsed - 1; index++) {
            indexOfNextSmallest = indexOfSmallest(index, a, numberUsed);
            interchange(index, indexOfNextSmallest, a);
        }
    }

    private static int indexOfSmallest(int startIndex,
            int[] a, int numberUsed) {
        int min = a[startIndex];
        int indexOfMin = startIndex;
        int index;
        for (index = startIndex + 1; index < numberUsed; index++) {
            if (a[index] < min) {
                min = a[index];
                indexOfMin = index;
                //min is smallest of a[startIndex] through a[index]
            }
        }
        return indexOfMin;
    }

    private static void interchange(int i, int j, int[] a) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp; //original value of a[i]
    }
}

/* Sample dialogue
run:
Enter up to 50 int numbers,(space between)
Mark the end of the list with a NON integer.
-12 3 -12 4 1 1 -12 1 -1 1 2 3 4 2 3 -12 .
  N   Count
  4   2 
  3   3 
  2   2 
  1   4 
 -1   1 
-12   4 
BUILD SUCCESSFUL (total time: 6 seconds)
 */
