package antoniuk.nazar;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Auto> autos = new ArrayList<>();
        boolean running = true;

        Manufacturer ford = new Manufacturer("Ford", "USA");
        Manufacturer toyota = new Manufacturer("Toyota", "Japan");
        Manufacturer audi = new Manufacturer("Audi", "Germany");
        ArrayList<Manufacturer> manufacturers = new ArrayList<>();
        manufacturers.add(ford);
        manufacturers.add(toyota);
        manufacturers.add(audi);

        while (running) {
            System.out.println("\n1. Add car\n2. Show cars\n3. Show all cars\n7. Ride car\n4. Export\n5. Import\n6. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Manufacturer selectedBrand = chooseBrand(scanner, ford, toyota, audi);
                    System.out.print("Enter fuel capacity: ");
                    int cap = scanner.nextInt();
                    selectedBrand.produceCar(selectedBrand.getName(), cap);
                    break;
                case 2:
                    selectedBrand = chooseBrand(scanner, ford, toyota, audi);
                    for (Auto auto : selectedBrand.getCars()) {
                        auto.seeInfo();
                    }
                    break;
                case 3:
                    for (Manufacturer manufacturer : manufacturers) {
                        System.out.println("- List of " + manufacturer.getName() + " cars:");
                        for (Auto auto : manufacturer.getCars()) {
                            auto.seeInfo();
                        }
                    }
                    break;
                case 7:
                    //drive
                    break;
                
                case 4:
                    try {
                        for (Manufacturer manufacturer : manufacturers) {
                            for (Auto auto : manufacturer.getCars()) {
                                autos.add(auto);
                            }
                        }
                        AutoIO.exportAutos(autos, "autos.json");
                        System.out.println("Export completed.");
                    } catch (Exception e) {
                        System.out.println("Export failed.");
                    }
                    break;
                case 5:
                    try {
                        autos = new ArrayList<>(AutoIO.importAutos("autos.json"));
                        System.out.println("Import completed.");
                    } catch (Exception e) {
                        System.out.println("Import failed.");
                    }
                    break;
                case 6:
                    running = false;
                    break;
            }
        }
    }

    public static Manufacturer chooseBrand(Scanner scanner, Manufacturer ford, Manufacturer toyota, Manufacturer audi) {
        Manufacturer selectedBrand = null;
        while (selectedBrand == null) {
            System.out.println("Choose brand:\n1. Ford\n2. Toyota\n3. Audi");
            int brandChoice = scanner.nextInt();
            switch (brandChoice) {
                case 1:
                    selectedBrand = ford;
                    break;
                case 2:
                    selectedBrand = toyota;
                    break;
                case 3:
                    selectedBrand = audi;
                    break;
                default:
                    System.out.println("Try again.");
            }
        }
        return selectedBrand;
    }
}