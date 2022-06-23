
/* 220622 Absolute Java  Chapter6 Programming Projects. Proj0602 */
import java.util.Random;
import java.util.Scanner;

/**
 * Write a program that plays the memory matching game. Use 16 cards that are
 * laid out in a 4  4 square and are labeled with pairs of numbers from 1 to 8.
 * Your program should allow the player to specify the cards that he or she
 * would like to select through a coordinate system. For example, in the
 * following layout: <blockquote>{@code
 *        1 2 3 4
 *      1 8 * * *
 *      2 * * * *
 *      3 * 8 * *
 *      4 * * * * }</blockquote>
 * all of the face down cards are indicated by *. The pairs of 8 that are face
 * up are at coordinates (1,1) and (2,3). To hide the cards that have been
 * temporarily placed face up, output a large number of newlines to force the
 * old board off the screen.
 */
public class MemoryGame {

    Scanner keyboard = new Scanner(System.in);

    private String[][] cards; // main memory matrix
    private String[][] faceUp; // display card with face down or face up

    public MemoryGame() {
        cards = new String[4][4];
        fillCard();
        faceUp = new String[4][4];
        fillFaceup();
    }

    public String[][] getCards() {
        return cards;
    }

    public String[][] getFaceUp() {
        return faceUp;
    }

    // filled cards[][] with number 1 to 8
    private void fillCard() {
        int number = 1;
        int i, j;
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                cards[i][j] = Integer.toString(number);
                number++;
                if (number > 8) {
                    number = 1;
                }
            }
        }
    }

    // fill faceUp[][] with "*"
    private void fillFaceup() {
        int i, j;
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                faceUp[i][j] = "*";
            }
        }
    }

    private void showCard(int x, int y) {
        if (faceUp[x][y] != "*") {
            System.out.println("Error, the card already open.");
            System.exit(0);
        }
        faceUp[x][y] = cards[x][y];
    }

    private void hideCard(int x, int y) {
        faceUp[x][y] = "*";
    }

    public static void display(String[][] a) {
        int i, j;
        System.out.println("    1 2 3 4");
        System.out.println("  ---------");
        for (i = 1; i < 5; i++) {
            System.out.print(i + " | ");
            for (j = 1; j < 5; j++) {
                System.out.print(a[i - 1][j - 1] + " ");
            }
            System.out.println();
        }
    }

    private boolean cardMatch(String a, String b) {
        return a.equalsIgnoreCase(b);
    }

    private int[] pickOrd() {
        //Scanner keyboard = new Scanner(System.in);
        int x, y;
        System.out.print("Pick the the card (x space y): ");
        y = keyboard.nextInt() - 1;
        x = keyboard.nextInt() - 1;
        if (x < 0 || x > 3 || y < 0 || y > 3) {
            System.out.println("Error, ordinate outside the range.");
            System.exit(0);
        }
        int[] ord = {x, y};
        return ord;
    }

    /**
     * To pick two cards and display. and check if match.
     */
    public void challenge() {

        int[] ord1 = pickOrd();
        showCard(ord1[0], ord1[1]);

        int[] ord2 = pickOrd();
        showCard(ord2[0], ord2[1]);

        display(faceUp);    // show cards
        String a = cards[ord1[0]][ord1[1]];
        String b = cards[ord2[0]][ord2[1]];
        if (cardMatch(a, b)) {
            System.out.println("Matched!");
        } else {
            System.out.println("Dont match!");
            hideCard(ord1[0], ord1[1]);
            hideCard(ord2[0], ord2[1]);
        }

        if (allMatched()) {
            System.out.println("YES! all matched!");
            System.exit(0);
        }
    }

    //to check if all fully match, and exist.
    private boolean allMatched() {
        for (String[] e : this.faceUp) {
            for (String f : e) {
                if (f == "*") {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * function that “shuffles” the cards in the array by repeatedly selecting
     * two cards at random and swapping them.
     *
     * @param loop numbers of times to shuffles
     */
    public void shuffles(int loop) {
        Random randomGenerator = new Random();
        int maxnum = 4, x0, y0, x1, y1;
        String temp;
        for (int i = 0; i < loop; i++) {
            x0 = randomGenerator.nextInt(maxnum);
            y0 = randomGenerator.nextInt(maxnum);
            x1 = randomGenerator.nextInt(maxnum);
            y1 = randomGenerator.nextInt(maxnum);

            temp = cards[x0][y0];
            cards[x0][y0] = cards[x1][y1];
            cards[x1][y1] = temp;
        }
    }

    /**
     * main.
     *
     * @param args args
     */
    public static void main(String[] args) {
        MemoryGame m = new MemoryGame();
        m.shuffles(20);
        m.display(m.getCards());

        String cont;
        boolean toContinue;
        do {
            //newlines to force the old board off the screen.
            for (int i = 0; i < 50; i++) {
                System.out.println("");
            }

            m.display(m.getFaceUp());
            m.challenge();

            System.out.print("To continue? 'Y'? ");
            cont = m.keyboard.next();
            toContinue = cont.equalsIgnoreCase("Y");
        } while (toContinue);
    }
}

/* Sample dialogue

    1 2 3 4
  ---------
1 | * * * * 
2 | * * * * 
3 | * * * * 
4 | * * * * 
Pick the 1st card (x space y): 1 1
Pick the 2nd card (x space y): 1 3
    1 2 3 4
  ---------
1 | 3 * * * 
2 | * * * * 
3 | 4 * * * 
4 | * * * * 
Dont match!
To continue? 'Y'? n
BUILD SUCCESSFUL (total time: 25 seconds)
 */
