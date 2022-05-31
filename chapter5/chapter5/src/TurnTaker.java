
/**
 * Display 5.4.
 * shows an example of a class with a static variable along with a demonstration
 * program. Notice that the two objects, lover1 and lover2, access the same
 * static variable turn.
 */
public class TurnTaker {

    private static int turn = 0;

    private int myTurn;
    private String name;

    public TurnTaker(String theName, int theTurn) {
        name = theName;
        if (theTurn >= 0) {
            myTurn = theTurn;
        } else {
            System.out.println("Fatal Error.");
            System.exit(0);
        }
    }

    public TurnTaker() {
        name = "No name yet";
        myTurn = 0; //Indicating no turn.
    }

    public String getName() {
        return name;
    }

    public static int getTurn() {
        turn++;
        return turn;
    }

    public boolean isMyTurn() {
        return (turn == myTurn);
    }

    public static void main(String[] args) {
        TurnTaker lover1 = new TurnTaker("Romeo", 1);
        TurnTaker lover2 = new TurnTaker("Juliet", 3);
        for (int i = 1; i < 5; i++) {
            System.out.println("Turn = " + TurnTaker.getTurn());
            if (lover1.isMyTurn()) {
                System.out.println("Love from " + lover1.getName());
            }
            if (lover2.isMyTurn()) {
                System.out.println("Love from " + lover2.getName());
            }
        }
    }
}

/* Sample dialogue
Turn = 1
Love from Romeo
Turn = 2
Turn = 3
Love from Juliet
Turn = 4
 */
