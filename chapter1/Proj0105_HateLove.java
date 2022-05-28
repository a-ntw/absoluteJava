
/** 220326
 * Absolute Java
 * Chapter1 Programming Projects
 * 5. Write a program that starts with a line of text and then outputs that
 * line of text with the first occurrence of "hate" changed to "love".
 *
 * You can assume that the word "hate" occurs in the input. If the word "hate"
 * occurs more than once in the line, your program will replace only the first
 * occurrence of "hate".  Use a defined constant for the string to be changed.
 * To make your program work for another string, you should only need to
 * change the definition of this defined constant.
 */
public class Proj0105_HateLove {

    public static void main(String args[]) {
//        System.out.println("012345678901234567890123456789");

        String sentence = "I hate you. I hate you.";
        System.out.println("The line of text to be changed is:");
        System.out.println(sentence);

        int position = sentence.indexOf("hate");
        String ending = sentence.substring(position + "hate".length());
        sentence = sentence.substring(0, position) + "love" + ending;

        System.out.println("I have rephased that line to read:");
        System.out.println(sentence);

    }
}

/* Sample Dialogue
The line of text to be changed is:
I hate you. I hate you.
I have rephased that line to read:
I love you. I hate you.
 */
