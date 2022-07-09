
/* 220707 Absolute Java  Chapter6 Programming Projects. Proj0621 */
import java.util.Scanner;

/**
 * Redo Programming Project 6.20 but this time create a class named Player that
 * stores a player’s name and the player’s high score. The class should have
 * suitable constructors, accessors, and mutators. Next create a single array of
 * type Player that stores the players’ names and scores. Implement the same
 * features as in Programming Project 6.20 using the single array rather than
 * multiple arrays.
 *
 * @see PlayerList.java
 */
public class Player {

    public static final int MAX_NUM = 10;
    private String name;
    private int score;
    private static int index = 0;

    public static void start() {
        Player[] arr = new Player[MAX_NUM];
        menu(arr);
    }

    public Player() {
    }

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
        index++;
        if (index > MAX_NUM) {
            System.out.println("Error, exist limit.");
            System.exit(0);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        Player.index = index;
    }

    @Override
    public String toString() {
        return name + "\t" + score;
    }

    public static void add(Player[] arr, String name, int score) {
        arr[index] = new Player(name, score);
    }

    public static void addArray(Player[] arr, String[] name, int[] score) {
        int lgth = name.length;
        for (int i = 0; i < lgth; i++) {
            arr[index] = new Player(name[i], score[i]);
        }
    }

    public static void printAll(Player[] arr) {
        System.out.println("Index\tName\tScore ");
        for (int i = 0; i < index; i++) {
            System.out.println(i + ".\t" + arr[i]);
        }
    }

    public static boolean playerScore(Player[] arr, String n) {
        int i = 0;
        while (i < index) {
            if (n.equalsIgnoreCase(arr[i].name)) {
                System.out.println("Score: " + arr[i].score);
                return true;
            }
            i++;
        }
        System.out.println("Need to enter the correct namee.");
        return false;
    }

    public static boolean removePlayer(Player[] arr, String n) {
        int i = 0;
        while (i < index) {
            if (n.equalsIgnoreCase(arr[i].name)) {
                for (int j = i; j < (index - 1); j++) {
                    arr[j].name = arr[j + 1].name;
                    arr[j].score = arr[j + 1].score;
                }
                index--; // lower the last position 

                return true;
            }
            i++;
        }
        System.out.println("Need to enter the correct namee.");
        return false;
    }

    public static void menu(Player[] arr) {
        Scanner keyboard = new Scanner(System.in);
        String menu = "Select: \n a. Add a new player.\n"
                + " b. Print all the names and scores.\n"
                + " c. Enter name for the score.\n"
                + " d. Enter name to remove player.\n"
                + " q. quit.";
        System.out.println(menu);

        boolean toCont = true;
        while (toCont) {
            System.out.print("Pick: ");
            String n = keyboard.next().toLowerCase().substring(0, 1);
            switch (n) {
                case "a":
                    System.out.print("Name: ");
                    n = keyboard.next();
                    System.out.print("Score: ");
                    int s = keyboard.nextInt();
                    add(arr, n, s);
                    break;
                case "b":
                    printAll(arr);
                    break;
                case "c":
                    System.out.print("Enter name for the score: ");
                    n = keyboard.next();
                    playerScore(arr, n);
                    break;
                case "d":
                    System.out.print("Enter name for the player to remove: ");
                    n = keyboard.next();
                    removePlayer(arr, n);
                    break;
                case "q":
                    toCont = false;
                    break;
                default:
                    System.out.println(menu);
            }
        }
    }

    public static void main(String[] args) {
        Player[] arr = new Player[Player.MAX_NUM];
        Player.add(arr, "Alice", 100);
        arr[0].setName("Mary");
        arr[0].setScore(90);
        System.out.println("index:" + Player.getIndex());
        arr[1] = new Player("John", 49);

        String[] names = {"Alpha", "Bravo", "Charlie"};
        int[] scores = {11, 22, 33};
        Player.addArray(arr, names, scores);
        Player.printAll(arr);

        Player.menu(arr);
    }
}
/* Sample dialogue
run:
index:1
Index	Name	Score 
0.	Mary	90
1.	John	49
2.	Alpha	11
3.	Bravo	22
4.	Charlie	33
Select: 
 a. Add a new player.
 b. Print all the names and scores.
 c. Enter name for the score.
 d. Enter name to remove player.
 q. quit.
Pick: a
Name: Benson
Score: 80
Pick: c
Enter name for the score: john
Score: 49
Pick: d
Enter name for the player to remove: john
Pick: d
Enter name for the player to remove: alpha
Pick: b
Index	Name	Score 
0.	Mary	90
1.	Bravo	22
2.	Charlie	33
3.	Benson	80
Pick: q
BUILD SUCCESSFUL (total time: 37 seconds)
 */
