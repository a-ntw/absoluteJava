
/** 220414
 * Absolute Java
 * Chapter4 Programming Projects
 * 6. Write a grading program for a class with the following grading policies:
 *      a. There are three quizzes, each graded on the basis of 10 points.
 *      b. There is one midterm exam, graded on the basis of 100 points.
 *      c. There is one final exam, graded on the basis of 100 points.
 *
 * The final exam counts for 40% of the grade. The midterm counts for 35% of
 * the grade. The three quizzes together count for a total of 25% of the grade.
 * (Do not forget to convert the quiz scores to percentages before they are
 * averaged in.)
 *
 * Any grade of 90 or more is an A, any grade of 80 or more (but less than 90)
 * is a B, any grade of 70 or more (but less than 80) is a C, any grade of 60
 * or more (but less than 70) is a D, and any grade below 60 is an F. The
 * program should read in the student’s scores and output the student’s record,
 * which consists of three quiz scores and two exam scores, as well as the
 * student’s overall numeric score for the entire course and final letter grade.
 *
 * Define and use a class for the student record. The class should have instance
 * variables for the quizzes, midterm, final, overall numeric score for the
 * course, and final letter grade. The overall numeric score is a number in the
 * range 0 to 100, which represents the weighted average of the student’s work.
 * The class should have methods to compute the overall numeric grade and the
 * final letter grade. These last methods should be void methods that set the
 * appropriate instance variables. Your class should have a reasonable set of
 * accessor and mutator methods, an equals method, and a toString method,
 * whether or not your program uses them. You may add other methods if you wish.
 */
public class GradingProgram {

    private int quizA;      // graded on the basis of 10 points ea
    private int quizB;
    private int quizC;
    private int midterm;    //in %. midterm exam, graded on the basis of 100 points
    private int finalExam;  //in %. final exam, graded on the basis of 100 points
    private int overall;    //in %. a number in the range 0 to 100
    private char grade;    // final letter grade, A to F

    /*  The final exam counts for 40% of the grade.
        The midterm counts for 35% of the grade.
        The three quizzes together count for a total of 25% of the grade.*/
    private void computeFinalNum() {
        int threeQuizzesInPercent = (quizA + quizB + quizC) * 100 / 30;
        this.overall = (this.finalExam * 40 / 100
                + this.midterm * 35 / 100
                + threeQuizzesInPercent * 25 / 100);
    }

    private void computeGrade() {
        if (overall >= 90) {
            grade = 'A';
        } else if (overall >= 80) {
            grade = 'B';
        } else if (overall >= 70) {
            grade = 'C';
        } else if (overall >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
    }

    public boolean equals(GradingProgram others) {
        return ((this.quizA == others.quizA)
                && (this.quizB == others.quizB)
                && (this.quizC == others.quizC)
                && (this.midterm == others.midterm)
                && (this.finalExam == others.finalExam));
    }

    @Override
    public String toString() {
        return "Quiz scores: " + quizA + ", " + quizB + ", "
                + quizC + ", midterm exam: " + midterm + ", final exam: " + finalExam
                + ", overall score(%): " + overall + ", grade: " + grade;
    }

    public void setQuizA(int quizA) {
        if (quizA > 10 || quizA < 0) {
            System.out.println("Fatal Error!");
            System.exit(0);
        } else {
            this.quizA = quizA;
        }
    }

    public void setQuizB(int quizB) {
        if (quizB > 10 || quizB < 0) {
            System.out.println("Fatal Error!");
            System.exit(0);
        } else {
            this.quizB = quizB;
        }
    }

    public void setQuizC(int quizC) {
        if (quizC > 10 || quizC < 0) {
            System.out.println("Fatal Error!");
            System.exit(0);
        } else {
            this.quizC = quizC;
        }
    }

    public void setMidterm(int midterm) {
        if (midterm > 100 || midterm < 0) {
            System.out.println("Fatal Error!");
            System.exit(0);
        } else {
            this.midterm = midterm;
        }
    }

    public void setFinalExam(int finalExam) {
        if (finalExam > 100 || finalExam < 0) {
            System.out.println("Fatal Error!");
            System.exit(0);
        } else {
            this.finalExam = finalExam;
        }
    }

    public void setOverall() {
        this.computeFinalNum();
    }

    public void setGrade() {
        this.computeGrade();
    }

    public int getQuizA() {
        return quizA;
    }

    public int getQuizB() {
        return quizB;
    }

    public int getQuizC() {
        return quizC;
    }

    public int getOverall() {
        this.setOverall();
        return overall;
    }

    public char getGrade() {
        this.setOverall();
        this.setGrade();
        return grade;
    }

    public int getMidterm() {
        return midterm;
    }

    public int getFinalExam() {
        return finalExam;
    }

    public static void main(String args[]) {

        GradingProgram g = new GradingProgram();
        g.setQuizA(6);
        g.setQuizB(7);
        g.setQuizC(8);
        g.setMidterm(70);
        g.setFinalExam(70);
        g.setOverall();
        g.setGrade();

        GradingProgram o = new GradingProgram();
        o.setQuizA(6);
        o.setQuizB(7);
        o.setQuizC(8);
        o.setMidterm(70);
        o.setFinalExam(70);

        if (g.equals(o)) {
            System.out.println(g + "\nequals to\n" + o);
        } else {
            System.out.println(g + "\ndoes not equal to\n" + o);
        }

        System.out.println("grade: " + o.getGrade());

    }
}

/* Sample dialogue
Quiz scores: 6, 7, 8, midterm exam: 70, final exam: 70, overall score(%): 69, grade: D
equals to
Quiz scores: 6, 7, 8, midterm exam: 70, final exam: 70, overall score(%): 0, grade: 
grade: D
 */
