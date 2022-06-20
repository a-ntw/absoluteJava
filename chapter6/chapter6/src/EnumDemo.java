/* 220620 Absolute Java  Chapter6 Programming Projects. Display 6.13, 6.15, 6,16 */
import java.util.Scanner;

/**
 * Display 6,13 An Enumerated Type;
 * Display 6.15 The Method values;
 * Display 6.16 Enumerated Type in a switch Statement.
 */
public class EnumDemo {
    /* enum for Diaply 6.13 and 6.15 */
    enum WorkDay {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY};
    /* enum for Diaply 6.16 */
    enum Flavor {VANILLA, CHOCOLATE, STRAWBERRY};
    
    public static void main(String[] args) {

        /*  Display 6,13 An Enumerated Type  */
        WorkDay startDay = WorkDay.MONDAY;
        WorkDay endDay = WorkDay.FRIDAY;

        System.out.println("Work starts on " + startDay);   // Work starts on MONDAY
        System.out.println("Work ends on " + endDay);       // Work ends on FRIDAY

        
        /* Display 6.15 The Method values  */
        WorkDay[] day = WorkDay.values();

        Scanner keyboard = new Scanner(System.in);
        double hours = 0, sum = 0;

        for (int i = 0; i < day.length; i++) {
            System.out.println("Enter hours worked for " + day[i]);
            hours = keyboard.nextDouble();
            sum = sum + hours;
        }
        System.out.println("Total hours work = " + sum);

        
        /* Display 6.16 Enumerated Type in a switch Statement */
        Flavor favourite = null;
        //Scanner keyboard = new Scanner(System.in);
        
        System.out.println("What is your favourite flavor?");
        String answer = keyboard.next();
        answer = answer.toUpperCase();
        favourite = Flavor.valueOf(answer);

        switch (favourite) {
            case VANILLA:
                System.out.println("Classic");
                break;
            case CHOCOLATE:
                System.out.println("Rich");
                break;
            default:
                System.out.println("I bet you said STRAWBERRY.");
                break;
        }
    }
}
/* Sample dialogue
run:
Work starts on MONDAY
Work ends on FRIDAY
Enter hours worked for MONDAY
8
Enter hours worked for TUESDAY
8
Enter hours worked for WEDNESDAY
8
Enter hours worked for THURSDAY
8
Enter hours worked for FRIDAY
7.5
Total hours work = 39.5
What is your favourite flavor?
Vanilla
Classic
BUILD
*/