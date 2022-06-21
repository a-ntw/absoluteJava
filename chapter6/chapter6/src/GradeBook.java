
/* 220621 Absolute Java  Chapter6 Programming Projects.  Display 6.18 */
import java.util.Scanner;

/**
 * A Grade Book Class
 */
public class GradeBook {

    private int numberOfStudents; // Same as studentAverage.length.
    private int numberOfQuizzes; // Same as quizAverage.length.
    private int[][] grade; //numberOfStudents rows and numberOfQuizzes //columns.
    private double[] studentAverage;
    private double[] quizAverage;

    public GradeBook(int[][] a) {
        if (a.length == 0 || a[0].length == 0) {
            System.out.println("Empty grade records. Aborting.");
            System.exit(0);
        }
        numberOfStudents = a.length;
        numberOfQuizzes = a[0].length;
        fillGrade(a);
        fillStudentAverage();
        fillQuizAverage();
    }

    public GradeBook(GradeBook book) {
        numberOfStudents = book.numberOfStudents;
        numberOfQuizzes = book.numberOfQuizzes;
        fillGrade(book.grade);
        fillStudentAverage();
        fillQuizAverage();
    }

    public GradeBook() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter number of students:");
        numberOfStudents = keyboard.nextInt();

        System.out.println("Enter number of quizzes:");
        numberOfQuizzes = keyboard.nextInt();

        grade = new int[numberOfStudents][numberOfQuizzes];
        for (int studentNumber = 1;
                studentNumber <= numberOfStudents; studentNumber++) {
            for (int quizNumber = 1;
                    quizNumber <= numberOfQuizzes; quizNumber++) {
                System.out.println("Enter score for student number "
                        + studentNumber);
                System.out.println("on quiz number " + quizNumber);
                grade[studentNumber - 1][quizNumber - 1] = keyboard.nextInt();

                fillStudentAverage();
                fillQuizAverage();
            }
        }
    }

    private void fillGrade(int[][] a) {
        grade = new int[numberOfStudents][numberOfQuizzes];
        for (int studentNumber = 1;
                studentNumber <= numberOfStudents; studentNumber++) {
            for (int quizNumber = 1;
                    quizNumber <= numberOfQuizzes; quizNumber++) {
                grade[studentNumber - 1][quizNumber - 1]
                        = a[studentNumber - 1][quizNumber - 1];
            }
        }
    }

    /**
     * Fills the array studentAverage using the data from the array grade.
     */
    private void fillStudentAverage() {
        studentAverage = new double[numberOfStudents];

        for (int studentNumber = 1;
                studentNumber <= numberOfStudents; studentNumber++) {
            //Process one studentNumber:
            double sum = 0;
            for (int quizNumber = 1;
                    quizNumber <= numberOfQuizzes; quizNumber++) {
                sum = sum + grade[studentNumber - 1][quizNumber - 1];
                //sum contains the sum of the quiz scores for student number 
                //studentNumber.
                studentAverage[studentNumber - 1] = sum / numberOfQuizzes;
                //Average for student studentNumber is 
                //studentAverage[studentNumber - 1]
            }
        }
    }

    /**
     * Fills the array quizAverage using the data from the array grade.
     */
    private void fillQuizAverage() {
        quizAverage = new double[numberOfQuizzes];

        for (int quizNumber = 1; quizNumber <= numberOfQuizzes; quizNumber++) {
            //Process one quiz (for all students):
            double sum = 0;
            for (int studentNumber = 1;
                    studentNumber <= numberOfStudents;
                    studentNumber++) {
                sum = sum + grade[studentNumber - 1][quizNumber - 1];
            }
            //sum contains the sum of all student scores on quiz number
            //quizNumber.
            quizAverage[quizNumber - 1] = sum / numberOfStudents;
            //Average for quiz quizNumber is the value of
            //quizAverage[quizNumber - 1]
        }
    }

    /**
     * Display all.
     */
    public void display() {
        for (int studentNumber = 1;
                studentNumber <= numberOfStudents; studentNumber++) {
            //Display for one studentNumber:
            System.out.print("Student " + studentNumber + " Quizzes: ");
            for (int quizNumber = 1;
                    quizNumber <= numberOfQuizzes; quizNumber++) {
                System.out.print(grade[studentNumber - 1][quizNumber - 1] + " ");
            }
            System.out.println(" Ave = " + studentAverage[studentNumber - 1]);
        }
        System.out.println("Quiz averages: ");
        for (int quizNumber = 1; quizNumber <= numberOfQuizzes;
                quizNumber++) {
            System.out.print("Quiz " + quizNumber
                    + " Ave = " + quizAverage[quizNumber - 1]
                    + " ");
        }
        System.out.println();
    }

    /**
     * Exec0614 Returns the grade that student numbered studentNumber received
     * on quiz number quizNumber.
     */
    public int getGrade(int studentNumber, int quizNumber) {
        return grade[studentNumber][quizNumber];
    }

    /**
     * Exec0625 Changes the grade for student number studentNumber on quiz
     * number quizNumber to newGrade.
     */
    public void changeGrade(int studentNumber, int quizNumber, int newGrade) {
        grade[studentNumber][quizNumber] = newGrade;
    }

    /**
     * Exec0626 Returns an array with the average quiz score for each student.
     */
    public double[] getStudentAverages() {
        int arraySize = studentAverage.length;
        double[] temp = new double[arraySize];
        for (int i = 0; i < arraySize; i++) {
            temp[i] = studentAverage[i];
        }
        return temp;
    }

    /**
     * Returns an array with the average score for each quiz.
     */
    public double[] getQuizAverages() {
        int arraySize = quizAverage.length;
        double[] temp = new double[arraySize];
        for (int i = 0; i < arraySize; i++) {
            temp[i] = quizAverage[i];
        }
        return temp;
    }

    /**
     * main.
     *
     * @param args args
     */
    public static void main(String[] args) {
        GradeBook book = new GradeBook();
        book.display();
    }
}

/* Sample dialogue
run:
Enter number of students:
4
Enter number of quizzes:
3
...
...
Student 1 Quizzes: 10 10 10  Ave = 10.0
Student 2 Quizzes: 2 0 1  Ave = 1.0
Student 3 Quizzes: 8 6 9  Ave = 7.666666666666667
Student 4 Quizzes: 8 4 10  Ave = 7.333333333333333
Quiz averages: 
Quiz 1 Ave = 7.0 Quiz 2 Ave = 5.0 Quiz 3 Ave = 7.5 
BUILD SUCCESSFUL (total time: 51 seconds)
 */
