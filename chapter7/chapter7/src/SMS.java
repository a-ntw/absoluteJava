
/* 220712 Absolute Java  Chapter7 Programming Projects. Proj0702 */
/**
 * @see Message.java
 */
public class SMS extends Message {

    private String recipientContactNo;

    public String getRecipientContactNo() {
        return recipientContactNo;
    }

    public void setRecipientContactNo(String recipientContactNo) {
        this.recipientContactNo = recipientContactNo;
    }

    public void setText(String text) {
        super.setText(text);
    }

    public String toString() {
        return recipientContactNo + " " + super.toString();
    }
}
