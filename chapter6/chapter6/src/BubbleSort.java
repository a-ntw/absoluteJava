
/* 220626 Absolute Java  Chapter6 Programming Projects. Proj0608 */
/**
 * Design a class called {@code BubbleSort} that is similar to the class
 * {@code SelectionSort} given in Display 6.11. The class {@code BubbleSort} will be used in the
 * same way as the class {@code SelectionSort}, but it will use the bubble sort
 * algorithm.
 * <p>
 * The bubble sort algorithm checks all adjacent pairs of elements in the array
 * from the beginning to the end and interchanges any two elements that are out
 * of order. This process is repeated until the array is sorted. The algorithm
 * is as follows:
 * <b>Bubble Sort Algorithm to Sort an Array a </b>
 * Repeat the following until the array a is sorted:
 * <blockquote>{@code  for (index = 0; index < a.length – 1; index++)
 *      if (a[index] > a[index + 1])
 *          Interchange the values of a[index] and a[index + 1].}</blockquote>
 * The bubble sort algorithm is good for sorting an array that is “almost
 * sorted.” It is not competitive with other sorting methods for most other
 * situations.
 */
public class BubbleSort {

    public static void sort(double[] a, int numberUsed) {
        int index; 
        boolean repeat = true;
        while (repeat) {
            repeat = false;
            for (index = 0; index < numberUsed - 1; index++) {
                if (a[index] > a[index + 1]) {
                    interchange(index, index + 1, a);
                    repeat = true;
                }
            }
        }
    }

    private static void interchange(int i, int j, double[] a) {
        double temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp; //original value of a[i]
    }

    public static void main(String[] args) {
        double[] b = {7.7, 5.5, 11, 3, 16, 4.4, 20, 14, 13, 42};
        System.out.println("Array contents before sorting:");
        int i;
        for (double e : b) {
            System.out.print(e + " ");
        }
        System.out.println();

        BubbleSort.sort(b, b.length);
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
