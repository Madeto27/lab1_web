package antoniuk.nazar;

public class Main {
    public static void main(String[] args) {

        
        //Auto myAuto = new Auto();
    
        Auto myAuto = new Auto("Ford", 50);

        myAuto.seeInfo();

        myAuto.ride(10);

        myAuto.seeInfo();

        myAuto.refuel(50);
        /*
        Autopark myPark = new Autopark(10, "Maidan st.");

        for (int i = 0; i < 10; i++) {
            myPark.addVehicle(myAuto);
        }
       

        System.out.println(myPark.getVehicleParked());
        myPark.seeInfo();
        */
        //System.out.println((double)1/10 * 100);
        //System.out.println(myAuto.getBrand());
        //System.out.println(myAuto.getFuelCapacity());
        //System.out.println(myAuto.getFuelLevel());
    }
}