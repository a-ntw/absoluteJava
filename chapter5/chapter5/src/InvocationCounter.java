
/**
 * Display 5.5.
 * The static variable numberOfInvocations is used to keep track of how many
 * invocations have been made by all objects of the class.
 * The program counts all invocations of the methods defined.
 */
public class InvocationCounter {

    private static int numberOfInvocations = 0;

    public void demoMethod() {
        numberOfInvocations++;
        //In a real example, more code would go here.
    }

    public void outPutCount() {
        numberOfInvocations++;
        System.out.println("Number of invocations so far = "
                + numberOfInvocations);
    }

    public static int numberSoFar() {
        numberOfInvocations++;
        return numberOfInvocations;
    }

    public static void main(String[] args) {

        int i;
        InvocationCounter object1 = new InvocationCounter();
        for (i = 1; i <= 5; i++) {
            object1.demoMethod();
        }
        //Outputs 6 for five invocations of demoMethod and one invocation of outputCount .
        object1.outPutCount();

        InvocationCounter object2 = new InvocationCounter();
        for (i = 1; i <= 5; i++) {
            object2.demoMethod();
            object2.outPutCount();
        }

        System.out.println("Totalnumber of invocations = "
                + numberSoFar());

    }

}

/* Sample Dialogue
Number of invocations so far = 6
Number of invocations so far = 8
Number of invocations so far = 10
Number of invocations so far = 12
Number of invocations so far = 14
Number of invocations so far = 16
Totalnumber of invocations = 17
 */
