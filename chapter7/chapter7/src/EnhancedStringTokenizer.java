
/* 220711 Absolute Java  Chapter7 Programming Projects. Exec0723 */
 /* 220709 Absolute Java  Chapter7 Programming Projects. Disp0707 */
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Shows a derived class of the StringTokenizer class that allows you to cycle
 * through the tokens in a string any number of times.
 */
public class EnhancedStringTokenizer extends StringTokenizer {

    private String[] a;
    private int count;

    public EnhancedStringTokenizer(String theString) {
        super(theString);
        // The method countTokens is inherited and is not overridden.
        a = new String[countTokens()];
        count = 0;
    }

    public EnhancedStringTokenizer(String theString, String delimiters) {
        super(theString, delimiters);
        a = new String[countTokens()];
        count = 0;
    }

    /**
     * Returns the same value as the same method in the StringTokenizer class,
     * but it also stores data for the method tokensSoFar to use.
     */
    public String nextToken() {
        // super.nextTokens is the version of nextToken defined in the base 
        // class StringTokenizer. This is explained more fully in Section 7.3.
        String token = super.nextToken();
        a[count] = token;
        count++;
        return token;
    }

    /**
     * Returns the same value as the same method in the StringTokenizer class,
     * and changes the delimiter set in the same way as does the same method in
     * the StringTokenizer class, but it also stores data for the method
     * tokensSoFar to use.
     */ // This method nextToken also has its definition overridden.
    public String nextToken(String delimiters) {
        // super.nextTokens is the version of nextToken defined in the base 
        // class StringTokenizer.
        String token = super.nextToken(delimiters);
        a[count] = token;
        count++;
        return token;
    }

    /**
     * Returns an array of all tokens produced so far. Array returned has length
     * equal to the number of tokens produced so far.
     */ // tokensSoFar is a new method.
    public String[] tokensSoFar() {
        String[] arrayToReturn = new String[count];
        for (int i = 0; i < count; i++) {
            arrayToReturn[i] = a[i];
        }
        return arrayToReturn;
    }

    /*
     * Exec0723. The method {@code nextElement()} returns the same string as the
     * method {@code nextToken()}, but {@code nextElement()} returns it as
     * something of type {@code Object}, as opposed to type {@code String}. Give
     * a suitable definition of {@code nextElement} to add to the definition of
     * {@code EnhancedStringTokenizer}. This definition will override the
     * definition of nextElement in the class {@code StringTokenizer}.
     */
    public Object nextElement() {
        String token = super.nextToken();
        a[count] = token;
        count++;
        return (Object) token;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String sentence = keyboard.nextLine();

        EnhancedStringTokenizer wordFactory
                = new EnhancedStringTokenizer(sentence);
        System.out.println("Your sentence with extra blanks deleted:");
        while (wordFactory.hasMoreTokens()) {
            System.out.print(wordFactory.nextToken() + " ");
        }
        System.out.println();
        //All tokens have been dispensed.
        System.out.println("Sentence with each word on a separate line:");
        String[] token = wordFactory.tokensSoFar();
        for (int i = 0; i < token.length; i++) {
            System.out.println(token[i]);
        }
    }
}

/* Sample dialogue
run:
Enter a sentence:
I    love     you,    madly.
Your sentence with extra blanks deleted:
I love you, madly. 
Sentence with each word on a separate line:
I
love
you,
madly.
BUILD SUCCESSFUL (total time: 15 seconds)
 */
