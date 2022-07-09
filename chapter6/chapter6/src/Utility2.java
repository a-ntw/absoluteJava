
/* 220619 Absolute Java  Chapter6 Programming Projects.  Display 6.8 */
import java.util.Scanner;

/* Both methods use the parameter sentence as a local variable. If this 
 * puzzles you, review the material on parameters in Chapters 4 and 5, 
 * particularly Display 4.5 in Chapter 4.
 */
/**
 * String Processing Method with a Variable Number of Parameters.
 */
public class Utility2 {

    /* If you have trouble following this string processing, review the
     * subsection entitled “String Processing” in Chapter 1. */
    /**
     * Returns the first argument with all occurrences of other arguments
     * deleted.
     *
     * @param sentence sentence
     * @param unwanted unwanted
     * @return Return
     */
    public static String censor(String sentence, String... unwanted) {
        for (int i = 0; i < unwanted.length; i++) {
            sentence = deleteOne(sentence, unwanted[i]);
        }
        return sentence;
    }

    /**
     * Returns sentence with all occurrences of oneUnwanted removed.
     *
     * @param sentence sentence
     * @param oneUnwanted ineUnwanted
     * @return Return
     */
    private static String deleteOne(String sentence, String oneUnwanted) {
        String ending;
        int position = sentence.indexOf(oneUnwanted);
        while (position >= 0) //While word was found in sentence
        {
            ending = sentence.substring(position + oneUnwanted.length());
            sentence = sentence.substring(0, position) + ending;
            position = sentence.indexOf(oneUnwanted);
        }
        return sentence;
    }

    public static void main(String[] args) {
        System.out.println("What did you eat for dinner?");
        Scanner keyboard = new Scanner(System.in);
        String sentence = keyboard.nextLine();
        sentence = Utility2.censor(sentence,
                "candy", "french fries", "salt", "beer");
        sentence = Utility2.censor(sentence, " ,"); //Deletes extra commas
        System.out.println("You would be healthier if you could answer:");
        System.out.println(sentence);
    }
}

/* Sample dialogue
run:
What did you eat for dinner?
I ate salt cod, broccoli, french fries, salt peanuts, and apples.
You would be healthier if you could answer:
I ate  cod, broccoli,  peanuts, and apples.
BUILD SUCCESSFUL (total time: 10 seconds)
*/