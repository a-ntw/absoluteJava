
/* 220718 Absolute Java  Chapter7 Programming Projects. Proj0708 */
/**
 * Programming Project 4.10 required adding an instance variable to the {@code Pet}
 * class defined in Display 4.15 to indicate if the pet is a dog or cat. A
 * better organisation is to define {@code Pet} as a superclass of the
 * {@code Dog} and {@code Cat} classes. This organisation eliminates the need
 * for an instance variable to indicate the type of the pet. Do or redo
 * Programming Project 4.10 with inheritance. The {@code acepromazine()} and
 * {@code carprofen()} methods should be defined in the {@code Pet} class to
 * simply return 0. Over-ride both methods in the {@code Dog} and {@code Cat}
 * classes to calculate the correct dosage. Write a main method with appropriate
 * tests to exercise the changes.
 *
 * @see /chapter4/chapter4/src/Pet.java
 * @see Dog.java
 * @see Cat.java
 */
import java.util.Scanner;

public class Pet {

    private String name;
    private int age; // in years
    private double weight;  // in pounds

    public Pet() {
        name = "No name yet.";
        age = 0;
        weight = 0;
    }

    public Pet(String initialName, int initialAge, double initialWeight) {
        this.name = initialName;
        if ((initialAge < 0) || (initialWeight < 0)) {
            System.out.println("Error: Negative age or weight.");
            System.exit(0);
        } else {
            age = initialAge;
            weight = initialWeight;
        }
    }

    public Pet(String initialName) {
        name = initialName;
        age = 0;
        weight = 0;
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
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int newAge) {
        if (newAge < 0) {
            System.out.println("Error: Negative age or weight.");
            System.exit(0);
        } else {
            age = newAge;
        }
    }

    public void setWeight(double newWeight) {
        if (newWeight < 0) {
            System.out.println("Error: Negative age or weight.");
            System.exit(0);
        } else {
            weight = newWeight;
        }
    }

    public void set(String newName, int newAge, double newWeight) {
        name = newName;
        if ((newAge < 0) || (newWeight < 0)) {
            System.out.println("Error: Negative age or weight.");
            System.exit(0);
        } else {
            age = newAge;
            weight = newWeight;
        }
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

    public boolean petTypeOK(String t) {
        if (t.equalsIgnoreCase("dog") || t.equalsIgnoreCase("cat")) {
            return true;
        } else {
            System.out.println("Error: either dog or cat.");
            System.exit(0);
            return false;
        }
    }

    public String toString() {
        return "Name: " + name + " Age: " + age + " years"
                + ". Weight: " + weight + " pounds.";
    }

    public double acepromazine() {
        int mgPerMl = 10;
        double mgPerKg = 0, dosageMl = 0;
        return dosageMl;
    }

    public double carprofen() {
        int mgPerMl = 12;
        double mgPerKg = 0, dosageMl = 0;
        return dosageMl;
    }

    public static void displayDosage(Pet pet) {
        if (pet.petTypeOK(pet.getClass().getName())) { // **** check class name ***
            System.out.printf("Dosage on Acepromazine for %s will be %.3f ml.%n",
                    pet.name, pet.acepromazine());
            System.out.printf("Dosage on Carprofen for %s will be %.2f ml.%n",
                    pet.name, pet.carprofen());
        }
    }

    public static void main(String[] args) {
        Pet usersPet = new Pet("Jane Dow");
        System.out.println("My records on your pet are incomplete.");
        System.out.println("Here is what they currently say:");
        System.out.println(usersPet);

        //usersPet = new Dog("Fang Junior", 5, 87.5); /*
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the pet's name:");
        String name = keyboard.nextLine();
        System.out.println("Please enter the pet's age:");
        int age = keyboard.nextInt();
        System.out.println("Please enter the pet's weight:");
        double weight = keyboard.nextDouble();
        System.out.println("Please enter the pet's type 'dog'/'cat': ");
        keyboard.nextLine();
        String type = keyboard.nextLine();
        if (usersPet.petTypeOK(type)) {
            if (type.equalsIgnoreCase("dog")) {
                Dog dog = new Dog();
                dog.setName(name);
                dog.setAge(age);
                dog.setWeight(weight);
                usersPet = dog; //             **** change super to derived ****
            } else if (type.equalsIgnoreCase("cat")) {
                Cat cat = new Cat(name, age, weight);
                usersPet = cat;
            }
        }
        // */

        System.out.println("My records now say:");
        System.out.println(usersPet);
        Pet.displayDosage(usersPet);

        Cat meow = new Cat("Meow", 2, 3.5);
        System.out.println(meow.getName() + " is " + meow.getAge() + "yrs old at "
                + meow.getWeight() + " pounds.");
        Pet.displayDosage(meow);
    }
}

/* Sample dialogue
run:
My records on your pet are incomplete.
Here is what they currently say:
Name: Jane Dow Age: 0 years. Weight: 0.0 pounds.
Please enter the pet's name:
Fang Junior
Please enter the pet's age:
5
Please enter the pet's weight:
87.5
Please enter the pet's type 'dog'/'cat': 
dog
My records now say:
Name: Fang Junior Age: 5 years. Weight: 87.5 pounds.
Dosage on Acepromazine for Fang Junior will be 0.119 ml.
Dosage on Carprofen for Fang Junior will be 1.66 ml.
Meow is 2yrs old at 3.5 pounds.
Dosage on Acepromazine for Meow will be 0.000 ml.
Dosage on Carprofen for Meow will be 0.03 ml.
BUILD SUCCESSFUL (total time: 11 seconds)
 */
