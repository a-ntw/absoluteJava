
/** 220609
 * Absolute Java
 * Chapter5 Programming Projects.
 * 9. Use `javadoc` to generate HTML documentation for the code in Display 5.19.
 * Use the `@author` and `@version` tag for the description of the entire class. Add a
 * comment for every public method or constructor using the `@param` and `@return`
 * tags when appropriate.
 */
/** . Display 5.19. Pg 337
 * Class for a person with a name and dates for birth and death.
 * Class invariant: A Person always has a date of birth, and if the Person
 * has a date of death, then the date of death is equal to or later than the
 * date of birth.
 */
/**
 *
 * @author antw
 * @version 01;
 */
// The class Date was defined in Display 4.11 and many of the details are repeated 
// in Display 5.20.
public class Person {

    private String name;
    private Date born;
    private Date died; //null indicates still alive.

    /**
     * Creating object for inputs the following parameters. birthDate and
     * deathDate are the consistent date of birth and death.
     *
     * @param initialName Name of the object Person
     * @param birthDate object Date
     * @param deathDate object Date
     */
    public Person(String initialName, Date birthDate, Date deathDate) {
        if (consistent(birthDate, deathDate)) {
            name = initialName;
            born = new Date(birthDate);
            if (deathDate == null) {
                died = null;
            } else {
                died = new Date(deathDate);
            }
        } else {
            System.out.println("Inconsistent dates.Aborting.");
            System.exit(0);
        }
    }

    /**
     * Copy constructor for object Person.
     *
     * @param original a Person object to copy from
     */
    public Person(Person original) {
        if (original == null) {
            System.out.println("Fatal error.");
            System.exit(0);
        }

        name = original.name;
        born = new Date(original.born);

        if (original.died == null) {
            died = null;
        } else {
            died = new Date(original.died);
        }
    }

    /**
     * Set the current object with the parameters to the calling object.
     *
     * @param newName Name of the object Person
     * @param birthDate object Date
     * @param deathDate object Date
     */
    public void set(String newName, Date birthDate, Date deathDate) {
        //Definition of this method is Self-Test Exercise 41.
        if (consistent(birthDate, deathDate)) {
            name = newName;
            born = new Date(birthDate);
            if (deathDate == null) {
                died = null;
            } else {
                died = new Date(deathDate);
            }
        } else {
            System.out.println("Inconsistent dates. Aborting.");
            System.exit(0);
        }
    }

    /**
     * Use on System Print to print of the calling object.
     *
     * @return String of name, born date and died date
     */
    public String toString() {
        String diedString;
        if (died == null) {
            diedString = ""; //Empty string 
        } else {
            //This is the toString method of the class Date.
            diedString = died.toString();
        }
        //This is equivalent to born.toString( ).
        return (name + ", " + born + "-" + diedString);
    }

    /**
     * Tests for equality of two objects of type Person. To be equal, the two
     * objects must have the same name, same birth date, and same death date.
     *
     * @param otherPerson The person being compared to the calling object.
     * @return Returns true if the calling object equals otherPerson.
     */
    public boolean equals(Person otherPerson) {
        if (otherPerson == null) {
            return false;
        } else {
            //This is the equals method for the class String.
            return (name.equals(otherPerson.name)
                    //This is the equals method for the class Date.
                    && born.equals(otherPerson.born)
                    && datesMatch(died, otherPerson.died));
        }
    }

    /**
     * To match, date1 and date2 either must be the same date or must both be
     * null.
     */
    private static boolean datesMatch(Date date1, Date date2) {
        if (date1 == null) {
            return (date2 == null);
        } else if (date2 == null) {    //&& date1 != null 
            return false;
        } else {                       //Both dates are not null. 
            return (date1.equals(date2));
        }
    }

    /**
     * Precondition: newDate is a consistent date of birth.
     *
     * Postcondition: Date of birth of the calling object is newDate.
     *
     * @param newDate add or change Date
     */
    public void setBirthDate(Date newDate) {
        if (consistent(newDate, died)) {
            born = new Date(newDate);
        } else {
            System.out.println("Inconsistent dates. Aborting.");
            System.exit(0);
        }
    }

    /**
     * Set died date to the calling object.
     *
     * Precondition: newDate is a consistent date of death.
     *
     * Postcondition: Date of death of the calling object is newDate.
     *
     * @param newDate add or change Date
     */
    public void setDeathDate(Date newDate) {
        if (!consistent(born, newDate)) {
            System.out.println("Inconsistent dates. Aborting.");
            System.exit(0);
        }
        if (newDate == null) {
            //The date of death can be null. However, there is no corresponding 
            //code in setBirthDate because the method consistent ensures that 
            //the date of birth is never null.
            died = null;
        } else {
            died = new Date(newDate);
        }
    }

    /**
     * Set name to the calling object
     *
     * @param newName add or change Name
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * Set the year of the birth Date.
     *
     * Precondition: The date of birth has been set, and changing the year part
     * of the date of birth will give a consistent date of birth.
     *
     * Postcondition: The year of birth is (changed to) newYear.
     *
     * @param newYear add or change Year of the Date born
     */
    public void setBirthYear(int newYear) {
        if (born == null) {       //Precondition is violated.
            System.out.println("Fatal Error. Aborting.");
            System.exit(0);
        }
        born.setYear(newYear);
        if (!consistent(born, died)) {
            System.out.println("Inconsistent dates. Aborting.");
            System.exit(0);
        }
    }

    /**
     * Set the year of the death Date.
     *
     * Precondition: The date of death has been set, and changing the year part
     * of the date of death will give a consistent date of death.
     *
     * Postcondition: The year of death is (changed to) newYear.
     *
     * @param newYear add or change Year of the Date died
     */
    public void setDeathYear(int newYear) {
        if (died == null) {           //Precondition is violated. 
            System.out.println("Fatal Error. Aborting.");
            System.exit(0);
        }
        died.setYear(newYear);
        if (!consistent(born, died)) {
            System.out.println("Inconsistent dates. Aborting.");
            System.exit(0);
        }
    }

    /**
     * call the name of the calling object.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * call the birth date of the calling object.
     *
     * @return the date of born date
     */
    public Date getBirthDate() {
        return new Date(born);
    }

    /**
     * call the death date of the calling object.
     *
     * @return the date of died date
     */
    public Date getDeathDate() {
        if (died == null) {
            return null;
        } else {
            return new Date(died);
        }
    }

    /**
     * To be consistent, birthDate must not be null. If there is no date of
     * death (deathDate == null), that is consistent with any birthDate.
     * Otherwise, the birthDate must come before or be equal to the deathDate.
     */
    private static boolean consistent(Date birthDate, Date deathDate) {
        if (birthDate == null) {
            return false;
        } else if (deathDate == null) {
            return true;
        } else {
            return (birthDate.precedes(deathDate)
                    || birthDate.equals(deathDate));
        }
    }

    public static void main(String[] args) {

        Person bach
                = new Person("Johann Sebastian Bach",
                        new Date("March", 21, 1685), new Date("July", 28, 1750));
        Person stravinsky = new Person("Igor Stravinsky",
                new Date("June", 17, 1882), new Date("April", 6, 1971));
        Person adams
                = new Person("John Adams",
                        new Date("February", 15, 1947), null);

        System.out.println("A Short List of Composers:");
        System.out.println(bach);
        System.out.println(stravinsky);
        System.out.println(adams);

        Person bachTwin = new Person(bach);
        System.out.println("Comparing bach and bachTwin:");
        if (bachTwin == bach) {
            System.out.println("Same reference for both.");
        } else {
            System.out.println("Distinct copies.");
        }
        if (bachTwin.equals(bach)) {
            System.out.println("Same data.");
        } else {
            System.out.println("Not same data.");
        }
    }
}

/* sample dialogue
run:
A Short List of Composers:
Johann Sebastian Bach, March 21, 1685-July 28, 1750
Igor Stravinsky, June 17, 1882-April 6, 1971
John Adams, February 15, 1947-
Comparing bach and bachTwin:
Distinct copies.
Same data.
BUILD SUCCESSFUL (total time: 0 seconds)
 */
/* creating Javadoc
antw@Mac-mini src % ls PersonJavaDoc    
Person.html		overview-tree.html
allclasses-index.html	package-search-index.js
allpackages-index.html	package-summary.html
element-list		package-tree.html
help-doc.html		resources
index-all.html		script-dir
index.html		script.js
jquery-ui.overrides.css	search.js
legal			stylesheet.css
member-search-index.js	tag-search-index.js
module-search-index.js	type-search-index.js
antw@Mac-mini src % pwd
/Users/antw/absoluteJ/chapter5/chapter5/src
antw@Mac-mini src % 
*/