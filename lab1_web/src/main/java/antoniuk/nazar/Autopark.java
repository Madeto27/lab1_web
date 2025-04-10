package antoniuk.nazar;

import java.util.ArrayList;

public final class Autopark {
    //vehicle capacity
    //location?
    //filled percentage

    private static Autopark instance;
    private int carCapacity;
    private double filled;
    private String location;
    private ArrayList<Auto> cars;

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

    public ArrayList<Auto> getCars() {
        return cars;
    }
    public void setCars(ArrayList<Auto> cars) {
        this.cars = cars;
    }


    private Autopark(int carCapacity, String location) {
        this.carCapacity = carCapacity;
        filled = 0;
        this.cars = new ArrayList<>();
        this.location = location;
    }

    public static Autopark getAutopark(int carCapacity, String location){
        if (instance == null) {
            instance = new Autopark(carCapacity, location);
        }
        return instance;
    }


    public void addVehicle(Auto auto){
        if (filled < 1) {
            cars.add(auto);
            double newFilled = (double)cars.size()/carCapacity;
            filled = newFilled;
            System.out.println("New filled percentage: " + filled*100 + "%");
        }
    }

    public void changeLocation(String newLocation){
        //change location
        setLocation(newLocation);
        System.out.println("Autopark was relocated: " + newLocation);
    }

    public void seeInfo(){
        //display location, capacity and percantage
        System.out.println("Location: " + location +
                           "\nVehicle capacity: " + carCapacity +
                           "\nFilled percentage: " + filled*100 + "%");
    }
}
