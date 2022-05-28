
/** 220414
 * Absolute Java
 * Chapter4
 * 4. Define a class called Journal that could be used to store an entry for a
 * research paper that will be published. The class should have instance
 * variables to store the author’s name, title of the paper, and the date of
 * submission using the Date class from this chapter. Add a constructor to the
 * class that allows the user of the class to set all instance variables. Also
 * add a method, displayDetails, that outputs all the instance variables, and
 * another method called getSubmissionDetails that returns the title of the
 * paper, with the first letter of each word capitalized. Test your class from
 * the main method.
 */
public class Journal {

    private final String name;
    private String title;
    private final Date date;

    public Journal(String name, String title, Date date) {
        this.name = name;
        this.title = title;
        this.date = date;
    }

    public void displayDetails() {
        System.out.println("Author: " + name
                + "\nTitle : " + title
                + "\nDate  : " + date);
    }

    public String getSubmissionDetails(String title) {
        int stringLgth = title.length();
        String newString = title.substring(0, 1).toUpperCase();

        for (int i = 1; i < stringLgth; i++) {
            if (title.charAt(i - 1) == ' ') {
                newString += title.substring(i, i + 1).toUpperCase();
            } else {
                newString += title.charAt(i);
            }
        }

        return newString;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static void main(String args[]) {

        Journal j;
        j = new Journal("Elizabeth R. Kazakoff",
                "the effect of a classroom-based "
                //+ "intensive robotics and "
                + "programming workshop "
                //+ "on sequencing ability "
                + "in early childhood.",
                new Date("October", 18, 1770));

        j.setTitle(j.getSubmissionDetails(j.getTitle()));

        j.displayDetails();
    }
}

/* Sample dialogue
run:
Author: Elizabeth R. Kazakoff
Title : The Effect Of A Classroom-based Programming Workshop In Early Childhood.
Date  : October 18, 1770
BUILD SUCCESSFUL (total time: 0 seconds)
 */
