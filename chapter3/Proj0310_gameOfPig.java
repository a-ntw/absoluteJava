
/** 220402
 * Absolute Java
 * Chapter3 Programming Projects
 * 10. The game of Pig is a simple two-player dice game in which the first
 * player to reach 100 or more points wins. Players take turns. On each turn,
 * a player rolls a six-sided die:
 *  *   If the player rolls a 1, then the player gets no new points and it
 *      becomes the other player’s turn.
 *  *   If the player rolls 2 through 6, then he or she can either
 *      *   ROLL AGAIN or
 *      *   HOLD. At this point, the sum of all rolls is added to the player’s
 *          score, and it becomes the other player’s turn.
 *
 * Write a program that plays the game of Pig, where one player is a human and
 * the other is the computer. When it is the human’s turn, the program should
 * show the score of both players and the previous roll. Allow the human to
 * input “r” to roll again or “h” to hold.
 * The computer program should play according to the following rule:
 *  *   Keep rolling when it is the computer’s turn until it has accumulated 20
 *      or more points, then hold. If the computer wins or rolls a 1, then the
 *      turn ends immediately.
 * Allow the human to roll first.
 */
/**
 * Pseudocode.
 * Human turn with 0 temp accumulated points (accPoints)
 * input 'r' or 'h'
 * do-while ... 'r' throw dice,
 *      if dice is '1', next player
 *      if dice is 2 - 6, added in accPoints
 * if 'h', add accPoints to humanScore, and next player
 * if humanScore > 100, Human win, and exit games
 *
 * next Player is computer turn, with 0 accPoints
 * do-while ... throw dice
 *      if dice is '1', next player
 *      if dice is 2 - 6,added in temp accumulated points
 * if acc more than 20, added accPoints to ComputerPoint
 * if computerScore > 100, Computer win, and exit games
 * else back to human turn
 */
import java.util.Scanner;

/**
 *
 * @author antw
 */
public class Proj0310_gameOfPig {

    public static final int WINS_POINT = 100;
    public static final int COMPUTER_ACCUMULATED_POINTS_TO_HOLD = 20;

    public static void main(String args[]) {

        Scanner keyboard = new Scanner(System.in);
        int pointToHold = COMPUTER_ACCUMULATED_POINTS_TO_HOLD;
        int humanPoint = 0, computerPoint = 0, accPoint, dicePoint = 0;
        String input;
        System.out.println("*** The game of Pig ***");
        System.out.println("\nYou(human) will start first. <Q> to exit.");

        System.out.printf("Human's score: %d | Computer's score: %d %n%n",
                humanPoint, computerPoint);

        outerloop:
        while (true) {
            accPoint = 0;
            humanTurn:
            do {
                System.out.print("Your turn to ROLL AGAIN(r) or HOLD(h): ");
                input = keyboard.next();
                if (input.equalsIgnoreCase("r")) {
                    dicePoint = (int) ((Math.random() * 6) + 1);
                    System.out.println("Dice: " + dicePoint);
                    accPoint += dicePoint;
                } else if (input.equalsIgnoreCase("h")) {
                    humanPoint += accPoint;
                } else if (input.equalsIgnoreCase("q")) {
                    System.exit(0); // 'q' to exit the game!
                }
            } while (!input.equalsIgnoreCase("h") && (dicePoint > 1));

            System.out.printf("\nHuman's score: %d | Computer's score: %d %n",
                    humanPoint, computerPoint);

            if (humanPoint >= WINS_POINT) {
                System.out.println("You(human) win!");
                break;
            }

            System.out.println("Now, computer's turn!");
            accPoint = 0;
            computerTurn:
            do {
                dicePoint = (int) ((Math.random() * 6) + 1);
                System.out.println("Dice: " + dicePoint);
                if (dicePoint > 1) {
                    accPoint += dicePoint;

                    if (accPoint >= pointToHold) {
                        computerPoint += accPoint;
                    }
                }
            } while ((dicePoint > 1) && !(accPoint >= pointToHold));

            System.out.printf("\nHuman's score: %d | Computer's score: %d %n",
                    humanPoint, computerPoint);

            if (computerPoint >= WINS_POINT) {
                System.out.println("Computer win!");
                break;
            }
        }

    }
}

/* Sample Dialogue
antw@Mac-mini chapter3 % java Proj0310_gameOfPig.java
*** The game of Pig ***

You(human) will start first. <Q> to exit.
...
Human's score: 82 | Computer's score: 87 
Your turn to ROLL AGAIN(r) or HOLD(h): r
Dice: 5
You turn to ROLL AGAIN(r) or HOLD(h): r
Dice: 1

Human's score: 82 | Computer's score: 87 
Now, computer's turn!
Dice: 5
Dice: 3
Dice: 5
Dice: 6
Dice: 6

Human's score: 82 | Computer's score: 112 
Computer win!
 */
