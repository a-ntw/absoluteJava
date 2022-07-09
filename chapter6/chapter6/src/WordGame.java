
/* 220705 Absolute Java  Chapter6 Programming Projects. Proj0619 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Some word games require the player to find words that can be formed using the
 * letters of another word. For example, given the word SWIMMING, other words
 * that can be formed using the letters include SWIM, WIN, WING, SING, MIMING,
 * etc. Write a program that lets the user enter a word and then output all the
 * words contained in the file {@code words.txt} that can be formed from the
 * letters of the entered word. One algorithm to do this is to compare the
 * letter histograms for each word. Create an array that counts up the number of
 * each letter in the entered word (e.g., one S, one W, two I, two M, etc.) and
 * then creates a similar array for the current word read from the file. The two
 * arrays can be compared to see if the word from the file could be created out
 * of the letters from the entered word.
 */
/*
 * 1. create histogram of the enteredWord[] 
 * 2. loop word from dictionary 
 * 3. create histogram for the dictWord[] 
 * 4. check if all letters with the enteredWord's histogram 
 * 5. if yes print out 
 */
public class WordGame {

    private static final String FILENAME
            //= "src/CSVRating.txt";
            = "../../source/dictionaries/large";
    private char[] letter;
    private int[] letterCount;
    private int letterNumUsed;

    public Scanner fileInput(Scanner fileIn) {
        try {
            // Attempt to Open the file
            fileIn = new Scanner(
                    new FileInputStream(FILENAME));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }
        return fileIn;
    }

    /**
     * counts up the number of each letter in the entered word. Initial letter,
     * letterCount and letterNumbered. Start for-next loop of entered word, also
     * within while loop of letter[]. During loop found letter = word.char,
     * increase the letter count. If no word.char found, create a new letter in
     * array.
     *
     * @param word entered word to place into WordGame();
     */
    public void histograms(String word) {
        word = word.toLowerCase();
        this.letter = new char[word.length()];
        this.letterCount = new int[word.length()];
        this.letterNumUsed = 0;

        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            int j = 0; // letter[] index
            boolean cont = true;
            while (cont) {
                if (j >= letterNumUsed) { // if till end unable to find letter
                    // set new letter
                    letter[letterNumUsed] = w;
                    letterCount[letterNumUsed]++;
                    letterNumUsed++;
                    cont = false;
                } else if (w == letter[j]) { // compare the word's char with letter
                    letterCount[j]++;
                    cont = false;
                }
                j++; // next letter[] index;
            }
        }
    }

    /**
     * To compare this current WordGame has other d WordGame all letters. Use
     * histogram of this word, to compare with histogram of word from
     * dictionary. Inner loop to check if both letters from dictionary and this
     * word the same, and letter counts is less than the this word histogram.
     *
     * @param d previously created Object WordGame
     * @return Return true if found word in dictionary.large.
     */
    public boolean contain(WordGame d) {
        int i = 0; // dictionary.word index
        outsideLoop:
        while (i < d.letterNumUsed) {
            int j = 0; // this object index
            while (j < letterNumUsed) {
                if ((d.letter[i] == letter[j])
                        && (d.letterCount[i] <= letterCount[j])) {
                    i++;
                    continue outsideLoop; // if fount quit this loop
                }
                j++; // next letter
            }
            return false;
        }
        return true;
    }

    /**
     * To print out the histogram of object, WordGame.
     *
     * @param w filled object WordGame
     */
    public void printHistogram(WordGame w) {
        for (int i = 0; i < w.letterNumUsed; i++) {
            System.out.print(" " + Character.toUpperCase(w.letter[i]));
        }
        System.out.println();
        for (int i = 0; i < w.letterNumUsed; i++) {
            System.out.print(" " + w.letterCount[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        String word = "SWIMMING";

        WordGame w = new WordGame(), // array for entered word
                q = new WordGame();  // array for dictionary word
        w.histograms(word);
        System.out.println("Histogram of word " + word + ":");
        w.printHistogram(w);

        Scanner fileIn = null;  // Initialize fileIn to empty
        fileIn = w.fileInput(fileIn);

        String textLine;
        boolean hasNextline;
        System.out.println("Word found: ");
        hasNextline = fileIn.hasNextLine(); // boolean to cont
        while (hasNextline) {
            textLine = fileIn.nextLine();
            q.histograms(textLine);

            if (w.contain(q)) {
                System.out.println(" : " + textLine.toUpperCase());
            }

            hasNextline = fileIn.hasNextLine(); // boolean to cont
        }
        fileIn.close(); // close file
    }
}

/* Sample dialogue
run:
Histogram of word SWIMMING:
 S W I M N G
 1 1 2 2 1 1
Word found:  
 : GIN
 : GINS
 : GM
 : I
 : IGN
 ...
 : WINGS
 : WINISM
 : WINS
 : WIS
 : WISING
BUILD SUCCESSFUL (total time: 0 seconds)
 */
