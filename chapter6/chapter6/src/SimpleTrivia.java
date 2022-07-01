
/* 220616 Absolute Java  Chapter6 Programming Projects. Proj0612 */
import java.util.Scanner;

/**
 * Write a program that plays a simple trivia game. The game should have five
 * questions. Each question has a corresponding answer and point value between 1
 * and 3 based on the difficulty of the question. Implement the game using three
 * arrays. An array of type String should be used for the questions. Another
 * array of type String should be used to store the answers. An array of type
 * int should be used for the point values. All three arrays should be declared
 * to be of size 5.
 * <p>
 * The index into the three arrays can be used to tie the question, answer, and
 * point value together. For example, the item at index 0 for each array would
 * correspond to question 1, answer 1, and the point value for question 1. The
 * item at index 1 for each array would correspond to question 2, answer 2, and
 * the point value for question 2, and so forth. Manually hardcode the five
 * questions, answers and point values into your program using trivia of your
 * choice.
 * <p>
 * Your program should ask the player each question one at a time and allow the
 * player to enter an answer. If the player’s answer matches the actual answer,
 * the player wins the number of points for that question. If the player’s
 * answer is incorrect, the player wins no points for the question. Your program
 * should show the correct answer if the player is incorrect. After the player
 * has answered all five questions, the game is over, and your program should
 * display the player’s total score.
 */
public class SimpleTrivia {

    public static final int MAX_SIZE = 5;
    private static String[] arrQue = new String[MAX_SIZE];
    private static String[] arrAns = new String[MAX_SIZE];
    private static int[] arrPoi = new int[MAX_SIZE];

    public static void fillArray() {
        arrQue[0] = "One plus one equal";
        arrAns[0] = "two";
        arrQue[1] = "One plus two equal";
        arrAns[1] = "three";
        arrQue[2] = "One plus three equal";
        arrAns[2] = "four";
        arrQue[3] = "One plus four equal";
        arrAns[3] = "five";
        arrQue[4] = "One plus five equal. Choose [1] Six [2] Seven";
        arrAns[4] = "1";

        int[] temp = {5, 5, 5, 5, 5};
        arrPoi = temp;
    }

    public static void game() {
        Scanner keyboard = new Scanner(System.in);
        fillArray();

        int score = 0;
        for (int i = 0; i < MAX_SIZE; i++) {
            System.out.println("Question " + (i + 1) + ": " + arrQue[i]);
            System.out.print("Your answer is: ");
            String ans = keyboard.next();
            if (ans.equalsIgnoreCase(arrAns[i])) {
                System.out.println("Correct.");
                score += arrPoi[i];
            } else {
                System.out.println("Oh, wrong! The answer is " + arrAns[i]);
            }
        }

        System.out.println("Total score: " + score);
    }

    public void display() {
        for (int i = 0; i < MAX_SIZE; i++) {
            System.out.println(". " + arrQue[i] + " = " + arrAns[i] + ". Pts: "
                    + arrPoi[i]);
        }
    }

    public static void main(String[] args) {
        SimpleTrivia.game();
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
BUILD SUCCESSFUL (total time: 12 seconds)
 */
