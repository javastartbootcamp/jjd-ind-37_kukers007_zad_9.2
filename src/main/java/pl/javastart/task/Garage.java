package pl.javastart.task;

public class Garage {

    public static void main(String[] args) {
        Car[] vehicles = new Car[10];
        vehicles[0] = new Car("BMW 525", 50, 5, false);
        vehicles[1] = new Car("AUDI A4", 55, 10, false);
        vehicles[2] = new Car("VW Passat", 60, 6, false);
        vehicles[3] = new Car("FORD Focus", 65, 7, false);
        vehicles[4] = new Car("Fiat Panda", 40, 5, false);
        vehicles[5] = new Truck("Star", 600, 50, false, 150);
        vehicles[6] = new Truck("Zuk", 600, 50, false, 200);
        vehicles[7] = new Truck("Nysa", 500, 25, false, 200);
        vehicles[8] = new Truck("MAN", 500, 25, false, 400);
        vehicles[9] = new Truck("SCANIA", 300, 30, false, 0);

        for (Car vehicle : vehicles) {
            System.out.println();
            vehicle.printInfo();
            vehicle.turnOnAc();
            System.out.println();
            vehicle.printInfo();
            System.out.println();
        }
    }
}