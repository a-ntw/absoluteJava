
/* 220712 Absolute Java  Chapter7 Programming Projects. Proj0702 */
/**
 * @see Message.java
 */
public class Email extends Message {

    private String sender;
    private String receiver;
    private String subject;

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setText(String text) {
        super.setText(text);
    }

    public String toString() {
        return "Sender: " + sender + ", Receiver: " + receiver
                + ", Subject: " + subject + ", Message: " + super.toString();
    }
}
