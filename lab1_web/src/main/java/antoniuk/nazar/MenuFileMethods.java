package antoniuk.nazar;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuFileMethods {
    public static void exportCars(Scanner scanner, ArrayList<Manufacturer> manufacturers) {
        try {
            ArrayList<Auto> exportedAutos = new ArrayList<>();
            for (Manufacturer manufacturer : manufacturers) {
                for (Auto auto : manufacturer.getCars()) {
                    exportedAutos.add(auto);
                }
            }
            System.out.println("Enter file name: ");
            String fileName = scanner.nextLine();
            AutoIO.exportAutos(exportedAutos, fileName + ".json");
            System.out.println("Export completed.");
        } catch (Exception e) {
            System.out.println("Export failed.");
        }
    }

    public static void importCars(Scanner scanner, ArrayList<Manufacturer> manufacturers) {
        try {
            System.out.println("Enter file name: ");
            String fileName = scanner.nextLine();
            
            for (Manufacturer manufacturer : manufacturers) {   
                manufacturer.getCars().clear();
            }

            ArrayList<Auto> importedAutos = new ArrayList<>(AutoIO.importAutos(fileName + ".json"));

            for (Auto auto : importedAutos) {
                for (Manufacturer manufacturer : manufacturers) {
                    if (manufacturer.getName().equals(auto.getBrand())){
                        manufacturer.getCars().add(auto);
                        break;
                    }
                }
            }

            System.out.println("Import completed.");
        } catch (Exception e) {
            System.out.println("Import failed.");
        }
    }
}
