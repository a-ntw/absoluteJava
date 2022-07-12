
/* 220712 Absolute Java  Chapter7 Programming Projects. Proj0701 */
/**
 * @see Person.java
 */
public class Teacher extends Person {

    private String subjectName;
    private double salary;

    public Teacher(String firstName, String lastName, String subjectName, double salary) {
        super(firstName, lastName);
        this.subjectName = subjectName;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println(super.getFirstName() + " " + super.getLastName()
                + "\nsubject: " + subjectName + ", salary: " + salary);
    }

}
