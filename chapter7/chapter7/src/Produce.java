
/* 220719 Absolute Java  Chapter7 Programming Projects. Proj0709 */
/**
 *
 * @see BoxOfProduce.java
 * @see Fruit.java
 * @see Vegetable.java
 */
public class Produce {

    private String name;

    public Produce() {
        this("no name yet");
    }

    public Produce(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (this.getClass() != other.getClass()) {
            return false;
        } else {
            Produce p = (Produce) other;
            return name.equalsIgnoreCase(p.name);   //          **** equals ****
        }
    }
}
