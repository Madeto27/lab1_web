package antoniuk.nazar;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuHandler {
    private Scanner scanner;
    private ArrayList<Manufacturer> manufacturers;
    private Autopark autopark;

    public MenuHandler(Scanner scanner, ArrayList<Manufacturer> manufacturers, Autopark autopark) {
        this.scanner = scanner;
        this.manufacturers = manufacturers;
        this.autopark = autopark;
    }

    public void run() {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            running = handleChoice(choice);
        }
    }

    private void printMenu() {
        System.out.println("\n1. Add car\n2. Show cars\n3. Show all cars\n4. Ride car\n5. Refuel car\n6. Park car\n7. Export\n8. Import\n9. Exit");
    }

    private boolean handleChoice(int choice) {
        switch (choice) {
            case 1: MenuCarMethods.addCar(scanner, manufacturers); break;
            case 2: MenuCarMethods.showManufacturerCars(scanner, manufacturers); break;
            case 3: MenuCarMethods.showAllCars(manufacturers); break;
            case 4: MenuCarMethods.rideCar(scanner, manufacturers); break;
            case 5: MenuCarMethods.refuelCar(scanner, manufacturers); break;
            case 6: MenuCarMethods.parkCar(scanner, manufacturers, autopark); break;
            case 7: MenuFileMethods.exportCars(scanner, manufacturers);break;
            case 8: MenuFileMethods.importCars(scanner, manufacturers); break;
            case 9: return false;
        }
        return true;
    }
}
