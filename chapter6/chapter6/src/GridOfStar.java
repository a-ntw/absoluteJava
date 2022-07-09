
/* 220629 Absolute Java  Chapter6 Programming Projects. Proj0610*/
import java.util.Random;
import java.util.Scanner;

/**
 * Write a program to simulate a simple game using arrays. The program should
 * create a grid of stars using 2D arrays for the user to move in. When the
 * program is started, the user’s current position should be generated randomly
 * in row and column format. It should then ask the user for the movement
 * selection, i.e., left, right, up, and down. The program should then reprint
 * the grid with the old location of user replaced with a $ symbol and the new
 * location with an N symbol. The program displays the game positions as
 * follows:
 * <blockquote>{@code   * * *
 *                      * * *
 *                      * * * }</blockquote>
 * A sample grid configuration is
 * <blockquote>{@code   * * *
 *                      $ N *
 *                      * * * }</blockquote>
 */
public class GridOfStar {

    public static final int lg = 3; // lgth size of array
    private char[][] arr = new char[lg][lg];
    private static final int[] pos = new int[2]; // y,x position

    public static void start() {
        GridOfStar star = new GridOfStar();
        star.fillStars();

        pos[0] = randomPos(lg); // y position
        pos[1] = randomPos(lg); // x position

        star.replace('N');
        star.display();

        while (true) {
            star.moveIJKL();
            star.display();
        }
    }

    public void moveIJKL() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Up<i>; Left<j>; Down<k> or Right<l>: ");
        char ch = keyboard.next().toLowerCase().charAt(0);

        switch (ch) {
            case 'i':   // up
                if (pos[0] > 0 && ok(0, -1)) {
                    move(0, -1);
                }
                break;
            case 'j':   //  left
                if (pos[1] > 0 && ok(-1, 0)) {
                    move(-1, 0);
                }
                break;
            case 'k':   // down
                if (pos[0] < lg - 1 && ok(0, 1)) {
                    move(0, 1);
                }
                break;
            case 'l':   //  right
                if (pos[1] < lg - 1 && ok(1, 0)) {
                    move(1, 0);
                }
                break;
            default:    // do nothing
                System.out.println("Error. Exit game!");
                System.exit(0);
        }
    }

    private void move(int right, int down) {
        replace('$');
        pos[0] += down;
        pos[1] += right;
        replace('N');
    }

    // check if next position if '*'
    private boolean ok(int right, int down) {
        int y = pos[0] + down;
        int x = pos[1] + right;
        return arr[y][x] == '*';
    }

    public void fillStars() {
        for (int y = 0; y < lg; y++) {
            for (int x = 0; x < lg; x++) {
                arr[y][x] = '*';
            }
        }
    }

    public void display() {
        for (char[] e : arr) {
            for (char s : e) {
                System.out.print(" " + s);
            }
            System.out.println();
        }
    }

    public static int randomPos(int lgth) {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(lgth);
    }

    public void replace(char ch) {
        arr[pos[0]][pos[1]] = ch;
    }

    public static void main(String[] args) {
        GridOfStar.start();
    }
}

/* Sample dialogue
run:
 * * N
 * * *
 * * *
Up<i>; Left<j>; Down<k> or Right<l>: k
 * * $
 * * N
 * * *
Up<i>; Left<j>; Down<k> or Right<l>: 
BUILD SUCCESSFUL (total time: 5 seconds)
 */
