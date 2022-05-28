
/** 220520
 * Absolute Java
 * Chapter4 Programming Projects
 * 7. Write a Temperature class that has two instance variables: a temperature
 * value (a floating-point number) and a character for the scale, either C for
 * Celsius or F for Fahrenheit. The class should have four constructor methods:
 * one for each instance variable (assume zero degrees if no value is specified
 * and Celsius if no scale is specified), one with two parameters for the two
 * instance variables, and a no-argument constructor (set to zero degrees
 * Celsius). Include the following:
 * (1) two accessor methods to return the temperature — one to return the
 * degrees Celsius, the other to return the degrees Fahrenheit — use the
 * following formulas to write the two methods, and round to the nearest tenth
 * of a degree:
 *      DegreesC = 5(degreesF - 32)/9
 *      DegreesF = (9(degreesC)/5) + 32;
 * (2) three mutator methods: one to set the value, one to set the scale (F or
 * C), and one to set both; (3) three comparison methods: an equals method to
 * test whether two temperatures are equal, one method to test whether one
 * temperature is greater than another, and one method to test whether one
 * temperature is less than another (note that a Celsius temperature can be
 * equal to a Fahrenheit temperature as indicated by the above formulas); and
 * (4) a suitable toString method. Then write a driver program (or programs)
 * that tests all the methods. Be sure to use each of the constructors, to
 * include at least one true and one false case for each of the comparison
 * methods, and to test at least the following temperature equalities:
 * 0.0 degrees C = 32.0 degrees F, –40.0 degrees C = –40.0 degrees F, and
 * 100.0 degrees C = 212.0 degrees F.
 */
public class Temperature {

    private float value;
    private char scale;

    public Temperature(float value) {
        setValue(value);
        scale = 'C';
    }

    public Temperature(char scale) {
        value = 0;
        setScale(scale);
    }

    public Temperature(float value, char scale) {
        this.setBoth(value, scale);
    }

    public Temperature() {
        value = 0;
        scale = 'C';
    }

    public Temperature toCelsius() {
        Temperature c = new Temperature('C');
        if (this.scale == 'F') {
            c.value = 5 * (this.value - 32) / 9;
        } else {
            return this;
        }
        return c;
    }

    public Temperature toFahrenfeit() {
        Temperature f = new Temperature('F');
        if (this.scale == 'C') {
            f.value = 9 * (this.value / 5) + 32;
        } else {
            return this;
        }
        return f;
    }

    private void setValue(float value) {
        this.value = value;
    }

    private void setScale(char scale) {
        scaleOk(scale);
        scale = Character.toUpperCase(scale);
        this.scale = scale;
    }

    private void setBoth(float value, char scale) {
        scaleOk(scale);
        scale = Character.toUpperCase(scale);
        this.value = value;
        this.scale = scale;
    }

    private boolean scaleOk(char scale) {
        scale = Character.toUpperCase(scale);
        if (scale == 'C' || scale == 'F') {
            return true;
        } else {
            System.out.println("Fatal Error");
            System.exit(0);
            return false;
        }
    }

    public boolean equal(Temperature otherTemp) {
        if (otherTemp == null) {
            return false;
        }
        Temperature t = this.toCelsius();
        Temperature o = otherTemp.toCelsius();
        if ((t.value == o.value) && (t.scale == o.scale)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean greaterThan(Temperature low) {
        if (low == null) {
            return false;
        }
        Temperature t = this.toCelsius();
        Temperature o = low.toCelsius();
        if (t.value > o.value) {
            return true;
        } else {
            return false;
        }
    }

    public boolean lessThan(Temperature high) {
        if (high == null) {
            return false;
        }
        Temperature t = this.toCelsius();
        Temperature o = high.toCelsius();
        if (t.value < o.value) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return value + " degrees " + scale;
    }

    public static void main(String args[]) {

        Temperature a, b, c, d, e, f, g, h;

        System.out.println(a = new Temperature());
        System.out.println(b = new Temperature('f'));
        System.out.println(c = new Temperature(100));
        System.out.println(d = new Temperature(-40, 'f'));
        System.out.println(e = new Temperature(212, 'f'));
        System.out.println(f = d.toCelsius());
        System.out.println((g = a.toFahrenfeit()) + "\n");

        System.out.println(b.toCelsius());
        System.out.println(d + " < " + a + " : " + d.lessThan(a));
        System.out.println(e + " > " + c + " : " + e.greaterThan(c) + "\n");

        System.out.println(a + " = " + g + " : " + a.equal(g));
        System.out.println(d + " = " + f + " : " + d.equal(f));
        System.out.println(c + " = " + e + " : " + c.equal(e));
        System.out.println(a + " = " + (h = null) + " : " + a.equal(h));
    }
}

/* Sample dialogue
run:
0.0 degrees C
0.0 degrees F
100.0 degrees C
-40.0 degrees F
212.0 degrees F
-40.0 degrees C
32.0 degrees F

-17.777779 degrees C
-40.0 degrees F < 0.0 degrees C : true
212.0 degrees F > 100.0 degrees C : false

0.0 degrees C = 32.0 degrees F : true
-40.0 degrees F = -40.0 degrees C : true
100.0 degrees C = 212.0 degrees F : true
0.0 degrees C = null : false
BUILD SUCCESSFUL (total time: 0 seconds)
 */
