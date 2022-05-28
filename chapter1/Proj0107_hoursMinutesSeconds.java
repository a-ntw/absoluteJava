
/** 220501
 * Absolute Java
 * Chapter1 Programming Projects
 * 7. Write a program that outputs the number of hours, minutes, and seconds
 * that corresponds to 50,391 total seconds. The output should be 13 hours,
 * 59 minutes, and 51 seconds. Test your program with a different number of
 * total seconds to ensure that it works for other cases.
 */
public class Proj0107_hoursMinutesSeconds {

    public static void main(String args[]) {

        int totalSeconds, hours, minutes, seconds;

        totalSeconds = 50391;
        hours = totalSeconds / 3600;
        minutes = (totalSeconds % 3600) / 60;
        seconds = totalSeconds % 60;
        System.out.println(hours + " hours, " + minutes + " minutes "
                + seconds + " seconds");

        totalSeconds = 3670;
        hours = totalSeconds / 3600;
        minutes = (totalSeconds % 3600) / 60;
        seconds = totalSeconds % 60;
        System.out.println(hours + " hours, " + minutes + " minutes "
                + seconds + " seconds");
    }
}

/* Sample Dialogue
13 hours, 59 minutes 51 seconds
1 hours, 1 minutes 10 seconds
 */
