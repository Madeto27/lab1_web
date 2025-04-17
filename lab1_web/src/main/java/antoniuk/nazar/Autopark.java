package antoniuk.nazar;

import java.util.ArrayList;

public final class Autopark {
    private static Autopark instance;
    private int carCapacity;
    private double filled;
    private String location;
    private ArrayList<Auto> parkedAutos;

    public int getCarCapacity() {
        return carCapacity;
    }
    public void setCarCapacity(int newCapacity) {
        this.carCapacity = newCapacity;
    }

    public double getFilled() {
        return filled;
    }
    public void setFilled(double newFilled) {
        this.filled = newFilled;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String newLocation) {
        this.location = newLocation;
    }

    public ArrayList<Auto> getParkedAutos() {
        return parkedAutos;
    }
    public void setParkedAutos(ArrayList<Auto> parkedAutos) {
        this.parkedAutos = parkedAutos;
    }


    private Autopark(int carCapacity, String location) {
        this.carCapacity = carCapacity;
        filled = 0;
        this.parkedAutos = new ArrayList<>();
        this.location = location;
    }

    public static Autopark getAutopark(int carCapacity, String location) {
        if (instance == null) {
            instance = new Autopark(carCapacity, location);
        }
        return instance;
    }

    public void parkVehicle(Auto auto) {
        if (filled < 1) {
            parkedAutos.add(auto);
            double newFilled = (double)parkedAutos.size()/carCapacity;
            filled = newFilled;
            auto.setIsParked(true);
        }
    }

    public void changeLocation(String newLocation) {
        setLocation(newLocation);
        System.out.println("Autopark was relocated: " + newLocation);
    }

    public void seeInfo() {
        System.out.println("Location: " + location +
                           "\nVehicle capacity: " + carCapacity +
                           "\nFilled percentage: " + filled*100 + "%");
    }

    public static void reset() {
        instance = null;
    }
}
