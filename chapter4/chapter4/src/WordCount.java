
/** 220520
 * Absolute Java
 * Chapter4
 * 5. Define a class called WordCount whose objects count the number of words in
 * a sentence. An object of this class maintains a variable count that is a
 * nonnegative integer. Include methods to set the counter to 0, to increase the
 * count by 1, and to decrease the count by 1 if any word encountered starts
 * with ‘A’ or ‘a’. Be sure that no method allows the value of the counter to
 * become negative. Include an accessor method that returns the current count
 * value and a method that outputs the count to the screen. There should be no
 * input method or other mutator methods. The only method that can set the
 * counter is the one that sets it to 0. Write a program (or programs) to test
 * all the methods in your class definition.
 */
public class WordCount {

    private int counter;

    public void counterSetZero() {
        this.counter = 0;
    }

    private void counterInc() {
        this.counter += 1;
    }

    private void counterDec() {
        if (this.counter <= 0) {
            counterSetZero();
        } else {
            this.counter -= 1;
        }
    }

    public int getCounter() {
        return counter;
    }

    public void counterPrint() {
        System.out.println("Count: " + this.getCounter());
    }

    public void countWords(String sent) {
        sent = ' ' + sent;
        int lgth = sent.length();
        char char1;

        counterSetZero();

        for (int i = 0; i < lgth - 1; i++) {
            char1 = sent.charAt(i + 1);
            if ((sent.charAt(i) == ' ') && (char1 != ' ')) {
                if ((char1 != 'a') && (char1 != 'A')) {
                    counterInc();
                } else {
                    counterDec();
                }
            }
        }
    }

    public static void main(String args[]) {

        String sentence = "Define a class called WordCount whose objects count "
                + "the number of words in a sentence.";

        WordCount c = new WordCount();
        c.countWords(sentence);
        c.counterPrint();
        c.counterSetZero();
        c.counterPrint();
        System.out.println("count: " + c.getCounter());
    }
}

/* Sample dialogue
run:
Count: 11
Count: 0
count: 0
BUILD SUCCESSFUL (total time: 0 seconds)

 */
