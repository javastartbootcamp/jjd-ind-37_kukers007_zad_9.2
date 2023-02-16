package pl.javastart.task;

public class Vehicle {

    private String name;
    private double tankCapacity;
    private double avgFuelConsumption;
    static final double DISTANCE_100_KM = 100;

    public Vehicle(String name, double tankCapacity, double avgFuelConsumption) {
        this.name = name;
        this.tankCapacity = tankCapacity;
        this.avgFuelConsumption = avgFuelConsumption;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getAvgFuelConsumption() {
        return avgFuelConsumption;
    }

    public void setAvgFuelConsumption(double avgFuelConsumption) {
        this.avgFuelConsumption = avgFuelConsumption;
    }

    public double distanceInKm() {
        return getTankCapacity() / currentConsumption() * DISTANCE_100_KM;
    }

    public double currentConsumption() {
        return -1;
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Tank Capacity: " + tankCapacity);
        System.out.println("Average fuel consumption: " + avgFuelConsumption);
    }
}