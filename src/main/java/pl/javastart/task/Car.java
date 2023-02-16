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

    public void turnOnAc() {
        if (!isAcOn) {
            isAcOn = true;
            setAvgFuelConsumption(getAvgFuelConsumption() + ADD_FUEL_CONSUMPTION_AC_IS_ON);
        }
    }

    public void turnOffAc() {
        if (isAcOn) {
            isAcOn = false;
            setAvgFuelConsumption(getAvgFuelConsumption() - ADD_FUEL_CONSUMPTION_AC_IS_ON);
        }
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("With AC: " + isAcOn);
        System.out.println("Distance in KM (Full Tank): " + String.format("%.2f", distanceInKm()));
    }

    @Override
    public double currentConsumption() {
        double avgFuelConsumption = getAvgFuelConsumption();
        if (isAcOn) {
            avgFuelConsumption += ADD_FUEL_CONSUMPTION_AC_IS_ON;
        }
        return avgFuelConsumption;
    }
}