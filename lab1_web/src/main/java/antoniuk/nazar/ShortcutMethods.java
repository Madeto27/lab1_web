package antoniuk.nazar;

import java.util.ArrayList;
import java.util.Scanner;

public class ShortcutMethods {
    public static Manufacturer chooseBrand(Scanner scanner, ArrayList<Manufacturer> manufacturers) {
        System.out.println("Choose brand:");
        for (int i = 0; i < manufacturers.size(); i++) {
            System.out.println((i + 1) + ". " + manufacturers.get(i).getName());
        }

        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice >= 1 && choice <= manufacturers.size()) {
            return manufacturers.get(choice - 1);
        } else {
            System.out.println("Invalid choice.");
            return chooseBrand(scanner, manufacturers);
        }
    }

    public static Auto chooseCar(Scanner scanner, ArrayList<Auto> allAutos) {
        if (allAutos.isEmpty()) {
            System.out.println("No cars available.");
            return null;
        }
    
        System.out.println("Choose a car: ");
        for (int i = 0; i < allAutos.size(); i++) {
            System.out.print((i + 1) + ". ");
            allAutos.get(i).seeInfo();
        }
    
        int carChoice = scanner.nextInt();
        scanner.nextLine();
    
        if (carChoice < 1 || carChoice > allAutos.size()) {
            System.out.println("Wrong input.");
            return null;
        }
    
        return allAutos.get(carChoice - 1);
    }
    
    public static ArrayList<Auto> getAllAutos(ArrayList<Manufacturer> manufacturers) {
        ArrayList<Auto> allAutos = new ArrayList<>();
        for (Manufacturer manufacturer : manufacturers) {
            allAutos.addAll(manufacturer.getCars());
        }
        return allAutos;
    }
}
