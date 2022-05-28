
/** 220411
 * Absolute Java
 * Chapter4 Programming Projects
 * 1. Write a program that outputs a certain coded language. The program should
 * print 26 code words, each comprising one letter and one digit,
 * for example, A0, B1, C2, D3, and so on.
 * Your program should not use 26 output statements!
 * Design your program with a class named PrintCodeword whose constructor takes
 * an initial value for the starting value of the letter, for example D, and
 * also an integer parameter that is the starting value of the number, for
 * example 5. In this case, the series of codewords will be D5, E6, F7, and
 * so on. There will always be a total of 26 codewords. If the value of letter
 * reaches Z, it will then automatically move to A. Similarly, if the value of
 * digit reaches 9, then it should also move automatically to 0 as shown below.
 * D5 E6 F7 G8 .... X5 Y6 Z7 A8 B9 C0
 *
 * Design your program with a public method called print_Code that outputs all
 * the code words. Provide initial values of letters and digits from the main
 * method class during object creation.
 */
public class PrintCodeword {

    private char letter;
    private int digit;

    private char nextLetter() {
        int nextCharInt = letter + 1;
        if (nextCharInt > 'Z') {
            nextCharInt = 'A';
        }

        return (char) nextCharInt;
    }

    private int nextDigit() {
        digit = digit + 1;
        if (digit >= 10) {
            digit = 0;
        }

        return digit;
    }

    public PrintCodeword(char letter, int digit) {
        this.letter = letter;
        this.digit = digit;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public void setDigit(int digit) {
        this.digit = digit;
    }

    public String toString() {
        return "" + letter + digit;
    }

    public void print_Code() {

        System.out.print(this + " "); // same as this.toString()

        for (int i = 0; i <= 24; i++) {
            this.letter = nextLetter();
            this.digit = nextDigit();
            System.out.print(this.toString() + " ");
        }

        System.out.println("\n");
    }

    public static void main(String args[]) {
        PrintCodeword code = new PrintCodeword('D', 5);
        code.print_Code();

        code.setLetter('A');
        code.setDigit(0);
        code.print_Code();
    }
}

/* Sample Dialogue
D5 E6 F7 G8 H9 I0 J1 K2 L3 M4 N5 O6 P7 Q8 R9 S0 T1 U2 V3 W4 X5 Y6 Z7 A8 B9 C0 

A0 B1 C2 D3 E4 F5 G6 H7 I8 J9 K0 L1 M2 N3 O4 P5 Q6 R7 S8 T9 U0 V1 W2 X3 Y4 Z5 
 */
