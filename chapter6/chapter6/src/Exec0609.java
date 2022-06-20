
/* 220618 Absolute Java  Chapter6 Programming Projects.  Exercise 6.9 */
/**
 * Write a method named outOfOrder that takes as a parameter an array of double and returns a value of type int. This method will test the array for being out of order, meaning that the array violates the condition:
 * <p>
 * {@code a[0] <= a[1] <= a[2] <= ...}
 * <p>
 * The method returns –1 if the elements are not out of order; otherwise, it
 * returns the index of the first element of the array that is out of order. For
 * example, consider the following declaration:
 * <blockquote>{@code
 *      double[] a = {1.2, 2.1, 3.3, 2.5, 4.5,
 *                      7.9, 5.4, 8.7, 9.9, 1.0}; }
 * </blockquote>
 * In the array above, a[2] and a[3] are the first pair out of order, and a[3]
 * is the first element out of order, so the method returns 3. If the array is
 * sorted, the method returns −1.
 */
public class Exec0609 {

    public static int outOfOrder(double[] a) {
        for (int index = 0; index < (a.length - 1); index++) {
            if (a[index] > a[index + 1]) {
                return (index + 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        double[] a = {1.2, 2.1, 3.3, 2.5, 4.5,
            7.9, 5.4, 8.7, 9.9, 1.0};
        System.out.println("outOfOrder: "
                + outOfOrder(a));
    }

}
