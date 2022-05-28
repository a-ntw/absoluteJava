/** 220408
 * Absolute Java
 * Chapter4
 * 8. Redefine the class Date in Display 4.13 so that the instance variable for 
 * the month is of type int instead of type String. None of the method headings 
 * should change in any way. In particular, no String type parameters should 
 * change to int type parameters. You must redefine the methods to make things 
 * work out. Any program that uses the Date class from Display 4.13 should be 
 * able to use your Date class without any changes in the program. In 
 * particular, the program in Display 4.14 should work the same whether the Date 
 * class is defined as in Display 4.13 or is defined as you do it for this 
 * project. Write a test program (or programs) that tests each method in your 
 * class definition.
 * 
 * Display 4.13  A Class with Constructors
 * 4.1 Class definitions
 *      The this Parameter
 *      Methods that Return a Boolean value
 *      The Methods equals and toString
 * 4.2 Information Hiding and Encapsulation
 *      Accessor and Mutator Methods
 * 4.3 Overloading
 * 4.4 Constructors
 */
import java.util.Scanner;

/**
 *
 * @author antw
 */
public class Date {

    // good programming practice to make all instance variables private.
    private int month; //Proj0408
    private int day;
    private int year; // a four digit number.

    // from the Date.java Display 4.13
    // Constructors with different signatures
    public Date() {
        month = 1; //Proj0408
        day = 1;
        year = 1000;
    }

    public Date(int monthInt, int day, int year) {
        setDate(monthInt, day, year);
    }

    public Date(String monthString, int day, int year) {
        setDate(monthString, day, year);
    }

    public Date(int year) {
        setDate(1, 1, year);
    }

    public Date(Date aDate) {
        if (aDate == null) // Not a real date.
        {
            System.out.println("Fatal Error.");
            System.exit(0);
        }

        month = aDate.month;
        day = aDate.day;
        year = aDate.year;
    }
    
    // the following from DateThirdTry.java, Display 4.4
    // from DateSixthTry.java Display 4.11
    // Overloading Mutator method, with different signatures
    public void setDate(int month, int day, int year) {
        if (dateOK(month, day, year)) {
            this.month =  month; //Proj0408
            this.day = day;
            this.year = year;
        } else {
            System.out.println("Fatal Error");
            System.exit(0);
        }
    }

    public void setDate(String monthString, int day, int year) {
        if (dateOK(monthString, day, year)) {
            this.month = monthInt(monthString); //Proj0408
            this.day = day;
            this.year = year;
        } else {
            System.out.println("Fatal Error");
            System.exit(0);
        }
    }

    public void setDate(int year) {
        setDate(1, 1, year);
    }

    // Overloading Methods
    private boolean dateOK(String monthString, int dayInt, int yearInt) {
        return (monthOK(monthString)
                && (dayInt >= 1) && (dayInt <= 31)
                && (yearInt >= 1000) && (yearInt <= 9999));
    }

    private boolean dateOK(int monthInt, int dayInt, int yearInt) {

        //assert((yearInt < 1000) || (yearInt > 999) );
        // Self-test exercise 19.
        if ((yearInt < 1000) || (yearInt > 9999)) {
            return false;
        }

        switch (monthInt) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                return (dayInt >= 1) && (dayInt <= 31);
            }
            case 2 -> {
                if (leapYear(yearInt)) {
                    return (dayInt >= 1) && (dayInt <= 29);
                } else {
                    return (dayInt >= 1) && (dayInt <= 28);
                }
            }
            case 4, 6, 9, 11 -> {
                return (dayInt >= 1) && (dayInt <= 30);
            }
            default -> {
                return false;
            }
        }
    }

    // Self-test exercise 19.
    private boolean leapYear(int yearInt) {
        return ((yearInt % 4 == 0) && (yearInt % 100 != 0))
                || (yearInt % 400 == 0);
    }

    private boolean monthOK(String month) {
        return (month.equalsIgnoreCase("January") || month.equalsIgnoreCase("Febuary")
            || month.equalsIgnoreCase("March") || month.equalsIgnoreCase("April")
            || month.equalsIgnoreCase("May") || month.equalsIgnoreCase("June")
            || month.equalsIgnoreCase("July") || month.equalsIgnoreCase("August")
            || month.equalsIgnoreCase("September") || month.equalsIgnoreCase("October")
            || month.equalsIgnoreCase("November") || month.equalsIgnoreCase("December"));
    }
    
    // a void method
    public void readInput() {
        boolean tryAgain = true;
        Scanner keyboard = new Scanner(System.in);
        while (tryAgain) {
            System.out.println("Enter month, day, and year.");
            System.out.println("Do not use commas or other punctuations.");
            String monthInput = keyboard.next();
            int dayInput = keyboard.nextInt();
            int yearInput = keyboard.nextInt();
            if (dateOK(monthInput, dayInput, yearInput)) {
                setDate(monthInput, dayInput, yearInput);
                tryAgain = false;
            } else {
                System.out.println("Illegal date. Reneter input.");
            }
        }
    }

    // from DateFifthTry Display 4.9
    // mutator method
    public void setMonth(int monthNumber) {
        if ((monthNumber <= 0) || (monthNumber > 12)) {
            System.out.println("Fatal Error");
            System.exit(0);
        } else {
            month = monthNumber; //Proj0408
        }
    }

    public void setDay(int day) {
        if ((day <= 0) || (day > 31)) {
            System.out.println("Fatal Error");
            System.exit(0);
        } else {
            this.day = day;
        }
    }

    public void setYear(int year) {
        if ((year < 1000) || (year > 9999)) {
            System.out.println("Fatal Error");
            System.exit(0);
        } else {
            this.year = year;
        }
    }

    // The following from DateFourthTry.java Display 4.7
    // Methods equals that return a boolean value
    // can directly access private isntance variables
    public boolean equals(Date otherDate) {
        if (otherDate == null) {
            return false;
        }
        return (( month == otherDate.month)  //Proj0408
                && (day == otherDate.day)
                && (year == otherDate.year));
    }

    // Methods that return a boolean value
    public boolean precedes(Date otherDate) {
        return ((year < otherDate.year)
                || (year == otherDate.year && month < otherDate.month ) //Proj0408
                || (year == otherDate.year && month == otherDate.month //Proj0408
                && day < otherDate.day));
    }

    // Method toString
    public String toString() {
        return (monthString(month) + " " + day + ", " + year);
    }

    private String monthString(int monthNumber) {
        switch (monthNumber) {
            case 1:
                return "January";
            case 2:
                return "Febuary";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                System.out.println("Fatal Error");
                System.exit(0);
                return "Error"; // Needed to keep the compiler happy
        }
    }

    // Proj0408
    private int monthInt(String monthString) {
        switch (monthString.toUpperCase()) {
            case "JANUARY": return 1;
            case "FEBUARY": return 2; 
            case "MARCH": return 3; 
            case "APRIL": return 4; 
            case "MAY": return 5; 
            case "JUNE": return 6; 
            case "JULY": return 7; 
            case "AUGUST": return 8; 
            case "SEPTEMBER": return 9; 
            case "OCTOBER": return 10; 
            case "NOVEMBER": return 11; 
            case "DECEMBER": return 12; 
            default:
                System.out.println("Fatal Error");
                System.exit(0);
                return 0; // Needed to keep the compiler happy
        }
    }
    
    // the following from DateSecondTry.java, Display 4.2
    /**
     * .
     * Precondition: All instance variables of the calling object have values.
     * Postcondition: The data in the calling object has been written to the
     * screen.
     */
    // superfluous, since has toString
//    public void writeOutput() {
//        System.out.println(month + " " + day + ", " + year);
//    }

    // Accessor Method
    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    } //Proj0408

    public static void main(String args[]) {

        assert (new Date().dateOK(2, 29, 1756)); // assert for debug

        // ConstructorDemo
        Date date6 = new Date("December", 16, 1770),
                date7 = new Date(1, 27, 1756),
                date8 = new Date(1882),
                date9 = new Date();
        System.out.println("Whose birthday is " + date6 + "?");
        System.out.println("Whose birthday is " + date7 + "?");
        System.out.println("Whose birthday is " + date8 + "?");
        System.out.println("The default date is " + date9 + "?");

        // from DateSixthTryOverloadingDemo
        Date date5 = new Date(),
                date4 = new Date(),
                date3 = new Date();

        date5.setDate(1, 2, 2008);
        date4.setDate("Febuary", 2, 2008);
        date3.setDate(2008);

        System.out.println(date5);
        System.out.println(date4);
        System.out.println(date3);

        // from DateFourthTryDemoEqualsAndToString
        date5.setDate(6, 17, 1882);
        date4.setDate(6, 17, 1882);

        // date1 are equivalent to date1.toString().
        if (date5.equals(date4)) {
            System.out.println(date5 + " equals " + date4);
        } else {
            System.out.println(date5 + " does not equal " + date4);
        }

        date5.setDate(7, 28, 1750);
        // date2 are equivalent ot date2.toString()
        if (date5.precedes(date4)) {
            System.out.println(date5 + " comes before " + date4);
        } else {
            System.out.println(date4 + " comes before or is equal to " + date5);
        }

        // from DateThirdTryDemo
        Date date2 = new Date();
        int year = 1882;
        date2.setDate(6, 17, year);
        //        date2.writeOutput();
        System.out.println(date2);

        // DemoOfDateSecondTry.java Display 4.3
        // The new Operator
        Date date1 = new Date();
        date1.readInput();
        int dayNumber = date1.getDay();
        System.out.println("That is the " + dayNumber
                + "th day of the nomth.");
    }
}

/* Sample Dialogue
antw@Mac-mini 2022AbsoluteJava % java -enableassertions chapter4/chapter4/src/Date.java
Whose birthday is December 16, 1770?
Whose birthday is January 27, 1756?
Whose birthday is January 1, 1882?
The default date is January 1, 1000?
January 2, 2008
Febuary 2, 2008
January 1, 2008
June 17, 1882 equals June 17, 1882
July 28, 1750 comes before June 17, 1882
June 17, 1882
Enter month, day, and year.
Do not use commas or other punctuations.
July 4 1776
That is the 4th day of the nomth.
*/