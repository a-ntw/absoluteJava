
/** 220408
 * Absolute Java
 * Chapter4
 * 10. Your vet’s office is using the Pet class defined in Display 4.15 and
 * would like to include a way to calculate the dosage amount for drugs that are
 * commonly administered for dogs and cats. Make the following modifications to
 * the class:
 *  • Add an instance variable that indicates if the type of the pet is a dog or
 * a cat.
 *  • Modify the constructor and the set method to include the type of pet (
 * i.e., dog or cat).
 *  • Add a method named acepromazine( ) that returns as a double the dosage in
 * ml for the sedative acepromazine.
 *  • Add a method named carprofen( ) that returns as a double the dosage in ml
 * for the pain killer carprofen.
 * The dosage calculation is
 *  Dosage(ml) = Weight / 2.2   X   mg per kg / mg per ml
 * Weight is in pounds.
 *  • For acepromazine, use mg per ml = 10, and mg per kg = 0.03 for dogs and
 * 0.002 for cats.
 *   • For carprofen, use mg per ml = 12, and mg per kg = 0.5 for dogs and 0.25
 * for cats.
 * Modify the main method in Display 4.16 to include tests of the new methods.
 *
 * Display 4.15  A Class for basic pet records: name, age, and weight
 *
 * An Alternative Way to Initialize Instance Variables
 */
import java.util.Scanner;

public class Pet {

    private String name;
    private int age; // in years
    private double weight;  // in pounds
    private String type; // dog or cat. Proj0410 

    public String toString() {
        return "Name: " + name + " Age: " + age + " years"
                + ". Weight: " + weight + " pounds. Type: " + type;
    }

    public Pet(String initialName, int initialAge, double initialWeight,
            String initialtype) {
        this.name = initialName;
        if ((initialAge < 0) || (initialWeight < 0)) {
            System.out.println("Error: Negative age or weight.");
            System.exit(0);
        } else {
            age = initialAge;
            weight = initialWeight;
        }

        if (petTypeOK(initialtype)) {
            type = initialtype;
        }
    }

    // Constructors are only called when create am object.
    public void set(String newName, int newAge, double newWeight, String newType) {
        name = newName;
        if ((newAge < 0) || (newWeight < 0)) {
            System.out.println("Error: Negative age or weight.");
            System.exit(0);
        } else {
            age = newAge;
            weight = newWeight;
        }
        if (petTypeOK(newType)) {
            type = newType;
        }
    }

    // Constructors normally set all instance variables, even if there is not a 
    // full set of parameters.
    public Pet(String initialName) {
        name = initialName;
        age = 0;
        weight = 0;
        type = "either dog or cat";
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet(int initialAge) {
        name = "No name yet.";
        weight = 0;
        if (initialAge < 0) {
            System.out.println("Error: Negative age or weight.");
            System.exit(0);
        } else {
            age = initialAge;
        }
        type = "either dog or cat";
    }

    public void setAge(int newAge) {
        if (newAge < 0) {
            System.out.println("Error: Negative age or weight.");
            System.exit(0);
        } else {
            age = newAge;
        }
    }

    public Pet(double initialWeight) {
        name = "No name yet.";
        age = 0;
        if (initialWeight < 0) {
            System.out.println("Error: Negative age or weight.");
            System.exit(0);
        } else {
            weight = initialWeight;
        }
        type = "either dog or cat";
    }

    public void setWeight(double newWeight) {
        if (newWeight < 0) {
            System.out.println("Error: Negative age or weight.");
            System.exit(0);
        } else {
            weight = newWeight;
        }
    }

    public void setType(String type) {
        if (petTypeOK(type)) {
            this.type = type;
        }
    }

    public Pet() {
        name = "No name yet.";
        age = 0;
        weight = 0;
        type = "either dog or cat";
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    private boolean petTypeOK(String t) {
        if (t.equalsIgnoreCase("dog") || t.equalsIgnoreCase("cat")) {
            return true;
        } else {
            System.out.println("Error: either dog or cat.");
            System.exit(0);
            return false;
        }
    }

    public double acepromazine() {
        int mgPerMl = 10;
        double mgPerKg = 0, dosageMl;

        if (type.equalsIgnoreCase("dog")) {
            mgPerKg = 0.03;
        } else if (type.equalsIgnoreCase("cat")) {
            mgPerKg = 0.002;
        }

        dosageMl = this.weight / 2.2 * mgPerKg / mgPerMl;
        return dosageMl;
    }

    public double carprofen() {
        int mgPerMl = 12;
        double mgPerKg = 0, dosageMl;

        if (type.equalsIgnoreCase("dog")) {
            mgPerKg = 0.5;
        } else if (type.equalsIgnoreCase("cat")) {
            mgPerKg = 0.25;
        }

        dosageMl = this.weight / 2.2 * mgPerKg / mgPerMl;
        return dosageMl;
    }

    public static void main(String args[]) {

        Pet usersPet = new Pet("Jane Dow");
        System.out.println("My records on your pet are incomplete.");
        System.out.println("Here is what they currently say:");
        System.out.println(usersPet);

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the pet's name:");
        String name = keyboard.nextLine();
        System.out.println("Please enter the pet's age:");
        int age = keyboard.nextInt();
        System.out.println("Please enter the pet's weight:");
        double weight = keyboard.nextDouble();
        System.out.println("Please enter the pet's type:");
        keyboard.nextLine();
        String type = keyboard.nextLine();
        usersPet.set(name, age, weight, type);
        System.out.println("My records now say:");
        System.out.println(usersPet);
        System.out.printf("Dosage on Acepromazine for %s will be %.2f ml.%n",
                usersPet.getName(), usersPet.acepromazine());
        System.out.printf("Dosage on Carprofen for %s will be %.2f ml.%n",
                usersPet.getName(), usersPet.carprofen());
    }
}

/* Sample Dialogue
antw@Mac-mini 2022AbsoluteJava % java chapter4/chapter4/src/Pet.java
My records on your pet are incomplete.
Here is what they currently say:
Name: Jane Dow Age: 0 years. Weight: 0.0 pounds. Type: either dog or cat
Please enter the pet's name:
Fang Junior
Please enter the pet's age:
5
Please enter the pet's weight:
87.5
Please enter the pet's type:
dog
My records now say:
Name: Fang Junior Age: 5 years. Weight: 87.5 pounds. Type: dog
Dosage on Acepromazine for Fang Junior will be 0.12 ml.
Dosage on Carprofen for Fang Junior will be 1.66 ml.
 */
