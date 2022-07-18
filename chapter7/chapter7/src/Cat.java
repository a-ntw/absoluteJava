
/* 220718 Absolute Java  Chapter7 Programming Projects. Proj0708 */
/**
 * ref: Proj0419.
 *
 * @see Pet.java
 */
public class Cat extends Pet {

    public Cat() {
        this("No name yet.", 0, 0);
    }

    public Cat(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public double acepromazine() {
        int mgPerMl = 10;
        double mgPerKg = 0.002,
                dosageMl = super.getWeight() / 2.2 * mgPerKg / mgPerMl;
        return dosageMl;
    }

    @Override
    public double carprofen() {
        int mgPerMl = 12;
        double mgPerKg = 0.25, 
                dosageMl = super.getWeight() / 2.2 * mgPerKg / mgPerMl;
        return dosageMl;
    }
}
