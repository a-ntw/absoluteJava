
/* 220712 Absolute Java  Chapter7 Programming Projects. Proj0701 */
/**
 * @see Person.java
 */
public class Student extends Person {

    private int studentId;
    private String course;
    private String teacherName;

    public Student(String firstName, String lastName, int studentId,
            String course, String teacherName) {
        //super(); // optional
        super.setFirstName(firstName);
        super.setLastName(lastName);
        this.studentId = studentId;
        this.course = course;
        this.teacherName = teacherName;
    }

    public void displayDetails() {
        System.out.println(super.getFirstName() + " " + super.getLastName()
                + "\nid: " + studentId + ", course: " + course
                + ", teacher: " + teacherName);
    }

}
