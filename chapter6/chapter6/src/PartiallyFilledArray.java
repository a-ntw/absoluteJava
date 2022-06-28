
/* 220628 Absolute Java  Chapter6 Programming Projects.  Proj0609 */
 /* 220618 Absolute Java  Chapter6 Programming Projects.  Display 6.5 */
/**
 * Partially Filled Array:
 * Class for a partially filled array of doubles. The class enforces the
 * following invariant: All elements are at the beginning of the array in
 * locations 0, 1, 2, and so forth up to a highest index with no gaps.
 *
 * @see GolfScores.java
 *
 * Proj0609. Enhance the definition of the class {@code PartiallyFilledArray}
 * (Display 6.5) in the following way: When the user attempts to add one
 * additional element and there is no room in the array instance variable
 * {@code a}, the user is allowed to add the element. The object creates a
 * second array that is twice the size of the array {@code a}, copies values
 * from the array {@code a} to the user’s new array, makes this array (or more
 * precisely its reference) the new value of {@code a}, and then adds the
 * element to this new larger array {@code a}. Hence, this new class should have
 * no limit (other than the physical size of the computer) to how many numbers
 * it can hold. The instance variable {@code maxNumberOfElements} remains and
 * the method {@code getMaxCapacity} is unchanged, but these now refer to the
 * currently allocated memory and not to an absolute upper bound. Write a
 * suitable test program.
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
     * following would not be correct: {@code a = original.a};. This point is
     * discussed later in this chapter in the subsection entitled “Privacy Leaks
     * with Array Instance Variables.”
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
     * Proj0609. Adds newElement to the first unused array position.
     */
    public void add(double newElement) {
        if (numberUsed >= a.length) {
            increaseCapacity(maxNumberElements * 2);
        }

        a[numberUsed] = newElement;
        numberUsed++;
    }

    /* Display 6.5
        if (numberUsed >= a.length) {
            System.out.println("Error: Adding to a full array.");
            System.exit(0);
        } else {
            a[numberUsed] = newElement;
            numberUsed++;
        } */
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

    /**
     * Exec0618 Define a method named removeAll that can be added to the class {@code
     * PartiallyFilledArray}. This method has no parameters. When invoked, the
     * method {@code removeAll} deletes all the elements in its calling object.
     */
    public void removeAll() {
        numberUsed = 0;
    }

    /**
     * Exec0619 Define a method named {@code increaseCapacity} that can be added
     * to the class {@code PartiallyFilledArray} in Display 6.5. The method has
     * one {@code int} parameter named {@code newCapacity} that increases the
     * capacity of the {@code PartiallyFilledArray} so that it can hold up to
     * {@code newCapacity} numbers.
     * <p>
     * If {@code newCapacity} is less than or equal to
     * {@code maxNumberOfElements}, then the method does nothing.
     * <p>
     * If {@code newCapacity} is greater than {@code maxNumberOfElements}, then
     * {@code maxNumberElements} is set equal to {@code newCapacity} and a new
     * array of length {@code newCapacity} is created for the array instance
     * variable {@code a}. The old values of the array instance variable are
     * copied to the newly created array.
     *
     * @param newCapacity newCapacity
     */
    public void increaseCapacity(int newCapacity) {
        if (newCapacity > numberUsed) {
            maxNumberElements = newCapacity;
            double[] temp = new double[newCapacity];
            for (int i = 0; i < a.length; i++) {
                temp[i] = a[i];
            }
            a = temp;
        }
    }
}

/*  // Proj0609.
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        PartiallyFilledArray q = new PartiallyFilledArray();

        System.out.println("Enter nonnegative numbers, & \n"
                + "Mark the end of the list with a negative number.");
        double next = keyboard.nextDouble();
        System.out.println("q.maxNumberElements: " + q.getMaxCapacity());

        while (next >= 0) {
            q.add(next);
            next = keyboard.nextDouble();
        }
        System.out.println("q.maxNumberElements: " + q.getMaxCapacity());

        for (int index = 0; index < q.getNumberOfElements(); index++) {
            System.out.print(q.getElement(index) + " ");
        }
        System.out.println();
    }
 /*
    run:
    Enter nonnegative numbers, & 
    Mark the end of the list with a negative number.
    1 2 3 4 5 1 2 3 4 5 0 -1
    q.maxNumberElements: 10
    q.maxNumberElements: 20
    1.0 2.0 3.0 4.0 5.0 1.0 2.0 3.0 4.0 5.0 0.0 
    BUILD SUCCESSFUL (total time: 22 seconds)
 */
