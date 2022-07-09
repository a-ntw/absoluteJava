
/* 220625 Absolute Java  Chapter6 Programming Projects. Proj0604 */
import java.util.Scanner;

/**
 * Write a program to document the marks of an additional value added course
 * taught to the students. The marks of the students cannot be negative and
 * cannot be more than 100 i.e. {@code 0<=marks<=100}. Create a class that
 * should maintain the following information about each student of the class.
 *
 * a. Student name
 *
 * b. Student ID
 *
 * c. Array of marks in five subjects
 *
 * Also, write a method called validateMarks that deletes all the marks less
 * than zero and greater than 100 from the array. When a value of marks is
 * deleted, the remain- ing marks are moved one position to fill in the gap.
 * This creates empty positions at the end of the array so that less of the
 * array is used
 */
public class ValueAddedCourse {

    public static final int MAX_NUMBER = 10;
    private String studentName;
    private String studentID;
    private int[] marks = new int[MAX_NUMBER];
    private int numberUsed = 0;

    public ValueAddedCourse(String studentName, String studentID) {
        this.studentName = studentName;
        this.studentID = studentID;

        fillArray();
    }

    public ValueAddedCourse(String studentName, String studentID, int[] intarrMarks) {
        this.studentName = studentName;
        this.studentID = studentID;

        if (intarrMarks.length >= MAX_NUMBER) {
            System.out.println("Error. Size not less than MAX_NUMBER.");
            System.exit(0);
        }
        for (int e : intarrMarks) {
            add(e);
        }
    }

    /**
     * Reads values into the array score.
     */
    private void fillArray() {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Maximumm size of an array: ");
        int marksNumber = keyboard.nextInt();

        System.out.println("Enter up to " + marksNumber + " marks.");
        int next, index = 0;
        do {
            System.out.print("arrMark [" + index + "] = ");
            next = keyboard.nextInt();
            marks[index] = next;
            index++;
        } while (index < marksNumber);
        numberUsed = index;
    }

    public void add(int newElement) {
        if (numberUsed >= marks.length) {
            System.out.println("Error: Adding to a full array.");
            System.exit(0);
        } else {
            marks[numberUsed] = newElement;
            numberUsed++;
        }
    }

    public void validateMarks() {
        int num = numberUsed - 1;
        for (int i = num; i >= 0; i--) {
            if ((marks[i] < 0) || (marks[i] > 100)) {
                delete(i);
            }
        }
    }

    private void delete(int index) {
        if (index < 0 || index >= numberUsed) {
            System.out.println("Error:Illegal or unused index.");
            System.exit(0);
        }

        for (int i = index; i < numberUsed; i++) {
            marks[i] = marks[i + 1];
        }
        numberUsed--;
    }

    public void display() {
        System.out.print("Name: " + studentName + ", ID: " + studentID
                + ", marks: ");

        for (int i = 0; i < numberUsed; i++) {
            System.out.print(marks[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ValueAddedCourse c = new ValueAddedCourse("Somebody", "ID001");

//        int[] intarrMarks = {10, -15, 25, 102, 30};
//        ValueAddedCourse c = new ValueAddedCourse("Somebody", "ID001", intarrMarks);
        c.display();

        System.out.println("The value of marks of convern are:");
        c.validateMarks();
        c.display();
    }
}

/* Sample dialogue
run:
Maximumm size of an array: 5
Enter up to 5 marks.
arrMark [0] = 10
arrMark [1] = -15
arrMark [2] = 25
arrMark [3] = 102
arrMark [4] = 30
Name: Somebody, ID: ID001, marks: 10 -15 25 102 30 
The value of marks of convern are:
Name: Somebody, ID: ID001, marks: 10 25 30 
BUILD SUCCESSFUL (total time: 18 seconds)
 */
