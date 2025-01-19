package transportation;

public class Bike extends Vehicle {

    // Constructor for Bike
    public Bike(String brand, int year) {
        super(brand, year);
        this.type = "Bike";
        this.gasConsumedPerHour = 0;  // Bikes don't consume gas
        this.maxGasAmountInTank = 0;  // Bikes don't have a gas tank
    }

    // Override refuel method for Bike
    @Override
    public void refuel(int amountOfGas) {
        System.out.println("You don't need to refuel a bike.");
    }

    // Override run method for Bike
    @Override
    public void run(int hours) {
        System.out.println("Eco-friendly travel by bicycle!");
    }
}
