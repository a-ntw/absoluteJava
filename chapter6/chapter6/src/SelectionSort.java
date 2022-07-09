
/* 220620 Absolute Java  Chapter6 Programming Projects.  Display 6.11 */

/**
 * Selection Sort Class
 */
public class SelectionSort {

    /**
     * Precondition: numberUsed {@code <= a.length}; The first numberUsed
     * indexed variables have values. Action: Sorts a so that {
     *
     * @codea [0] <= a[1] <= ... <= a[numberUsed - 1] }.
     *
     * @param a a
     * @param numberUsed numberUsed
     */
    public static void sort(double[] a, int numberUsed) {
        int index, indexOfNextSmallest;
        for (index = 0; index < numberUsed - 1; index++) { //Place the correct value in a[index]:
            indexOfNextSmallest = indexOfSmallest(index, a, numberUsed);
            interchange(index, indexOfNextSmallest, a);
            //a[0] <= a[1] <= ...<= a[index] and these are the smallest
            //of the original array elements. The remaining positions
            //contain the rest of the original array elements.
        }

    }

    /**
     * Returns the index of the smallest value among
     * {@code a[startIndex], a[startIndex+1], ... a[numberUsed - 1]}
     *
     * @param startIndex startIndex
     * @param a a
     * @param numberUsed numberUsed
     * @return Return
     */
    private static int indexOfSmallest(int startIndex,
            double[] a, int numberUsed) {
        double min = a[startIndex];
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

    /**
     * Precondition: i and j are legal indices for the array a.
     * <p>
     * Postcondition: Values of a[i] and a[j] have been interchanged.
     *
     * @param i i
     * @param j j
     * @param a a
     */
    private static void interchange(int i, int j, double[] a) {
        double temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp; //original value of a[i]
    }

    /**
     * main.
     *
     * @param args args
     */
    public static void main(String[] args) {
        double[] b = {7.7, 5.5, 11, 3, 16, 4.4, 20, 14, 13, 42};
        System.out.println("Array contents before sorting:");
        int i;
        for (double e : b) {
            System.out.print(e + " ");
        }
        System.out.println();

        SelectionSort.sort(b, b.length);
        System.out.println("Sorted array values:");
        for (double e : b) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
/* Sample dialogue
run:
Array contents before sorting:
7.7 5.5 11.0 3.0 16.0 4.4 20.0 14.0 13.0 42.0 
Sorted array values:
3.0 4.4 5.5 7.7 11.0 13.0 14.0 16.0 20.0 42.0 
BUILD SUCCESSFUL (total time: 0 seconds)
 */
