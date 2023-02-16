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
        super.turnOnAc();
    }

    @Override
    public void turnAcOff() {
        super.turnAcOff();
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Load: " + loadWeight + " kg");
    }

    @Override
    double distanceInKm() {
        double tankCapacity = getTankCapacity();
        double distance100km = 100;
        double avgFuelConsumptionWithAcOn = getAvgFuelConsumption() + ADD_FUEL_WHEN_AC_IS_ON;
        double multiplierFor100KgLoad = getLoadWeight() / LOAD_IN_KG;
        double addFuelConsumptionWhenDriveWithLoad = multiplierFor100KgLoad * ADD_FUEL_WHEN_DRIVE_WITH_LOAD;
        double avgFuelConsumption = getAvgFuelConsumption();
        double carDistanceWithFullTank = (tankCapacity / avgFuelConsumption) * distance100km;
        if (isAcOn() && loadWeight > 0) {
            return (tankCapacity / (avgFuelConsumptionWithAcOn + addFuelConsumptionWhenDriveWithLoad)) * distance100km;
        } else if (isAcOn()) {
            return (tankCapacity / avgFuelConsumptionWithAcOn) * distance100km;
        } else if (!isAcOn() && loadWeight > 0) {
            return (tankCapacity / (avgFuelConsumption + addFuelConsumptionWhenDriveWithLoad)) * distance100km;
        } else {
            return carDistanceWithFullTank;
        }
    }
}