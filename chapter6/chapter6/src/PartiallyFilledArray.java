
/* 220618 Absolute Java  Chapter6 Programming Projects.  Display 6.5 */
/**
 * Partially Filled Array:
 * Class for a partially filled array of doubles. The class enforces the
 * following invariant: All elements are at the beginning of the array in
 * locations 0, 1, 2, and so forth up to a highest index with no gaps.
 *
 * @see GolfScores.java
 */
public class PartiallyFilledArray {

    private int maxNumberElements; //Same as a.length
    private double[] a;
    private int numberUsed; //Number of indices currently in use

    /**
     * Sets the maximum number of allowable elements to 10.
     */
    PartiallyFilledArray() {
        maxNumberElements = 10;
        a = new double[maxNumberElements];
        numberUsed = 0;
    }

    /**
     * recondition arraySize > 0.
     *
     * @param arraySize
     */
    PartiallyFilledArray(int arraySize) {
        if (arraySize <= 0) {
            System.out.println("Error Array size zero or negative.");
            System.exit(0);
        }
        maxNumberElements = arraySize;
        a = new double[maxNumberElements];
        numberUsed = 0;
    }

    /**
     * Note that the instance variable a is a copy of {@code original.a}. The
     * following would not be correct: a = original.a;. This point is discussed
     * later in this chapter in the subsection entitled “Privacy Leaks with
     * Array Instance Variables.”
     *
     * @param original PartiallyFilledArray array
     */
    PartiallyFilledArray(PartiallyFilledArray original) {

        if (original == null) {
            System.out.println("Fatal Error: aborting program.");
            System.exit(0);
        }

        maxNumberElements = original.maxNumberElements;
        numberUsed = original.numberUsed;
        a = new double[maxNumberElements];
        for (int i = 0; i < numberUsed; i++) {
            a[i] = original.a[i];
        }
    }

    /**
     * Adds newElement to the first unused array position.
     */
    public void add(double newElement) {
        if (numberUsed >= a.length) {
            System.out.println("Error: Adding to a full array.");
            System.exit(0);
        } else {
            a[numberUsed] = newElement;
            numberUsed++;
        }
    }

    public double getElement(int index) {
        if (index < 0 || index >= numberUsed) {
            System.out.println("Error:Illegal or unused index.");
            System.exit(0);
        }
        return a[index];
    }

    /**
     * index must be an index in use or the first unused index.
     *
     * @param index index
     * @param newValue new value
     */
    public void resetElement(int index, double newValue) {
        if (index < 0 || index >= maxNumberElements) {
            System.out.println("Error:Illegal index.");
            System.exit(0);
        } else if (index > numberUsed) {
            System.out.println("Error: Changing an index that is too large.");
            System.exit(0);
        } else {
            a[index] = newValue;
        }
    }

    public void deleteLast() {
        if (empty()) {
            System.out.println("Error:Deleting from an empty array.");
            System.exit(0);
        } else {
            numberUsed--;
        }
    }

    /**
     * Deletes the element in position index. Moves down all elements with
     * indices higher than the deleted element.
     */
    public void delete(int index) {
        if (index < 0 || index >= numberUsed) {
            System.out.println("Error:Illegal or unused index.");
            System.exit(0);
        }

        for (int i = index; i < numberUsed; i++) {
            a[i] = a[i + 1];
        }
        numberUsed--;
    }

    public boolean empty() {
        return (numberUsed == 0);
    }

    public boolean full() {
        return (numberUsed == maxNumberElements);
    }

    public int getMaxCapacity() {
        return maxNumberElements;
    }

    public int getNumberOfElements() {
        return numberUsed;
    }
}
