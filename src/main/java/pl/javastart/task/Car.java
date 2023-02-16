package pl.javastart.task;

public class Car extends Vehicle {
    private boolean isAcOn;
    private static final double ADD_FUEL_CONSUMPTION_AC_IS_ON = 0.8;

    public Car(String name, double tankCapacity, double avgFuelConsumption, boolean isAcOn) {
        super(name, tankCapacity, avgFuelConsumption);
        this.isAcOn = isAcOn;
    }

    public boolean isAcOn() {
        return isAcOn;
    }

    public void setAcOn(boolean acOn) {
        isAcOn = acOn;
    }

    @Override
    public void turnOnAc() {
        isAcOn = true;
    }

    @Override
    public void turnAcOff() {
        isAcOn = false;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("With AC: " + isAcOn);
        System.out.println("Distance in KM (Full Tank): " + String.format("%.2f", distanceInKm()));
    }

    @Override
    double distanceInKm() {
        double avgFuelConsumptionWithAcOn = getAvgFuelConsumption() + ADD_FUEL_CONSUMPTION_AC_IS_ON;
        double avgFuelConsumption = getAvgFuelConsumption();
        double tankCapacity = getTankCapacity();
        double distance100km = 100;
        double carDistanceWithFullTank = (tankCapacity / avgFuelConsumption) * distance100km;
        if (isAcOn) {
            return (tankCapacity / avgFuelConsumptionWithAcOn) * distance100km;
        } else {
            return carDistanceWithFullTank;
        }
    }
}