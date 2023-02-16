package pl.javastart.task;

public class Truck extends Car {
    private double loadWeight;
    private static final double ADD_FUEL_WHEN_AC_IS_ON = 1.6;
    private static final double ADD_FUEL_WHEN_DRIVE_WITH_LOAD = 0.5;
    private static final double LOAD_100_KG = 100;

    public Truck(String name, double tankCapacity, double avgFuelConsumption, boolean isAcOn, double loadWeight) {
        super(name, tankCapacity, avgFuelConsumption, isAcOn);
        this.loadWeight = loadWeight;
    }

    public double getLoadWeight() {
        return loadWeight;
    }

    public void setLoadWeight(double loadWeight) {
        this.loadWeight = loadWeight;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Load: " + loadWeight + " kg");
    }

    @Override
    public double currentConsumption() {
        double totalConsumption = getAvgFuelConsumption();
        double loadWeight = getLoadWeight();
        if (isAcOn()) {
            totalConsumption += ADD_FUEL_WHEN_AC_IS_ON;
        }
        if (loadWeight >= LOAD_100_KG) {
            double fuelConsumptionWithLoad  = loadWeight / LOAD_100_KG * ADD_FUEL_WHEN_DRIVE_WITH_LOAD;
            return totalConsumption + fuelConsumptionWithLoad;
        }
        return totalConsumption;
    }
}