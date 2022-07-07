
/* 220706 Absolute Java  Chapter6 Programming Projects. Proj0620 */
import java.util.Scanner;

/**
 * Write a program that manages a list of up to 10 players and their high scores
 * in the computer’s memory (not on disk for this Programming Project). Use two
 * arrays to manage the list. One array should store the players’ names, and the
 * other array should store the players’ high scores. Use the index of the
 * arrays to correlate the names with the scores. Your program should support
 * the following features:
 * <li> a. Add a new player and score (up to 10 players).
 * <li> b. Print all the players’ names and their scores to the screen.
 * <li> c. Allow the user to enter a player’s name and output that player’s
 * score or a message if that player’s name has not been entered.
 * <li> d. Allow the user to enter a player’s name and remove the player from
 * the list.
 * <p>
 * Create a menu system that allows the user to select which option to invoke.
 */
public class PlayerList {

    public static final int MAX_NUM = 10; // maximum number to store
    private String[] name;  //              player name array
    private int[] score; //                 player score array
    private int index;  //                  index for name and score

    public PlayerList() {
        name = new String[MAX_NUM];
        score = new int[MAX_NUM];
        index = 0;
    }

    public void add(String name, int score) {
        if (index >= MAX_NUM) {
            System.out.println("Error, reached maximum limit of players.");
            System.exit(0);
        }
        this.name[index] = name;
        this.score[index] = score;
        index++;
    }

    public void printAll() {
        for (int i = 0; i < index; i++) {
            System.out.println(name[i] + " " + score[i]);
        }
    }

    public boolean playerScore(String n) {
        int i = 0;
        while (i < index) {
            if (n.equalsIgnoreCase(name[i])) {
                System.out.println("Score: " + score[i]);
                return true;
            }
            i++;
        }
        System.out.println("Need to enter the correct namee.");
        return false;
    }

    public boolean removePlayer(String n) {
        int i = 0;
        while (i < index) {
            if (n.equalsIgnoreCase(name[i])) {
                for (int j = i; j < (index - 1); j++) {
                    name[j] = name[j + 1];
                    score[j] = score[j + 1];
                }
                index--; // lower the last position 

                return true;
            }
            i++;
        }
        System.out.println("Need to enter the correct namee.");
        return false;
    }

    public void menu() {
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
                    add(n, s);
                    break;
                case "b":
                    printAll();
                    break;
                case "c":
                    System.out.print("Enter name for the score: ");
                    n = keyboard.next();
                    playerScore(n);
                    break;
                case "d":
                    System.out.print("Enter name for the player to remove: ");
                    n = keyboard.next();
                    removePlayer(n);
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
        PlayerList p = new PlayerList();
        p.add("Ali", 100);
        p.add("Mary", 90);
        p.add("John", 49);
        p.menu();
    }
}

/* Sample dialogue
run:
Select: 
 a. Add a new player.
 b. Print all the names and scores.
 c. Enter name for the score.
 d. Enter name to remove player.
 q. quit.
Pick: a
Name: Benson
Score: 80
Pick: b
Ali 100
Mary 90
John 49
Benson 80
Pick: c
Enter name for the score: John
Score: 49
Pick: d
Enter name for the player to remove: John
Pick: b
Ali 100
Mary 90
Benson 80
Pick: q
BUILD SUCCESSFUL (total time: 1 minute 1 second)
 */
