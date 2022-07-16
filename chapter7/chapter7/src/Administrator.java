
/* 220715 Absolute Java  Chapter7 Programming Projects. Proj0704 */
import java.util.Scanner;

/**
 * Define a class called {@code Administrator}, which is a derived class of the
 * class {@code SalariedEmployee} in Display 7.5. You are to supply the
 * following additional instance variables and methods:
 *
 * <li>An instance variable of type {@code String} that contains the
 * administrator’s title (such as"Director"or"Vice President").
 * <li>An instance variable of type {@code String} that contains the
 * administrator’s area of responsibility (such as "Production", "Accounting",
 * or "Personnel").
 * <li>An instance variable of type {@code String} that contains the name of
 * this administrator’s immediate supervisor.
 * <li>Suitable constructors, and suitable accessor and mutator methods.
 * <li>A method for reading in an administrator’s data from the keyboard.
 *
 * Override the definitions for the methods {@code equals} and {@code toString}
 * so they are app- ropriate to the class {@code Administrator}.
 *
 * Also, write a suitable test program.
 *
 * @see SalariedEmployee.java
 */
public class Administrator extends SalariedEmployee {

    private String title; // such as 'Director', 'Vice President'
    private String responsible; // such as "Production", "Accounting", or "Personnel"
    private String supervisor; // name of immediate supervisor

    public Administrator(String theName, Date theDate, double theSalary,
            String title, String responsible, String supervisor) {
        super(theName, theDate, theSalary);
        this.title = title;
        this.responsible = responsible;
        this.supervisor = supervisor;
    }

    public Administrator(String theName, Date theDate, double theSalary) {
        super(theName, theDate, theSalary);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getTitle() {
        return title;
    }

    public String getResponsible() {
        return responsible;
    }

    public String getSupervisor() {
        return supervisor;
    }

    /**
     * Reading in an administrator’s data from the keyboard.
     */
    public static void keyboard(Administrator admin) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Choose\n 1. Name\n"
                + " 2. Salary & Hire Date\n"
                + " 3. Title & Responsibility\n"
                + " 4. Supervisor\n" + " 5. Quit");

        boolean toContinue = true;
        String s;
        while (toContinue) {
            System.out.print("Choice: ");
            if (!keyboard.hasNextInt()) {
                System.out.println("Error. pick from 1 to 7  only");
                System.exit(0);
            }
            int pick = keyboard.nextInt();
            switch (pick) {
                case 1:
                    s = "Name: " + admin.getName();
                    break;
                case 2:
                    s = "Salary: $" + admin.getSalary()
                            + " per year; Hire Date: " + admin.getHireDate();
                    break;
                case 3:
                    s = "Title: " + admin.title
                            + "; Responsibility: " + admin.responsible;
                    break;
                case 4:
                    s = "Supervisor: " + admin.supervisor;
                    break;
                default:
                    s = "";
                    toContinue = false;
            }
            System.out.println(s);
        }
    }

    @Override
    public boolean equals(Object otherObj) {
        if (otherObj == null) {
            return false;
        } else if (this.getClass() != otherObj.getClass()) {
            return false;
        } else {
            Administrator other = (Administrator) otherObj;
            return (super.equals(other)
                    && this.title == other.title
                    && this.responsible == other.responsible
                    && this.supervisor == other.supervisor);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\ntitle: " + title + "; responsible: "
                + responsible + "; supervisor: " + supervisor;
    }

    public static void main(String[] args) {
        Administrator joe, josephine;
        josephine = new Administrator("Josephine", new Date("January",
                1, 2015), 10000, "Director", "Personnel", "Sam");
        joe = new Administrator("Josephine",
                new Date("January", 1, 2015), 10000);
        joe.setTitle("Director");
        joe.setResponsible("Personnel");
        joe.setSupervisor("Sam");

        if (joe.equals(josephine)) {
            System.out.println("joe is equal to josephine!");
        }

        System.out.println(joe + "\n");

        josephine.setSalary(20000);
        Administrator.showEmployee(josephine);
        Administrator.keyboard(josephine);
    }
}

/* Sample dialogue
run:
joe is equal to josephine!
Josephine January 1, 2015
$10000.0 per year
title: Director; responsible: Personnel; supervisor: Sam

Josephine
January 1, 2015
Choose
 1. Name
 2. Salary & Hire Date
 3. Title & Responsibility
 4. Supervisor
 5. Quit
Choice: 1
Name: Josephine
Choice: 2
Salary: $20000.0 per year; Hire Date: January 1, 2015
Choice: 3
Title: Director; Responsibility: Personnel
Choice: 4
Supervisor: Sam
Choice: 5

BUILD SUCCESSFUL (total time: 7 seconds)
 */
