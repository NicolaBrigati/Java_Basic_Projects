package transportation;

public class Car extends Vehicle {

    // Constructor for Car
    public Car(String brand, int year) {
        super(brand, year);
        this.type = "Car";
        this.gasConsumedPerHour = 10;
        this.maxGasAmountInTank = 200;
    }

    // Override refuel method for Car
    @Override
    public void refuel(int amountOfGas) {
        if (gasRemained + amountOfGas <= maxGasAmountInTank) {
            gasRemained += amountOfGas;
        } else {
            gasRemained = maxGasAmountInTank;
        }
    }

    // Override run method for Car
    @Override
    public void run(int hours) {
        int gasNeeded = hours * gasConsumedPerHour;
        if (gasRemained >= gasNeeded) {
            gasRemained -= gasNeeded;
            totalGasConsumed += gasNeeded;
        } else {
            totalGasConsumed += gasRemained;
            gasRemained = 0;
        }
    }
}
