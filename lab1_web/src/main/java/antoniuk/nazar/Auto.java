package antoniuk.nazar;

public class Auto {
    //fuel tank
    //fuel level
    //brand

    private String brand;
    private int fuelCapacity;
    private int fuelLevel;

    public String getBrand() {
        return brand;
    }
    private void setBrand(String newBrand) {
        this.brand = newBrand;
    }
    
    public int getFuelCapacity() {
        return fuelCapacity;
    }
    private void setFuelCapacity(int newFuelCap) {
        this.fuelCapacity = newFuelCap;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }
    private void setFuelLevel(int newFuelLevel) {
        this.fuelLevel = newFuelLevel;
    }


    void ride(){
        //lower fuel level
        System.out.println("*Wroom wroom*");
        fuelLevel -= 10;
    }

    void info(){
        //display fuel and model info
        System.out.println("Brand: " + brand +
                           "\nFuel capacity: " + fuelCapacity +
                           "\nFuel level: " + fuelLevel);
    }

    void refuel(int fuel){
        //set fuel level
        if (fuel > 0) { 
            fuelLevel = fuel;
            if (fuelLevel > fuelCapacity){
            fuelLevel = fuelCapacity;
            }
        }
    }
}
