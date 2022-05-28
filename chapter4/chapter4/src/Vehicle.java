
/** 220519
 * Absolute Java
 * Chapter4
 * 3. Define a class called Vehicle that will be used to check the amount of
 * fuel left in a vehicle after traveling a certain distance. The class should
 * have the instance variable tankSize to store the initial size of the tank and
 * efficiency to store initial efficiency of the vehicle.
 * Set to zero the variable fuelInTank that is used to store the initial amount
 * of fuel in a tank. Include a mutator method that returns iniTankSize,
 * initEfficiency and fuelInTank.
 * Include an accessor method addPetrol that calculates how much fuel can be
 * filled depending on the fuel existing in the tank and the tank’s capacity.
 * Also, include a method driveTo that returns what distance can be traveled
 * with the available fuel and provided efficiency. Use your class with a test
 * program. You should decide which variables should be public, if any. Also,
 * define if any other method(s) are needed.
 */
public class Vehicle {

    private int tankSize;
    private int efficiency;
    private int fuelInTank = 0;

    public void init(int iniTankSize, int initEfficiency, int fuelInTank) {

        if (okInit(iniTankSize, initEfficiency, fuelInTank)) {
            this.tankSize = iniTankSize;
            this.efficiency = initEfficiency;
            this.fuelInTank = fuelInTank;
        } else {
            System.out.println("Fatal Error");
            System.exit(0);
        }
    }

    private boolean okInit(int iniTankSize, int initEfficiency, int fuel) {
        if ((initEfficiency > 100) || (initEfficiency < 0)) {
            return false;
        } else if (fuel > iniTankSize) {
            return false;
        }

        return true;
    }

    public void addPetrol() {
        System.out.println("Petrol to be fill: " + (tankSize - fuelInTank));
    }

    public void driveTo() {
        System.out.printf("The vehicle can be travel with %d fuel at %d efficiency.%n",
                this.fuelInTank, this.efficiency);
    }

    public static void main(String args[]) {

        Vehicle fuel = new Vehicle();
        fuel.init(100, 100, 10);
        fuel.addPetrol();
        fuel.init(100, 70, 80);
        fuel.addPetrol();
        fuel.driveTo();
    }
}

/* Sample dialogue
Petrol to be fill: 90
Petrol to be fill: 20
The vehicle can be travel with 80 fuel at 70 efficiency.
 */
