package antoniuk.nazar;

import java.util.Objects;

public class Auto {
    //fuel tank
    //fuel level
    //brand

    private String brand;
    private int fuelCapacity;
    private double fuelLevel;

    public String getBrand() {
        return brand;
    }
    public void setBrand(String newBrand) {
        this.brand = newBrand;
    }
    
    public int getFuelCapacity() {
        return fuelCapacity;
    }
    public void setFuelCapacity(int newFuelCap) {
        this.fuelCapacity = newFuelCap;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }
    public void setFuelLevel(int newFuelLevel) {
        this.fuelLevel = newFuelLevel;
    }

    

    public Auto(String brand, int fuelCapacity){
        this.brand = brand;
        this.fuelCapacity = fuelCapacity;
        this.fuelLevel = fuelCapacity;
    }


    public void ride(int dist){
        //lower fuel level
        double fuelSpent = dist * 0.5;

        if (fuelLevel >= fuelSpent) {
            fuelLevel -= fuelSpent;
            System.out.println("You rode " + dist + "km.");
        }
        else {
            System.out.println("*Not enough fuel.");
        }
    }

    public void seeInfo(){
        //display fuel and model info
        System.out.println("Brand: " + brand +
                           "\nFuel capacity: " + fuelCapacity +
                           "\nFuel level: " + fuelLevel);
    }

    public void refuel(int fuel){
        //pour fuel into tank
        int newLevel = fuelCapacity + fuel;
        if (fuel > 0) { 
            if (fuelCapacity >= newLevel){
                fuelLevel = newLevel;
            }
            else if (newLevel > fuelCapacity){
                fuelLevel = fuelCapacity;
            }
        }

        //set fuel level
        /*
        if (fuel > 0) { 
            fuelLevel = fuel;
            if (fuelLevel > fuelCapacity){
            fuelLevel = fuelCapacity;
            }
        }*/
    }


    @Override
    public int hashCode(){
        return Objects.hash(brand, fuelCapacity);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() !=   obj.getClass()) return false;
        Auto auto = (Auto) obj;

        return fuelCapacity == auto.fuelCapacity && (brand.equals(auto.brand));
    }
}
