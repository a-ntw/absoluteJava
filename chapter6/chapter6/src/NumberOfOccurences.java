
/* 220616 Absolute Java  Chapter6 Programming Projects. Proj0605 */
import java.util.Scanner;

/**
 * Write a program that takes as input a set of 15 numbers from the keyboard
 * into an array of type {@code int[]}. Create another array that will also read
 * 15 other numbers of type {@code int} into it. Now merge the elements of these
 * two arrays into one. The output is to be a two-column list. The first column
 * is a list of the distinct array elements; the second column is the count of
 * the number of occurrences of each element.
 */
public class NumberOfOccurences {

    private static int numberUsed;
    private static int[][] twoColumns;

    public static void main(String[] args) {
        //int[] a1 = {-22, 3, -22, 4, 1, 1, -22, 1, -1, 1, 2, 3, 4, 2, -22};
        //int[] a2 = {-1, 1, 2, 3, 4, 2, -22, -22, 3, -22, 4, 1, 1, -22, 1};

        int[] a1, a2;
        a1 = inputArray(15);
        a2 = inputArray(15);
        
        int[] m = merge(a1, a2);
        NumberOfOccurences c = new NumberOfOccurences();
        c.occurrences(m);
        c.display(getTwoColumns(), getNumberUsed());
    }

    public static int[] inputArray(int size) {
        Scanner keyboard = new Scanner(System.in);

        int[] a = new int[size];
        System.out.println("input a set of " + size + " numbers (space between) ");
        for (int i = 0; i < size; i++) {
            a[i] = keyboard.nextInt();
        }
        return a;
    }

    public static int[] merge(int[] a1, int[] a2) {
        int[] temp = new int[a1.length + a2.length];

        for (int i = 0; i < a1.length; i++) {
            temp[i] = a1[i];
        }
        for (int i = 0; i < a2.length; i++) {
            temp[i + a1.length] = a2[i];
        }

        return temp;
    }

    private static void selectionSort(int[] a, int numberUsed) {
        int index, indexOfNextSmallest;
        for (index = 0; index < numberUsed - 1; index++) { //Place the correct value in a[index]:
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

    public void occurrences(int[] m) {

        selectionSort(m, m.length);

        twoColumns = new int[m.length][2];
        int x = 0;
        twoColumns[x][0] = m[0];
        twoColumns[x][1] = 1;
        for (int i = 1; i < m.length; i++) {
            if (m[i] != m[i - 1]) {
                x++;
                twoColumns[x][0] = m[i];
            }
            twoColumns[x][1]++;
        }
        numberUsed = x;
    }

    public static int getNumberUsed() {
        return numberUsed;
    }

    public static int[][] getTwoColumns() {
        return twoColumns;
    }

    public void display(int[][] occ, int numberUsed) {
        System.out.printf("%3s   %s%n", "N", "Count");
        for (int i = 0; i <= numberUsed; i++) {
            System.out.printf("%3d   %-2d%n", occ[i][0], occ[i][1]);
        }
    }
}

/* Sample dialogue
run:
input a set of 15 numbers (space between) 
-22 3 -22 4 1 1 -22 1 -1 1 2 3 4 2 -22
input a set of 15 numbers (space between) 
-1 1 2 3 4 2 -22 -22 3 -22 4 1 1 -22 1
  N   Count
-22   8 
 -1   2 
  1   8 
  2   4 
  3   4 
  4   4 
BUILD SUCCESSFUL (total time: 1 minute 6 seconds)
 */
