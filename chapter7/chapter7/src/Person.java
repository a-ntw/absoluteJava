
/* 220712 Absolute Java  Chapter7 Programming Projects. Proj0701 */
/**
 * Define a class named {@code Person} that contains two instance variables of
 * type {@code String} that stores the first name and last name of a person and
 * appropriate accessor and mutator methods. Also create a method named
 * {@code displayDetails} that outputs the details of a person. Next, define a
 * class named {@code Student} that is derived from {@code Person}, the
 * constructor for which should receive first name and last name from the class
 * {@code Student} and also assigns values to student id, course, and teacher
 * name. This class should redefine the {@code displayDetails} method to person
 * details as well as details of a student. Include appropriate constructor(s).
 * Define a class named {@code Teacher} that is derived from {@code Person}.
 * This class should contain instance variables for the subject name and salary.
 * Include appropriate constructor(s). Finally, redefine the
 * {@code displayDetails} method to include all teacher information in the
 * printout. Create a main method that creates at least two student objects and
 * two teacher objects with different values and calls {@code displayDetails}
 * for each.
 *
 * @see Student.java
 * @see Teacher.java
 */
public class Person {

    private String firstName;
    private String lastName;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void displayDetails() {
        System.out.println(firstName + " " + lastName);
    }

//public class main {
    public static void main(String[] args) {
        Person anne = new Person("Anne", "");
        anne.displayDetails();

        Student john = new Student("John", "Ang", 19, "Information", "Tan");
        john.displayDetails();
        Student wendy = new Student("Wendy", "Tan", 39, "UI Design", "Ong");
        wendy.displayDetails();
        Teacher tan = new Teacher("Mary", "Tan", "Internet", 3000);
        tan.displayDetails();
        Teacher ong = new Teacher("June", "Ong", "Programming", 2000);
        ong.displayDetails();
    }
}

/*
run:
Anne 
John Ang
id: 19, course: Information, teacher: Tan
Wendy Tan
id: 39, course: UI Design, teacher: Ong
Mary Tan
subject: Internet, salary: 3000.0
June Ong
subject: Programming, salary: 2000.0
BUILD SUCCESSFUL (total time: 0 seconds)
 */
