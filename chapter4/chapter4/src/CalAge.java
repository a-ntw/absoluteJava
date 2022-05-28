
/** 220413
 * Absolute Java
 * Chapter4
 * 2. Define a class called CalAge. This class is used to calculate age of a
 * person from her or his date of birth and the current date. Include a mutator
 * method that allows the user to enter her or his date of birth and set the
 * value for current date. Also include a method to return the age in years and
 * months (for example, 25.5 years) as a double value. Include an additional
 * method to check if the date of birth entered by the user is a valid one.
 * For example, 30 February 2008 is an invalid date. Embed your class in a test
 * program.
 */
import java.util.Scanner;

public class CalAge {

    private int day;
    private String month;
    private int year;

    private double getMonthFloat(String month) {
        switch (month) {
            case "January":
                return 1;
            case "Febuary":
                return 2;
            case "April":
                return 4;
            case "May":
                return 5;
            case "June":
                return 6;
            case "July":
                return 7;
            case "August":
                return 8;
            case "September":
                return 9;
            case "October":
                return 10;
            case "November":
                return 11;
            case "December":
                return 12;
            default:
                System.out.println("Fatal Error");
                System.exit(0);
                return 0; // Needed to keep the compiler happy
        }
    }

    private boolean monthOK(String month) {
        return (month.equals("January") || month.equals("Febuary")
                || month.equals("March") || month.equals("April")
                || month.equals("May") || month.equals("June")
                || month.equals("July") || month.equals("August")
                || month.equals("September") || month.equals("October")
                || month.equals("November") || month.equals("December"));
    }

    private boolean leapYear(int yearInt) {
        return ((yearInt % 4 == 0) && (yearInt % 100 != 0))
                || (yearInt % 400 == 0);
    }

    private boolean dateOK(int day, String month, int year) {

        if ((year < 1000) || (year > 9999)) {
            return false;
        }

        if (!monthOK(month)) {
            return false;
        }

        int monthInt = (int) getMonthFloat(month);
        switch (monthInt) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return (day >= 1) && (day <= 31);
            case 2:
                if (leapYear(year)) {
                    return (day >= 1) && (day <= 29);
                } else {
                    return (day >= 1) && (day <= 28);
                }
            case 4:
            case 6:
            case 9:
            case 11:
                return (day >= 1) && (day <= 30);
            default:
                return false;
        }
    }

    public void setDate(int day, String month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString() {
        return day + " " + month + " " + year;
    }

    public double thisDateMinus(CalAge otherDate) {
        double thisYearMonth = this.year + getMonthFloat(this.month) / 12;
        double OtherYearMonth = otherDate.year + getMonthFloat(otherDate.month) / 12;

        return thisYearMonth - OtherYearMonth;
    }

    public void readInput() {
        boolean tryAgain = true;
        Scanner keyboard = new Scanner(System.in);
        while (tryAgain) {
            System.out.println("Enter day, month, and year.");
            System.out.println("Do not use commas or other punctuations.");

            int dayInt = keyboard.nextInt();
            String monthString = keyboard.next();
            int yearInt = keyboard.nextInt();

            if (dateOK(dayInt, monthString, yearInt)) {
                setDate(dayInt, monthString, yearInt);
                tryAgain = false;
            } else {
                System.out.println("Illegal date. Reneter input.");
            }
        }
    }

    public static void main(String args[]) {

        CalAge currentDate = new CalAge();
        currentDate.setDate(16, "April", 2022);
        System.out.println("currentDate: " + currentDate);
        System.out.println("Set new current date, today date: ");
        currentDate.readInput();

        System.out.println("Enter your Birth date: ");
        CalAge birthDate = new CalAge();
        birthDate.readInput();

        System.out.println("birthDate  : " + birthDate);
        System.out.println("currentDate: " + currentDate);
        System.out.printf("The age is %.1f years old. %n",
                currentDate.thisDateMinus(birthDate));
    }
}

/* Sample Dialogue
antw@Mac-mini chapter4 % java Proj0402_CalAge.java
currentDate: 16 April 2022
Set new current date, today date: 
Enter day, month, and year.
Do not use commas or other punctuations.
16 April 2022
Enter your Birth date: 
Enter day, month, and year.
Do not use commas or other punctuations.
30 Feburary 2008
Illegal date. Reneter input.
Enter day, month, and year.
Do not use commas or other punctuations.
29 Febuary 2008
birthDate  : 29 Febuary 2008
currentDate: 16 April 2022
The age is 14.2 years old. 
 */
