
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
    private double efficiency;
    private int fuelInTank = 0;

    public void init(int iniTankSize, double initEfficiency, int fuelInTank) {

        if (okInit(iniTankSize, initEfficiency, fuelInTank)) {
            this.tankSize = iniTankSize;
            this.efficiency = initEfficiency;
            this.fuelInTank = fuelInTank;
        } else {
            System.out.println("Fatal Error");
            System.exit(0);
        }
    }

    private boolean okInit(int iniTankSize, double initEfficiency, int fuel) {
        if ((initEfficiency > 1) || (initEfficiency < 0)) {
            return false;
        } else if (fuel > iniTankSize) {
            return false;
        }

        return true;
    }

    public void addPetrol() {
        System.out.println("Petrol to be fill: " + (tankSize - fuelInTank));
    }

    public void driveTo(int rate) {
        int distance = (int) (rate * fuelInTank * efficiency);

        System.out.printf("The vehicle can be travel %d with %d fuel at %.2f "
                + "efficiency.%n", distance, this.fuelInTank, this.efficiency);
    }

    public static void main(String args[]) {

        Vehicle veh = new Vehicle();
        veh.init(100, 1, 10);
        veh.addPetrol();
        veh.init(100, 0.70, 80);
        veh.addPetrol();

        // assume rate at 15km/petrol
        int rate = 15;
        veh.driveTo(rate); 
    }
}

/* Sample dialogue
Petrol to be fill: 90
Petrol to be fill: 20
The vehicle can be travel with 80 fuel at 70 efficiency.
 */
