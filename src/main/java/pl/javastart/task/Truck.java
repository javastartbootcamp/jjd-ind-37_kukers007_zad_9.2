package pl.javastart.task;

public class Truck extends Car {
    private double loadWeight;
    private static final double ADD_FUEL_WHEN_AC_IS_ON = 1.6;
    private static final double ADD_FUEL_WHEN_DRIVE_WITH_LOAD = 0.5;
    private static final double LOAD_IN_KG = 100;

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
    public void turnOnAc() {
        if (!isAcOn()) {
            setAcOn(true);
            setAvgFuelConsumption(getAvgFuelConsumption() + ADD_FUEL_WHEN_AC_IS_ON);
        }
    }

    @Override
    public void turnOffAc() {
        if (isAcOn()) {
            setAcOn(false);
            setAvgFuelConsumption(getAvgFuelConsumption() - ADD_FUEL_WHEN_AC_IS_ON);
        }
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Load: " + loadWeight + " kg");
    }

    @Override
    public double currentConsumption() {
        double avgFuelConsumption = getAvgFuelConsumption();
        double avgFuelConsumptionWithAcOn = getAvgFuelConsumption() + ADD_FUEL_WHEN_AC_IS_ON;
        double addFuelConsumptionWhenDriveWithLoad = getLoadWeight() / LOAD_IN_KG * ADD_FUEL_WHEN_DRIVE_WITH_LOAD;
        if (isAcOn() && loadWeight > 0) {
            return avgFuelConsumptionWithAcOn + addFuelConsumptionWhenDriveWithLoad;
        } else if (isAcOn()) {
            return avgFuelConsumptionWithAcOn;
        } else if (!isAcOn() && loadWeight > 0) {
            return avgFuelConsumption + addFuelConsumptionWhenDriveWithLoad;
        } else {
            return avgFuelConsumption;
        }
    }
}