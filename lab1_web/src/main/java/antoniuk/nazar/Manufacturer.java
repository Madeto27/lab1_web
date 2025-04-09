package antoniuk.nazar;

import java.util.ArrayList;
import java.util.Objects;

public class Manufacturer {
    //name
    //owner
    //cars produced

    private String name;
    private String country;
    private int carsProduced;
    private ArrayList<Auto> cars;

    public String getName() {
        return name;
    }
    public void setName(String newName) {
        name = newName;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String newCountry) {
        country = newCountry;
    }

    public int getCarsProduced() {
        return carsProduced;
    }
    public void setCarsProduced(int newCarsProduced) {
        carsProduced = newCarsProduced;
    }

    public ArrayList<Auto> getCars() {
        return cars;
    }
    public void setCars(ArrayList<Auto> cars) {
        this.cars = cars;
    }


    public Manufacturer(String name, String country) {
        this.name = name;
        this.country = country;
        this.carsProduced = 0;
        this.cars = new ArrayList<>();
    }


    public void produceCar(String brand, int fuelCap){
        //change produced vehicle amount 
        carsProduced++;
        Auto newAuto = new Auto(brand, fuelCap);
        cars.add(newAuto);
    }

    public void rebranding(String newName){
        //change name
        setName(newName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Manufacturer manu = (Manufacturer) obj;
        return name.equals(manu.name) && country.equals(manu.country);
    }
}
