
/* 220719 Absolute Java  Chapter7 Programming Projects. Proj0709 */
/**
 *
 * @see BoxOfProduce.java
 */
public class Vegetable extends Produce {

    public Vegetable(String name) {
        super.setName(name);
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (this.getClass() != other.getClass()) {
            return false;
        } else {
            Vegetable v = (Vegetable) other;
            return super.equals(v);
        }
    }
}
