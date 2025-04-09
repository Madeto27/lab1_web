package antoniuk.nazar;

public class Autopark {
    //vehicle capacity
    //location?
    //filled percentage
    private int vehicleCapacity;
    private int vehicleParked;
    private double filled;
    private String location;


    public int getVehicleCapacity() {
        return vehicleCapacity;
    }
    public void setVehicleCapacity(int newCapacity) {
        this.vehicleCapacity = newCapacity;
    }
    
    public int getVehicleParked() {
        return vehicleParked;
    }
    public void setVehicleParked(int newParked) {
        this.vehicleParked = newParked;
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


    public Autopark(){
    }

    public Autopark(int vehicleCapacity, String location){
        this.vehicleCapacity = vehicleCapacity;
        this.location = location;
    }


    public void addVehicle(Auto auto){
        if (filled < 1) {
            vehicleParked += 1;
            double newFilled = (double)vehicleParked/vehicleCapacity;
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
                           "\nVehicle capacity: " + vehicleCapacity +
                           "\nFilled percentage: " + filled*100 + "%");
    }
}
