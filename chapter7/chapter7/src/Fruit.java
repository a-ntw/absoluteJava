
/* 220719 Absolute Java  Chapter7 Programming Projects. Proj0709 */
/**
 *
 * @see BoxOfProduce.java
 */
public class Fruit extends Produce {

    public Fruit(String name) {
        super.setName(name);
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (this.getClass() != other.getClass()) {
            return false;
        } else {
            Fruit f = (Fruit) other;
            return super.equals(f);
        }
    }
}
