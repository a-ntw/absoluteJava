
/** 220501
 * Absolute Java
 * Chapter1 Programming Projects
 * 10. Scientists estimate that roughly 10 grams of caffeine consumed at one
 * time is a lethal overdose. Write a program with a variable that holds the
 * number of milligrams of caffeine in a drink and outputs how many drinks it
 * takes to kill a person. A 12-ounce can of cola has approximately 34 mg of
 * caffeine, while a 16-ounce cup of coffee has approximately 160 mg of
 * caffeine.
 */
public class Proj0110_caffeine {

    public static final int OVERDOSE = 10; // grams of caffeine
    public static final double CAN_OF_COLA = 0.034; // grams of caffeine
    public static final double CUP_OF_COFFEE = 0.160; // grams of caffeine

    public static void main(String args[]) {

        System.out.println("Max can of cola: " + (int) (OVERDOSE / CAN_OF_COLA));
        System.out.println("Max cup of coffee: " + (int) (OVERDOSE / CUP_OF_COFFEE));
    }
}

/* Sample Dialogue
Max can of cola: 294
Max cup of coffee: 62
 */
