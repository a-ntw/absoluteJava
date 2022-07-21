
/* 220712 Absolute Java  Chapter7 Programming Projects. Proj0702 */
/**
 * Define a class named {@code Message} that contains an instance variable of
 * type String named text that stores any textual content for the
 * {@code Message}. Create a method named {@code toString} that returns the text
 * field and also include a method to set this value.
 * <p>
 * Next, define a class for {@code SMS} that is derived from {@code Message} and
 * includes instance variables for the {@code recipientContactNo}. Implement
 * appropriate accessor and mutator methods. The body of the {@code SMS} message
 * should be stored in the inherited variable text. Redefine the
 * {@code toString} method to concatenate all text fields.
 * <p>
 * Similarly, define a class for {@code Email} that is derived from
 * {@code Message} and includes an instance variable for the sender, receiver,
 * and subject. The textual contents of the file should be stored in the
 * inherited variable text. Redefine the {@code toString} method to concatenate
 * all text fields.
 * <p>
 * Create sample objects of type {@code Email} and {@code SMS} in your main
 * method. Test your objects bypassing them to the following subroutine that
 * returns true if the object contains the specified keyword in the text
 * property. <blockquote>{@code
 *      public static boolean ContainsKeyword(Message messageObject,
 *          String keyword) {
 *              if (messageObject.toString().indexOf(keyword, 0) >= 0) {
 *                  return true;
 *          }
 *          return false;
 * }
 * }</blockquote>
 * Finally, include a method to encode the final message “This is Java” using an
 * encoding scheme, according to which, each character should be replaced by the
 * character that comes after it. For example, if the message contains character
 * B or b, it should be replaced by C or c accordingly, while Z or z should be
 * replaced with an A or a. If the final message is “This is Java”, then the
 * encoded message should be “UijtjtKbwb”.
 *
 * @see SMS.java
 * @see Email.java
 */
public class Message {

    private String text;

    public String toString() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static void main(String[] args) {

        SMS s = new SMS();
        s.setRecipientContactNo("1234567");
        s.setText("Hello");
        //System.out.println(">>> " + s);
        System.out.println("SMS contain 123: " + ContainsKeyword(s, "123"));

        Email e = new Email();
        e.setSender("Mr Hello");
        e.setReceiver("Mr receiver");
        e.setSubject("This is subject");
        e.setText("This is hello sending.");
        //System.out.println(">>> " + e);
        System.out.println("Email contain hello: " + ContainsKeyword(e, "hello"));

        System.out.println("Java: " + encode("This is Java"));
    }

    public static boolean ContainsKeyword(
            Message messageObject, String keyword) {

        if (messageObject.toString().indexOf(keyword, 0) >= 0) {
            return true;
        }

        return false;
    }

    public static String encode(String text) {
        String result = "";
        char c;
        for (int i = 0; i < text.length(); i++) {
            c = text.charAt(i);
            result += nextLetter(c);
        }

        return result;
    }

    private static char nextLetter(char letter) {
        int charInt = letter;
        if ((charInt == 'Z') || (charInt == 'z')) {
            charInt -= 25;
        } else {
            charInt = letter + 1;
        }

        return (char) charInt;
    }
}

/* Sample dialogue
run:
SMS contain 123: true
Email contain hello: true
Java: Uijt!jt!Kbwb
BUILD SUCCESSFUL (total time: 0 seconds)
 */
