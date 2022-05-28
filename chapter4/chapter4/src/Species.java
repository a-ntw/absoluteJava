
/** 220524
 * Absolute Java
 * Chapter4
 * 9. Define a class whose objects are records on animal species. The class
 * should have instance variables for the species name, population, and growth
 * rate. The growth rate is a percentage that can be positive or negative and
 * can exceed 100%. Include a suitable collection of constructors, mutator
 * methods, and accessor methods. Include a toString method and an equals
 * method. Include a boolean valued method named endangered that returns true
 * when the growth rate is negative and returns false otherwise. Write a test
 * program (or programs) that tests each method in your class definition.
 */
import java.text.DecimalFormat;

public class Species {

    private String name;
    private int population;
    private double rate; // in ratio
    DecimalFormat percent = new DecimalFormat("0.00%"); // auto convert to %

    // Constructors
    public Species(String name, int pop, double rate) {
        this.name = name;
        this.population = pop;
        this.rate = rate;
    }

    public Species(String name, int pop, int rate) {
        this.name = name;
        this.population = pop;
        this.rate = (double) rate / 100;
    }

    public Species(String initialName) {
        this.name = initialName;
        this.population = 0;
        this.rate = 0;
    }

    public Species(String name, int pop) {
        this.name = name;
        this.population = pop;
        this.rate = 0;
    }

    public Species() {
        name = "No species name yet.";
        population = 0;
        rate = 0;
    }

    // mutator methods
    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setRate(int rate) {
        this.rate = (double) rate / 100;
    }

    // accessor methods
    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public double getRate() {
        return rate;
    }

    // toString method
    @Override
    public String toString() {
        return name + ", " + population + " at " + percent.format(rate) + ".";
    }

    // boolean methods
    public boolean equal(Species other) {
        if (other == null) {
            return false;
        }
        return (name.equalsIgnoreCase(other.name)
                && (this.population == other.population)
                && (this.rate == other.rate));
    }

    public boolean endangered() {
        if (rate < 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Species a1, a2, a3;
        a1 = new Species();
        System.out.println(a1);
        a1.setName("Animal1");
        a1.setPopulation(100);
        a1.setRate(-0.9);
        System.out.println(a1);
        a2 = new Species("Animal2", 1000, -0.01);
        System.out.println(a2);
        a3 = new Species("Animal3", 100, -90);
        System.out.println(a3.getName() + " " + a3.getPopulation() + " " + a3.getRate());

        if (a1.equal(a3)) {
            System.out.println(a1 + " equals " + a3);
        } else {
            System.out.println(a1 + " does not equals " + a3);
        }

        if (a2.endangered()) {
            System.out.println(a2 + " growth rate is negative");
        } else {
            System.out.println(a2 + " is not endangered.");
        }
    }
}
/* Sample dialogue
run:
No species name yet., 0 at 0.00%.
Animal1, 100 at -90.00%.
Animal2, 1000 at -1.00%.
Animal3 100 -0.9
Animal1, 100 at -90.00%. does not equals Animal3, 100 at -90.00%.
Animal2, 1000 at -1.00%. growth rate is negative
BUILD SUCCESSFUL (total time: 0 seconds)
 */
