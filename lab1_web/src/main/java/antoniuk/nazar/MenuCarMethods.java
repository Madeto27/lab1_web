package antoniuk.nazar;

import java.util.ArrayList;
import java.util.Scanner;

import static antoniuk.nazar.ShortcutMethods.chooseBrand;
import static antoniuk.nazar.ShortcutMethods.chooseCar;
import static antoniuk.nazar.ShortcutMethods.getAllAutos;

public class MenuCarMethods {

    public static void refuelCar(Scanner scanner, ArrayList<Manufacturer> manufacturers) {
        ArrayList<Auto> allAutos = getAllAutos(manufacturers);
        Auto selectedCar = chooseCar(scanner, allAutos);
        if (selectedCar == null) {
            return;
        }
        if (!selectedCar.getIsParked()) {
            System.out.println("Park car first");
            return;
        }
        System.out.println("Enter amount to refuel: ");
        int amount = scanner.nextInt();
        scanner.nextLine();
        selectedCar.refuel(amount);
        System.out.println("Fuel in tank: " + selectedCar.getFuelLevel() + "/" + selectedCar.getFuelCapacity());
    }

    public static void addCar(Scanner scanner, ArrayList<Manufacturer> manufacturers) {
        Manufacturer selectedBrand = chooseBrand(scanner, manufacturers);
        System.out.print("Enter fuel capacity: ");
        int cap = scanner.nextInt();
        selectedBrand.produceCar(selectedBrand.getName(), cap);
    }

    public static void showManufacturerCars(Scanner scanner, ArrayList<Manufacturer> manufacturers) {
        Manufacturer selectedBrand = chooseBrand(scanner, manufacturers);
        System.out.println("--------------");
        for (Auto auto : selectedBrand.getCars()) {
            auto.seeInfo();
            System.out.println("--------------");
        }
    }

    public static void showAllCars(ArrayList<Manufacturer> manufacturers) {
        for (Manufacturer manufacturer : manufacturers) {
            System.out.println("- List of " + manufacturer.getName() + " cars:");
            System.out.println("--------------");
            for (Auto auto : manufacturer.getCars()) {
                auto.seeInfo();
                System.out.println("--------------");
            }
        }
    }

    public static void rideCar(Scanner scanner, ArrayList<Manufacturer> manufacturers) {
        ArrayList<Auto> allAutos = getAllAutos(manufacturers);
        Auto selectedCar = chooseCar(scanner, allAutos);
        if (selectedCar == null) {
            return;
        }
        System.out.println("Enter distance to drive: \nFuel consumption 1/2 from distance*");
        int distance = scanner.nextInt();
        scanner.nextLine();
        selectedCar.ride(distance);
        System.out.println("Fuel left: " + selectedCar.getFuelLevel() + "/" + selectedCar.getFuelCapacity());
    }

    public static void parkCar(Scanner scanner, ArrayList<Manufacturer> manufacturers, Autopark autopark) {
        //park auto
        ArrayList<Auto> allAutos = getAllAutos(manufacturers);
        allAutos.removeAll(autopark.getParkedAutos());
        Auto selectedCar = chooseCar(scanner, allAutos);
        if (selectedCar == null) {
            return;
        }
        autopark.parkVehicle(selectedCar);
        System.out.println("Car parked at ");
        autopark.seeInfo();
    }
}
