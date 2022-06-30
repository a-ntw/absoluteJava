
/* 220616 Absolute Java  Chapter6 Programming Projects. Proj0611 */
import java.util.Scanner;

/**
 * Write a program to assign passengers seats in an airplane. Assume a small
 * airplane with seat numberings as follows:
 * <blockquote>{@code
 * 1 A B C D
 * 2 A B C D
 * 3 A B C D
 * 4 A B C D
 * 5 A B C D
 * 6 A B C D
 * 7 A B C D }</blockquote>
 * The program should display the seat pattern, with an 'X' marking the seats
 * already assigned. For example, after seats 1A, 2B, and 4C are taken, the
 * display should look like the following:
 * {@code 1XBCD 2AXCD 3ABCD 4ABXD 5ABCD 6ABCD 7ABCD}
 * <p>
 * After displaying the seats available, the program should prompt for the seat
 * desired, the user can type in a seat, and then the display of available seats
 * should be updated. This continues until all seats are filled or until the
 * user signals that the program should end. If the user types in a seat that is
 * already assigned, the program should say that that seat is occupied and ask
 * for another choice.
 */
public class PassengersSeats {

    private static final int COLUMN = 4;
    private final static int ROW = 7;
    private final char[][] seats = new char[ROW][COLUMN];
    private final int[] choosen = new int[2];

    public PassengersSeats() {
        Scanner keyboard = new Scanner(System.in);
        boolean toContNext;

        fillLabel();

        while (true) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            display();
            chkAllSeatsFilled();

            System.out.print("Choose your seat (eg 1A), or X to end: ");
            toContNext = true;

            innerloop:
            while (toContNext) {
                String pick = keyboard.next();
                if (!pickSeat(pick)) {
                    break innerloop;
                } else if (isOccupied(choosen[0], choosen[1])) {
                    System.out.print("The seat is occupied, pick another choice: ");
                } else {
                    seats[choosen[0]][choosen[1]] = 'X';
                    toContNext = false;
                }
            }
        }
    }

    private void fillLabel() {
        char n = 'A';
        for (int x = 0; x < COLUMN; x++) {
            for (int y = 0; y < ROW; y++) {
                seats[y][x] = n;
            }
            n += 1;
        }
    }

    private boolean pickSeat(String pick) {
        if (pick.equalsIgnoreCase("X")) {
            System.out.println("Exit");
            System.exit(0);
        } else if (!pickOK(pick)) {
            return false;
        }

        int pickY = Integer.valueOf(pick.substring(0, 1));
        choosen[0] = pickY - 1;
        char pickX = pick.toUpperCase().charAt(1);
        choosen[1] = columnInt(pickX);
        return true;
    }

    private boolean pickOK(String pick) {
        if (pick.length() != 2) {
            return false;
        }
        char y = pick.charAt(0);
        if (y >= '1') {
            if (Integer.parseInt(y + "") <= ROW) {
                return true;
            }
        }
        return false;
    }

    private int columnInt(char ch) {
        switch (ch) {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            case 'D':
                return 3;
            default:
                System.out.println("Error");
                System.exit(0);
        }
        return -1;
    }

    private boolean isOccupied(int y, int x) {
        return (seats[y][x] == 'X');
    }

    private void chkAllSeatsFilled() {
        for (char[] r : seats) {
            for (char c : r) {
                if (c != 'X') {
                    return;
                }
            }
        }
        System.out.println("All seats filled!");
        System.exit(0);
    }

    private void display() {
        for (int r = 0; r < ROW; r++) {
            System.out.print(r + 1);
            for (int c = 0; c < COLUMN; c++) {
                System.out.print("  " + seats[r][c]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PassengersSeats p = new PassengersSeats();
    }
}

/* Sample dialogue
1  A  B  C  D
2  A  B  C  D
3  A  B  C  D
4  A  B  C  D
5  A  B  C  D
6  A  B  C  D
7  A  B  C  D
Choose your seat (eg 1A), or X to end: 1a 2B 4C X
 */
