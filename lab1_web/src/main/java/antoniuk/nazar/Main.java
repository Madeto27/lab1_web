package antoniuk.nazar;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Manufacturer> manufacturers = new ArrayList<>();
        
        manufacturers.add(new Manufacturer("Ford", "USA"));
        manufacturers.add(new Manufacturer("Toyota", "Japan"));
        manufacturers.add(new Manufacturer("Audi", "Germany"));

        Autopark autopark = Autopark.getAutopark(10, "Yulii Zdanovskoi St.");
        MenuHandler menuHandler = new MenuHandler(scanner, manufacturers, autopark);
        menuHandler.run();
    }
}