
/* 220619 Absolute Java  Chapter6 Programming Projects.  Display 6.9 */
/* The class Date is defined in Display 4.11, but you do not need to know the 
 * details of the definition to understand the point of this example.*/
/**
 * Demonstrates the correct way to define an accessor method to a private
 * array of class objects.
 */
public class ToyExample {

    private Date[] a;

    public ToyExample(int arraySize) {
        a = new Date[arraySize];
        for (int i = 0; i < arraySize; i++) {
            a[i] = new Date();
        }
    }

    /**
     * Copy constructor for ToyExample
     */
    public ToyExample(ToyExample object) {
        int lengthOfArrays = object.a.length;
        this.a = new Date[lengthOfArrays];
        for (int i = 0; i < lengthOfArrays; i++) {
            //Copy constructor for Date
            this.a[i] = new Date(object.a[i]);
        }
    }

    // Accessor method
    public Date[] getDateArray() {
        Date[] temp = new Date[a.length];
        for (int i = 0; i < a.length; i++) {
            //Copy constructor for Date
            temp[i] = new Date(a[i]);
        }
        return temp;
    }
    /*<There presumably are other methods that are not shown,
Copy constructor for Date but they are irrelevant to the point at hand.> */
}
