
/* 220616 Absolute Java  Chapter6 Programming Projects. Proj0613 */
import java.util.Scanner;

/**
 * Modify Programming Project 12 to use a single array instead of three arrays.
 * This can be accomplished by creating a {@code Trivia} object that
 * encapsulates the question, answer, and point value for a particular trivia
 * question. Next, create a single array of five {@code Trivia} objects instead
 * of three separate arrays for the question, answer, and point values. This
 * change will make your game more scalable if there were ever additional
 * properties to add to a {@code Trivia} object (you would not need to add
 * another array for each property). Although the program has internally changed
 * to a single array of objects, the execution of the program should be
 * identical to before.
 */
public class Trivia {

    public static final int MAX_SIZE = 5;
    private String question;
    private String answer;
    private int point;
    private Trivia[] arr = new Trivia[MAX_SIZE];

    public Trivia() {
    }

    private Trivia(String question, String answer, int point) {
        this.question = question;
        this.answer = answer;
        this.point = point;
    }

    private void fillArray() {
        arr[0] = new Trivia("One plus one equal", "two", 5);
        arr[1] = new Trivia("One plus two equal", "three", 5);
        arr[2] = new Trivia("One plus three equal", "four", 5);
        arr[3] = new Trivia("One plus four equal", "five", 5);
        arr[4] = new Trivia("One plus five equal. Choose [1] Six [2] Seven", "1", 5);
    }

    public void game() {
        Scanner keyboard = new Scanner(System.in);
        fillArray();

        int score = 0;
        for (int i = 0; i < MAX_SIZE; i++) {
            System.out.println("Question " + (i + 1) + ": " + arr[i].question);
            System.out.print("Your answer is: ");
            String ans = keyboard.next();
            if (ans.equalsIgnoreCase(arr[i].answer)) {
                System.out.println("Correct.");
                score += arr[i].point;
            } else {
                System.out.println("Oh, wrong! The answer is " + arr[i].answer);
            }
        }

        System.out.println("Total score: " + score);
    }

    public static void main(String[] args) {
        Trivia t = new Trivia();
        t.game();
    }

}
/*
run:
Question 1: One plus one equal
Your answer is: two
Correct.
Question 2: One plus two equal
Your answer is: Three
Correct.
Question 3: One plus three equal
Your answer is: FOUR
Correct.
Question 4: One plus four equal
Your answer is: five.
Oh, wrong! The answer is five
Question 5: One plus five equal. Choose [1] Six [2] Seven
Your answer is: 1
Correct.
Total score: 20
BUILD SUCCESSFUL (total time: 32 seconds)
 */
