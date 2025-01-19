package transportation;

public abstract class Vehicle {
    protected int currYear = 2020;
    protected int age;
    protected int gasRemained = 0;
    protected int gasConsumedPerHour;
    protected int totalGasConsumed = 0;
    protected int maxGasAmountInTank;
    protected String type;
    protected String brand;

    // Constructor
    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.age = currYear - year;
    }

    // Method to get the age of the vehicle
    public int getAge() {
        return age;
    }

    // Method to get the remaining gas in the vehicle
    public int getGasRemained() {
        return gasRemained;
    }

    // Method to get the total gas consumed by the vehicle
    public int getTotalGasConsumed() {
        return totalGasConsumed;
    }

    // Abstract method to be overridden in subclasses
    public abstract void refuel(int amountOfGas);

    // Abstract method to be overridden in subclasses
    public abstract void run(int hours);

    // Equals method for comparing vehicles based on brand and type
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vehicle other = (Vehicle) o;
        return this.brand.equals(other.brand) && this.type.equals(other.type);
    }

    // toString method to return the vehicle type and brand
    public String toString() {
        return this.type + " " + this.brand;
    }
}
